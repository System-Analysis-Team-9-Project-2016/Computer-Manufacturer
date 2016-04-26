package systemAnalysis;

import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class AddNewProductUI {
	
	private JButton SUBMIT; 
	private JLabel label0 , label1 , label2 , label3;
	private JTextField  text1 , text2 , text0 , text3;
	private JPanel labelPanel, fieldPanel;
  	
  	JPanel inputControls;
	
	public AddNewProductUI(Admin a){
		
		labelPanel = new JPanel(new GridLayout(0,1,3,3));
	    fieldPanel = new JPanel(new GridLayout(0,1,3,3));
	    
	    inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
		
	}
	
	
	public void display() throws IOException{
	  	
	  	JPanel inputControls;
	  	
	  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
	    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
	    
	    inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
	  	
    	
    	label0 = new JLabel();
    	label0.setText("Enter Product Name:");
	  	label1 = new JLabel();
   		label1.setText("Enter Cost:");
   		label2 = new JLabel();
    	label2.setText("Stock");
    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		text2 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		labelPanel.add(label2);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		fieldPanel.add(text2);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		AddNewProduct a = new AddNewProduct();
	    		String name;
	    		double cost;
	    		int stock;
	    		name = text0.getText();
	    		cost = Double.parseDouble(text1.getText());
	    		stock = Integer.parseInt( text2.getText());
	    		try{
	    		if(a.validateProduct(name , cost , stock))
	    			switch( a.process(name , cost , stock)){
	    			case "CPU": displayAddCPU(a);break;
	    			case "MON": displayAddMonitor(a);break;
	    			case "RAM": displayAddRam(a);break;
	    			case "MTR": displayAddMotherboard(a);break;
	    			};
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New Product"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New Product Page");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
        
		
	}
	
	public void displayAddCPU(final AddNewProduct a){
	  	
	  	
    	
    	label0 = new JLabel();
    	label0.setText("Enter CPU Series:");
	  	label1 = new JLabel();
   		label1.setText("Enter CPU Socket Type");
   		label2 = new JLabel();
    	label2.setText("Enter Operating Frequency");
    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		text2 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		labelPanel.add(label2);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		fieldPanel.add(text2);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		String result;
	    		result = text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New CPU"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New CPU");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
	}
	
	public void displayAddMonitor(final AddNewProduct a){
		
		label0 = new JLabel();
    	label0.setText("Enter Screen Resolution:");
	  	label1 = new JLabel();
   		label1.setText("Is it curved(true/false)");
   		label2 = new JLabel();
    	label2.setText("Is it 3d (true/false)");
    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		text2 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		labelPanel.add(label2);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		fieldPanel.add(text2);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		String result;
	    		result = text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New CPU"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New Monitor");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
		
	}
	
	public void displayAddRam(final AddNewProduct a){
		label0 = new JLabel();
    	label0.setText("Enter Type:");
	  	label1 = new JLabel();
   		label1.setText("Multi Channel:");
   		label2 = new JLabel();
    	label2.setText("casLatency:");
    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		text2 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		labelPanel.add(label2);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		fieldPanel.add(text2);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		String result;
	    		result = text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New RAM"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New RAM");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
		
	}
	
	public void displayAddMotherboard(final AddNewProduct a){
		label0 = new JLabel();
    	label0.setText("Enter cpu Socket Type:");
	  	label1 = new JLabel();
   		label1.setText("Series:");
   		label2 = new JLabel();
    	label2.setText("Form Factor:");
    	label3 = new JLabel();
    	label3.setText("Memory Standard:");
    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		text2 = new JTextField(15);
   		text3 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		labelPanel.add(label2);
   		labelPanel.add(label3);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		fieldPanel.add(text2);
   		fieldPanel.add(text3);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		String result;
	    		result = text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New Motherboard"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New Motherboard");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
		
	}
}
