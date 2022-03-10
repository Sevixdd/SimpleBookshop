package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowFilter;

public class ShoopingBasket  {

	JFrame f =new JFrame("Shooping");
	JLabel label = new JLabel("Your shooping list is : ");
	JButton pay =  new JButton("Pay");
	JButton cancel =  new JButton("Cancel");
	JButton back = new JButton("Back");
	JPanel flowPanel = new JPanel(new FlowLayout());
	GridBagConstraints c = new GridBagConstraints();
	String text;
	Date date = new Date(); 
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	public ShoopingBasket() throws IOException{
		f.setLayout(new GridBagLayout());
		LaunchLogin user = new LaunchLogin();
		user.frame.dispose();
		MainMenu sh = null;
		try {
			sh = new MainMenu();
			sh.f.dispose();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		JLabel shoopinglabel = new JLabel(multiLineLabel(sh.books));
		JLabel pricelabel = new JLabel("Total price of: "+String.valueOf(sh.price));
		
		
		class Action implements ActionListener{
		    public void actionPerformed(ActionEvent e) {//buttons
		    	if(e.getSource() == pay) {// go to pay frame
		    		
		    		Pay pay = new Pay();
		    		sh.books ="";
		    		f.dispose();
		    		
		    	}
		    	else if(e.getSource() == cancel) {// reset basket, write in Activity log and go back
		    		text = user.user + ", "+ sh.price +", " +"Canceled"
		    	+", "+ formatter.format(date);
		    		try {
						sh.saveToFile("ActivityLog.txt", text);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		sh.price = 0;
		    		sh.books ="";
		    		f.dispose();
		    		try {
						MainMenu ch = new MainMenu();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	else if(e.getSource() == back) {// go back without reseting shooping basket

		    		f.dispose();
		    		try {
						MainMenu sho = new MainMenu();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    }
		}
		
		back.addActionListener(new Action());
		pay.addActionListener(new Action());
		cancel.addActionListener(new Action());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		f.add(label,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 150;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		f.add(shoopinglabel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.gridy = 2;       //third row
		f.add(pricelabel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.gridy = 3;       //third row
		f.add(pay,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;//reset to default
		c.insets = new Insets(25,0,0,0);
		c.gridy = 4;       //third row
		f.add(cancel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;//reset to default
		c.insets = new Insets(25,0,0,0);
		c.gridy = 5;       //third row
		f.add(back,c);
		//panel.add(shoopinglabel,c);
		
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		shoopinglabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		pricelabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		cancel.setPreferredSize(new Dimension(200,50));
		pay.setPreferredSize(new Dimension(200,50));
		
		f.add(flowPanel);
		f.setSize(1600, 900);
	    f.setVisible(true);
	}
	public static void main(String[] args) {
		
		
		try {
			new ShoopingBasket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String multiLineLabel(String text)// showing label on multiple lines
	{
	    return "<html>" + text.replaceAll("/", "<br>");
	}
}
