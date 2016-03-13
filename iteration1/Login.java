import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
  
class Login extends JFrame implements ActionListener
{
	JButton SUBMIT, REGISTER;
  	JPanel panel;
  	Customer c1 = new Customer ("Cian", "Prendergast","cianp94@gmail.com","cian","123abc");
  	Customer c2 = new Customer ("Conor", "Duggan","conord@gmail.com","conor","123abc");
  	Customer c3 = new Customer ("Daniel", "O' Connor","dan@gmail.com","daniel","123abc");
  	Customer c4 = new Customer ("Darren", "Stack","darren@gmail.com","darren","123abc");
  	Customer c5 = new Customer ("Mike", "Lucas","mike@gmail.com","mike","123abc");
   	ArrayList<Customer> cList = new ArrayList<Customer>();
   	JLabel label1,label2;
  	final JTextField  text1,text2;
   	JPanel inputControls;
   	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));

   	Login()
   	{	
   		inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
   		
   		cList.add(c1);
   		cList.add(c2);
   		cList.add(c3);
   		cList.add(c4);
   		cList.add(c5);
   		
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

        JFrame averageFrame = new JFrame("Login Page");
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
   		int index = getCustIndex(cList, enteredEmail);
   		
   		if(action == 1) 
   		{
   			if(!isCustomer(cList, enteredEmail))
   			{
   				JOptionPane.showMessageDialog(this,"User not found", "Error",JOptionPane.ERROR_MESSAGE);
   			}
   				
   			if(cList.get(index).getPassword().compareTo(enteredPassword) != 0)
   				JOptionPane.showMessageDialog(this,"Password not correct", "Error",JOptionPane.ERROR_MESSAGE);
   			
   			else {
   				ProductUI frame=new ProductUI(cList.get(index));
   				frame.setSize(300,600);
   				frame.setVisible(false);
   			}
   		}
   		
   		else {
   			try {
   				text1.setText("");
   				text2.setText("");
   				RegisterUI frame=new RegisterUI();
   				frame.setSize(300,600);
   				frame.setVisible(false);
   			}
   			catch(Exception e){
   				JOptionPane.showMessageDialog(null, e.getMessage());
   			}
   		}
   	}
   	
   	boolean isCustomer(ArrayList<Customer> custList, String email)
   	{
   		boolean found = false;
   		
   		for(int i = 0;i < custList.size();i++) {
   			if((custList.get(i).getEmail()).compareTo(email) == 0)
   				found = true;
   		}
   		return found;
   	}
   	
   	int getCustIndex(ArrayList<Customer> custList, String email)
   	{
   		boolean found = false;
   		int index = 0;
   		for(int i = 0;i < custList.size()&& !found;i++) {
   			if((custList.get(i).getEmail()).compareTo(email) == 0) {
   				found = true;
   				index = i;
   			}
   		}
   		return index;
   	}
}