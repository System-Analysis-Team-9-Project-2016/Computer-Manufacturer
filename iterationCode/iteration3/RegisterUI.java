import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

class RegisterUI extends JFrame implements ActionListener 
{
  	JLabel label1,label2, label3,label4,label5,label6;
  	final JTextField  text1,text2,text3,text4,text5,text6;
  	JPanel inputControls;
  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
    private final JFrame averageFrame;
    
  	RegisterUI()
  	{
  		inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
    	Customer c;
    	
  		label1 = new JLabel();
   		label1.setText("First Name:");
   		text1 = new JTextField(15);
   		
   		label2 = new JLabel();
   		label2.setText("Surname:");
   		text2 = new JTextField(15);
   		
   		label3 = new JLabel();
   		label3.setText("Email Address:");
   		text3 = new JTextField(15);
   		
   		label4 = new JLabel();
   		label4.setText("Password:");
   		text4 = new JPasswordField(15);
   		
   		label5 = new JLabel();
   		label5.setText("Confirm Password:");
   		text5 = new JPasswordField(15);
   		
   		label6 = new JLabel();
   		label6.setText("Credit Card Number:");
   		text6 = new JTextField(15);
   		
   		labelPanel.add(label1);
   		fieldPanel.add(text1);
   		labelPanel.add(label2);
   		fieldPanel.add(text2);
   		labelPanel.add(label3);
   		fieldPanel.add(text3);
   		labelPanel.add(label4);
   		fieldPanel.add(text4);
   		labelPanel.add(label5);
   		fieldPanel.add(text5);
   		labelPanel.add(label6);
   		fieldPanel.add(text6);
   		
   		String firstName=text1.getText();
   		String surname=text2.getText();
   		String email=text3.getText();
   		String password=text4.getText();
   		String creditCard=text6.getText();
   		
   		c = new Customer(firstName,surname,email,password,creditCard);
 
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		JButton SUBMIT = (new JButton("Submit"));
		JButton CANCEL = (new JButton("Cancel"));
        controls.add(SUBMIT);
        controls.add(CANCEL);
        
        SUBMIT.setActionCommand("1");
   		CANCEL.setActionCommand("2");

        JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Register for an account"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        averageFrame = new JFrame("Register");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        averageFrame.setVisible(true);
   		
   		SUBMIT.addActionListener(this);
   		CANCEL.addActionListener(this);
   		
   		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	}
  	
  	public void actionPerformed(ActionEvent ae)
   	{
   		int action = Integer.parseInt(ae.getActionCommand());
   		if(action == 1)
   		{
   			String value1=text4.getText();
   			String value2=text5.getText();
   			String firstName=text1.getText();
   			String surname=text2.getText();
   			String password=text4.getText();
   			String creditCard=text6.getText();
   			String email=text3.getText();
   			
   			Register r = new Register(firstName,surname,email,value1,value2,creditCard);
        averageFrame.dispose(); 
   		}
   		
   		else if(action == 2) {
   			averageFrame.dispose();
   		}
 	}
}