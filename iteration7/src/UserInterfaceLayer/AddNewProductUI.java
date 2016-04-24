package UserInterfaceLayer;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import BusinessLayer.AddNewProduct;
import BusinessLayer.CustomerClasses.Admin;


public class AddNewProductUI {
	
	private JButton SUBMIT; 
	private JLabel label0 , label1 , label2 , label3;
	private JTextField  text1 , text2 , text0 , text3;
	private JPanel labelPanel, fieldPanel;
	private Admin adminUser;
  	
  	JPanel inputControls;
	
	public AddNewProductUI(Admin a){
		this.adminUser = a;
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

        JFrame averageFrameMain = new JFrame("New Product Page");
   		
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
	    		System.out.println("[info]  : ------ Submit button clicked (AddNewProductUI Admin) ------");
	    		AddNewProduct a = new AddNewProduct();
	    		String name;
	    		double cost;
	    		int stock;
	    		name = text0.getText();
	    		cost = Double.parseDouble(text1.getText());
	    		stock = Integer.parseInt( text2.getText());
	    		averageFrameMain.setVisible(false);
	    		try{
	    		if(a.validateProduct(name))
	    			switch( a.process(name , cost , stock)){
	    			case "CPU": displayAddCPU(a);break;
	    			case "Monitor": displayAddMonitor(a);break;
	    			case "RAM": displayAddRam(a);break;
	    			case "Motherboard": displayAddMotherboard(a);break;
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

        averageFrameMain.setContentPane(gui);
        averageFrameMain.pack();
        averageFrameMain.setLocationByPlatform(true);
        averageFrameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrameMain.setVisible(true);
		
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

        JFrame averageFrame = new JFrame("New CPU");
        
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
	    		result = "," +  text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    			 averageFrame.setVisible(false);
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

        JFrame averageFrame = new JFrame("New Monitor");
   		
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
	    		result = "," +  text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    			 averageFrame.setVisible(false);
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

        JFrame averageFrame = new JFrame("New RAM");
   		
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
	    		result = "," +  text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		try{
	    			 a.addProduct(result);
	    			 averageFrame.setVisible(false);
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

        JFrame averageFrame = new JFrame("New Motherboard");
   		
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
	    		result = "," +  text0.getText();
	    		result += "," +  text1.getText();
	    		result += "," +  text2.getText();
	    		result += "," +  text3.getText();
	    		try{
	    			 a.addProduct(result);
	    			 averageFrame.setVisible(false);
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

        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
		
	}
}