package UserInterfaceLayer;

import BusinessLayer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
  
@SuppressWarnings({ "unused", "serial" })
public class LoginUI extends JFrame implements ActionListener
{
	JButton SUBMIT, REGISTER;
  	JPanel panel;
   	JLabel label1,label2;
  	final JTextField  text1,text2;
   	JPanel inputControls;
   	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
    JFrame averageFrame;

   	public LoginUI() {
   		System.out.println("[debug] : ****** Entering LoginUI Class ******");
   		
   		inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
   		
   		label1 = new JLabel();
   		label1.setText("Email Address:");
   		text1 = new JTextField(15);
 
   		label2 = new JLabel();
   		label2.setText("Password:");
   		text2 = new JPasswordField(15);
   		
   		labelPanel.add(label1);
   		fieldPanel.add(text1);
   		labelPanel.add(label2);
   		fieldPanel.add(text2);
  
   		SUBMIT=new JButton("Submit");
   		REGISTER=new JButton("Register");
   
   		SUBMIT.setActionCommand("1");
   		REGISTER.setActionCommand("2");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        controls.add(REGISTER);
        
   		SUBMIT.addActionListener(this);
   		REGISTER.addActionListener(this);
   		
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Please Log In"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        averageFrame = new JFrame("Login Page");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
   	}
   	
  	public void actionPerformed(ActionEvent ae)
   	{
   		int action = Integer.parseInt(ae.getActionCommand());
   		String enteredEmail=text1.getText();
   		String enteredPassword=text2.getText();

      if(action == 1)
      {
        try {
			Login l = new Login(enteredEmail,enteredPassword);
		} 
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      else
      {
          text1.setText("");
          text2.setText("");
          averageFrame.setVisible(false);
          RegisterUI frame=new RegisterUI();
          frame.setSize(300,600);
          frame.setVisible(false);
        }
    }
}