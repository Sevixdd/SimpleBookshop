package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {
	public static float price = 0;
	int counti;//for showing buttons purposes
	String[] columnNames = {"ISBN"," book type", "title", "language", "genre",
			"release date", "price", "quantity in stock", 
			"additional information 1","additional information 2" };
	
	JFrame f =new JFrame("MainMenu");
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JPanel panel = new JPanel(new BorderLayout());
	JPanel leftpanel = new JPanel(new BorderLayout());
	JPanel insideBorder = new JPanel(new GridLayout(10, 1, 10, 10));
	JPanel addBook = new JPanel(new BorderLayout());
	JPanel panelbutton = new JPanel(new BorderLayout());
	JPanel panelfilter = new JPanel(new BorderLayout());
	JPanel panelGrid = new JPanel(new GridLayout(3, 3, 100, 100));
	JPanel searchpanel = new JPanel(new BorderLayout());
	JPanel flowPanel = new JPanel(new FlowLayout());
	JPanel flowPanel2 = new JPanel(new FlowLayout());
	JPanel flowPanel3 = new JPanel(new FlowLayout());
	JPanel flowPanel4 = new JPanel(new FlowLayout());
	JPanel flowPanel5 = new JPanel(new FlowLayout());
	JLabel noStock = new JLabel("No books of that kind in stock choose Other book");
	public static String books="";
	
	public static void saveToFile(String fileName, String text) throws IOException{
		
		File file = new File(fileName);
		FileWriter fileOut = new FileWriter(fileName, true);
		PrintWriter printFile = new PrintWriter(fileOut);
		
		printFile.println(text);
		printFile.close();
		
	}
	public MainMenu() throws FileNotFoundException {
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		Object[] rows =new Object[10];
		File inputFile = new File("Stock.txt");
		
		Scanner fileScanner = new Scanner(inputFile);
			
			LaunchLogin lau = new LaunchLogin();
			lau.frame.dispose();
			
			while (fileScanner.hasNextLine()) {//adding rows to table
				String[] details = fileScanner.nextLine().split(",") ;
				rows[0] = (details[0].trim());
				rows[1] = (details[1].trim());
				rows[2] = (details[2].trim());
				rows[3] = (details[3].trim());
				rows[4] = (details[4].trim());
				rows[5] = (details[5].trim());
				rows[6] = (details[6].trim());
				rows[7] = (details[7].trim());
				rows[8] = (details[8].trim());
				rows[9] = (details[9].trim());
				model.addRow(rows);
				}
		
			final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		    table.setRowSorter(sorter);
		    JLabel label = new JLabel("Filter");
		    JTextField filterText = new JTextField("");
		    JLabel labelbasket = new JLabel("----------------->"+"(select items from the table and "
		    		+ "then press the button to add them to shopping basket)");
		    
		    JButton button = new JButton("Search");
		    JButton addBookShowbutton = new JButton("Add Book");
		    JButton showbutton = new JButton("Search");
		    JButton addBookbutton = new JButton("Add Book");
		    JButton addBasket = new JButton("Add to basket ");
		    JButton back = new JButton("Back");
		    
		    JTextField ISBNtext = new JTextField("ISBN");
		    JTextField typetext = new JTextField("BookType");
		    JTextField titletext = new JTextField("Title");
		    JTextField languagetext = new JTextField("Language");
		    JTextField genretext = new JTextField("Genre");
		    JTextField releasetext = new JTextField("ReleaseDate");
		    JTextField pricetext = new JTextField("Price");
		    JTextField quantitytext = new JTextField("Quantity");
		    JTextField info1text = new JTextField("AditionalInfo1");
		    JTextField info2text = new JTextField("AditionalInfo2");
		    
		    panelGrid.add(ISBNtext);
     		panelGrid.add(typetext);
     		panelGrid.add(titletext);
     		panelGrid.add(languagetext);
     		panelGrid.add(genretext);
     		panelGrid.add(releasetext);
     		panelGrid.add(pricetext);
     		panelGrid.add(quantitytext);
     		panelGrid.add(info1text);
     		panelGrid.add(info2text);
     		panelGrid.add(addBookbutton);
     		panelGrid.setPreferredSize(new Dimension(300, 300));
     		
		    
		    
		    class Action implements ActionListener{//buttons
		    public void actionPerformed(ActionEvent e) {
		    	if(e.getSource() == button) {
		    		
		    		String text = filterText.getText();
		    		if (text.length() == 0) {
		    			sorter.setRowFilter(null);
		    		} else {
		    			sorter.setRowFilter(RowFilter.regexFilter(text));
		    		}
		    	}
		    	else if (e.getSource() == showbutton)//show search button
		    	{
		    		
		    		searchpanel.add(flowPanel,BorderLayout.NORTH);

				    panel.add(searchpanel,BorderLayout.SOUTH);
				    panelfilter.add(label, BorderLayout.WEST);
				    panelfilter.add(filterText, BorderLayout.CENTER);
				    panel.add(panelfilter,BorderLayout.NORTH);
		    		counti++;
		    		button.setVisible(true);
		    		filterText.setVisible(true);
			    	label.setVisible(true);
			    	ISBNtext.setVisible(false);
		    		typetext.setVisible(false);
			    	titletext.setVisible(false);
			    	languagetext.setVisible(false);
		    		genretext.setVisible(false);
			    	releasetext.setVisible(false);
			    	pricetext.setVisible(false);
		    		quantitytext.setVisible(false);
			    	info1text.setVisible(false);
			    	info2text.setVisible(false);
			    	addBookbutton.setVisible(false);
			    	
			    	
		    	}
		    	else if (e.getSource() == addBookShowbutton)// show add book button
		    	{
		    		
		    		searchpanel.add(panelGrid,BorderLayout.SOUTH);
		    		panel.add(searchpanel,BorderLayout.SOUTH);
		    		counti++;
		    		ISBNtext.setVisible(true);
		    		typetext.setVisible(true);
			    	titletext.setVisible(true);
			    	languagetext.setVisible(true);
		    		genretext.setVisible(true);
			    	releasetext.setVisible(true);
			    	pricetext.setVisible(true);
		    		quantitytext.setVisible(true);
			    	info1text.setVisible(true);
			    	info2text.setVisible(true);
			    	addBookbutton.setVisible(true);
			    	button.setVisible(false);
			    	filterText.setVisible(false);
			    	label.setVisible(false);
		    	}
		    	else if (e.getSource() == addBookbutton)// add book to Stock and table
		    	{
		    		Object[] newRow =new Object[10];
		    		newRow[0] = ISBNtext.getText() +", ";
		    		newRow[1] = typetext.getText() +", ";
		    		newRow[2] =  titletext.getText() +", ";
		    		newRow[3]= languagetext.getText() +", ";
		    		newRow[4]= releasetext.getText() +", ";		
		    		newRow[5]=genretext.getText()+", "	;	
		    		newRow[6]=pricetext.getText() +", "	;	
		    		newRow[7]=	quantitytext.getText()+", "	;
		   			newRow[8]=	 info1text.getText() +", ";	
		   			newRow[9]=info2text.getText();
		    		model.addRow(newRow);
		    		String sameTextString = ISBNtext.getText() +", " + typetext.getText() +", "
		    		+ titletext.getText() +", " + languagetext.getText() +", "
		    		+ releasetext.getText() +", " + genretext.getText() +", "
		    		+ pricetext.getText() +", " + quantitytext.getText() +", "
		    		+ info1text.getText() +", " + info2text.getText() +", ";
						try {
							saveToFile("stock.txt",sameTextString);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
		    	}
		    	else if(e.getSource() == addBasket)// add selected books to basket
		    	{
		    		int k=0;//qunatity counter
		    		TableModel model1 = table.getModel();
		    		int[] indexs = table.getSelectedRows();
		    	
		    		Object[] column = new Object[4];
		    		for(int i = 0; i < indexs.length; i++)
		            {
		                column[0] = model1.getValueAt(indexs[i], 1);

		                column[1] = model1.getValueAt(indexs[i], 2);

		                column[2] = model1.getValueAt(indexs[i], 6);
		                
		                if(Integer.parseInt((String) model1.getValueAt(indexs[i], 7)) == 0)
		                	{
		                	
		                	noStock.setVisible(true);
		                	k=1;// if there is no book in stock a message will appear
		                	}
		                else
		                {
		                books  = books + column[0] + ", " + column[1] + ", " + "price: " + column[2]+ "/";
		                price = price + Float.parseFloat((String) column[2]);
		                }
		                
		                
		            }
		    		if(k==0) {// if there is book in stock it will add it to basket
		    		f.dispose();
					try {
						f.dispose();
						ShoopingBasket shoopingBasket = new ShoopingBasket();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		}	
		    	}
		    	else if(e.getSource() == back) {

		    		f.dispose();
		    		try {
						LaunchLogin lau = new LaunchLogin();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		      }
		    }
		    
		    
		    
		    if(counti == 0) // set all buttons and textfields not visible from start
		    	{
		    	
		    	button.setVisible(false);
		    	filterText.setVisible(false);
		    	label.setVisible(false);
		    	ISBNtext.setVisible(false);
	    		typetext.setVisible(false);
		    	titletext.setVisible(false);
		    	languagetext.setVisible(false);
	    		genretext.setVisible(false);
		    	releasetext.setVisible(false);
		    	pricetext.setVisible(false);
	    		quantitytext.setVisible(false);
		    	info1text.setVisible(false);
		    	info2text.setVisible(false);
		    	addBookbutton.setVisible(false);
		    	}
		    
		    
		    showbutton.addActionListener(new Action());
		    addBookShowbutton.addActionListener(new Action());
		    addBookbutton.addActionListener(new Action());
		    addBasket.addActionListener(new Action());
		    back.addActionListener(new Action());
		    
		    noStock.setVisible(false);
		    flowPanel2.add(showbutton);
		    flowPanel3.add(addBookShowbutton);
		    flowPanel4.add(addBasket);
		    flowPanel5.add(back);
		    
		    //System.out.println(LaunchLogin.userType);
		  //if its admin the add book to basket button will dissapear
		    if(LaunchLogin.userType == "admin")
		    	addBasket.setVisible(false);
		  //if its customer the add book button will dissapear
		    if(LaunchLogin.userType == "Customer")
		    	addBookShowbutton.setVisible(false);
		    
		    insideBorder.add(noStock);
		    insideBorder.add( flowPanel2);
		    insideBorder.add( flowPanel3);
		    insideBorder.add(flowPanel4);
		    insideBorder.add(labelbasket);
		    insideBorder.add(flowPanel5);
		    
		    leftpanel.add(insideBorder,BorderLayout.CENTER);
		    button.setPreferredSize(new Dimension(300, 65));
		    button.addActionListener(new Action());
		    flowPanel.add(button);
		    
		    
		table.setBounds(30, 40, 200, 300);
		leftpanel.setPreferredSize(new Dimension (700,1000));
		f.add(leftpanel,BorderLayout.WEST);
		f.add(panel, BorderLayout.CENTER);
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        // Frame Size
        f.setSize(1600, 900);
        // Frame Visible = true
        f.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
	}
	
public static void main(String[] args) throws FileNotFoundException {
		
		new MainMenu();
	}
}
