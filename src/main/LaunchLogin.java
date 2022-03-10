package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class LaunchLogin implements ActionListener {
	int count = 0;
	public static String users[] = new String[10];
	public static String userType;
	public static String userid;
	public static String user;
	int i=0;
	JButton buttonAdmin = new JButton("Smith");
	JButton buttonCustomer = new JButton("Williams");
	JButton buttonCustomer2 = new JButton(" Taylor");
	JButton buttonCustomer3 = new JButton(" Lee");
	JPanel panel = new JPanel(new GridLayout(5,1,50,30));
	JFrame frame = new JFrame();
	public LaunchLogin() throws FileNotFoundException {
		
		File inputFile = new File("UserAccounts.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNextLine()) {
		String[] details = fileScanner.nextLine().split(",") ;
		
		users[i] = details[0] +"," +details[4]+", ";
		i++;
		}
		
		JLabel label = new JLabel("Select your User");
		
		buttonAdmin.addActionListener(this);
		buttonCustomer.addActionListener(this);
		buttonCustomer2.addActionListener(this);
		buttonCustomer3.addActionListener(this);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		

		panel.add(label);
		panel.add(buttonAdmin);
		panel.add(buttonCustomer);
		panel.add(buttonCustomer2);
		panel.add(buttonCustomer3);
		panel.setPreferredSize(new Dimension(200,450));
		
		frame.setSize(600,450);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BOOKSHOP");
		frame.pack();
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		frame.setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException  {
		new LaunchLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonAdmin)
		{
			userType = "admin";//because its admin the add to basket button in Main Menu will dissapear
			frame.dispose();
			try {
				MainMenu menuadm = new MainMenu();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			user = users[0];//gets the id and postcode of the user
		}
			
		if(e.getSource() == buttonCustomer)
		{
			userType = "Customer";//because its customer the add book button in Main Menu will dissapear
			frame.dispose();
			try {
				MainMenu menucust = new MainMenu();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			user = users[1];//gets the id and postcode of the user
		}
		if(e.getSource() == buttonCustomer2)
		{
			userType = "Customer";//because its customer the add book button in Main Menu will dissapear
			frame.dispose();
			try {
				MainMenu menuadm = new MainMenu();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			user = users[2];//gets the id and postcode of the user
		}
			
		if(e.getSource() == buttonCustomer3)
		{
			userType = "Customer";//because its customer the add book button in Main Menu will dissapear
			frame.dispose();
			try {
				MainMenu menucust = new MainMenu();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			user = users[3];//gets the id and postcode of the user
		}
	}

}
