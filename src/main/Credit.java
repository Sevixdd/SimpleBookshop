package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Credit {
	
	String text;
	Date date = new Date(); 
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); // initializing date
	JFrame f =new JFrame("Credit Card Payment");
	JPanel panel = new JPanel(new GridLayout(3,1,10,10));
	JTextField cardnumber = new JTextField("Enter your Card Number");
	JTextField cvv = new JTextField("Enter your security code");
	JButton submit = new JButton("Submit");
	JButton back = new JButton("Back");
	
	public Credit() throws FileNotFoundException {
		
		LaunchLogin user = new LaunchLogin();
		user.frame.dispose();
		MainMenu sh = null;
		try {
			sh = new MainMenu();
			sh.f.dispose();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		class Action implements ActionListener{
		    public void actionPerformed(ActionEvent e) {//buttons
		    	if(e.getSource() == submit) {// writes in ActivityLog the purschase
		    		
		    		JOptionPane.showMessageDialog(f,
		    			    "The amount of: "+ sh.price +" has been paid with CreditCard");
		    		text = user.user+ ", "+ sh.price +", "+" purchased "+", " 
		    			    +"Credit Card" +", "+ formatter.format(date);
		    		    		try {
		    						sh.saveToFile("ActivityLog.txt", text);
		    					} catch (IOException e1) {
		    						// TODO Auto-generated catch block
		    						e1.printStackTrace();
		    					}
		    	}
		    	else if(e.getSource() == back) {//go back

		    		f.dispose();
					Pay sho = new Pay();
		    	}
		    }
		}
		
		back.addActionListener(new Action());
		submit.addActionListener(new Action());
		panel.add(cardnumber);
		panel.add(cvv);
		panel.add(submit);
		panel.add(back);
		f.add(panel);
		f.setSize(400,400);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
