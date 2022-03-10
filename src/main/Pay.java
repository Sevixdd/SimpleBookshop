package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pay {
	JFrame f =new JFrame("Payment");
	JPanel pan = new JPanel(new BorderLayout());
	JButton paypal = new JButton("PayPal");
	JButton credit = new JButton("Credit Card");
	JButton back = new JButton("Back");
	JPanel flowPanel = new JPanel(new FlowLayout());
	JPanel flowPanel2 = new JPanel(new FlowLayout());
	
	public Pay(){
		
		
		class Action implements ActionListener{//buttons
		    public void actionPerformed(ActionEvent e) {
		    	if(e.getSource() == paypal) {//pay with paypal
		    		
		    		try {
						PayPal paypal = new PayPal();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		f.dispose();
		    		
		    	}
		    	else if(e.getSource() == credit) {// pay with credit
		    		try {
						Credit credit = new Credit();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		f.dispose();
		    	}
		    	else if(e.getSource() == back) {

		    		f.dispose();
		    		try {
						ShoopingBasket sho = new ShoopingBasket();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    }
		}
		
		back.addActionListener(new Action());
		paypal.addActionListener(new Action());
		credit.addActionListener(new Action());
		paypal.setPreferredSize(new Dimension(225,200));
		credit.setPreferredSize(new Dimension(225,200));
		flowPanel.add(credit);
		flowPanel2.add(paypal);
		pan.add(back,BorderLayout.SOUTH);
		pan.add(flowPanel,BorderLayout.WEST);
		pan.add(flowPanel2,BorderLayout.EAST);
		
		
		f.add(pan);
		f.setSize(700, 300);
		f.setVisible(true);
	}
public static void main(String[] args)  {
		
		new Pay();
	}
}
