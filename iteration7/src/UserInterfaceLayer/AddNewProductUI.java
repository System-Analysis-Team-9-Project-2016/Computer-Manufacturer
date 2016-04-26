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

        final JFrame averageFrameMain = new JFrame("New Product Page");
   		
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
	    			case "Keyboard": displayAddKeyboard(a);break;
	    			case "Speaker": displayAddSpeaker(a);break;
	    			case "Tablet": displayAddTablet(a);break;
	    			case "MemoryDrives": displayAddMemoryDrive(a);break;
	    			case "Mouse": displayAddMouse(a);break;
	    			case "GPU": displayAddGPU(a);break;
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

        final JFrame averageFrame = new JFrame("New CPU");
        
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

        final JFrame averageFrame = new JFrame("New Monitor");
   		
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

        final JFrame averageFrame = new JFrame("New RAM");
   		
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

        final JFrame averageFrame = new JFrame("New Motherboard");
   		
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
	
public void displayAddKeyboard(final AddNewProduct a){
		
		label0 = new JLabel();
    	label0.setText("Enter key Switch Type:");
	  	label1 = new JLabel();
   		label1.setText("Is it backlit(true/false)");

    	text0 = new JTextField(15);
   		text1 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		fieldPanel.add(text0);
   		fieldPanel.add(text1);
   		

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		String result;
	    		result = "," +  text0.getText();
	    		result += "," +  text1.getText();
	    		try{
	    			 a.addProduct(result);
	    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
	    		}
	    		catch(IOException ex){
	    			
	    		}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("New Keyboard"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("New Keyboard");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
		
	}

public void displayAddMemoryDrive(final AddNewProduct a){
	label0 = new JLabel();
	label0.setText("Is it for desktop?(true/false)");
  	label1 = new JLabel();
	label1.setText("Drive Capacity:");
	label2 = new JLabel();
	label2.setText("RPM");
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
    		result = "," +  text0.getText();
    		result += "," +  text1.getText();
    		result += "," +  text2.getText();
    		try{
    			 a.addProduct(result);
    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
    		}
    		catch(IOException ex){
    			
    		}
    		
    	}
    });

		SUBMIT.setActionCommand("1");
		
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
    
		JPanel gui = new JPanel(new BorderLayout(10,10));
    gui.setBorder(new TitledBorder("New Memory Drive"));
    gui.add(inputControls, BorderLayout.CENTER);
    gui.add(controls, BorderLayout.SOUTH);

    JFrame averageFrame = new JFrame("New Memory Drive");
    averageFrame.setContentPane(gui);
    averageFrame.pack();
    averageFrame.setLocationByPlatform(true);
    averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    averageFrame.setVisible(true);
	
}

public void displayAddMouse(final AddNewProduct a){
	label1 = new JLabel();
	label1.setText("Is it programmable?(true/false)");
  	label0 = new JLabel();
	label0.setText("DPI:");
	label2 = new JLabel();
	label2.setText("Is there DPI switching?(true/false)");
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
    		result = "," +  text0.getText();
    		result += "," +  text1.getText();
    		result += "," +  text2.getText();
    		try{
    			 a.addProduct(result);
    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
    		}
    		catch(IOException ex){
    			
    		}
    		
    	}
    });

		SUBMIT.setActionCommand("1");
		
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
    
		JPanel gui = new JPanel(new BorderLayout(10,10));
    gui.setBorder(new TitledBorder("New Mouse"));
    gui.add(inputControls, BorderLayout.CENTER);
    gui.add(controls, BorderLayout.SOUTH);

    JFrame averageFrame = new JFrame("New Mouse");
    averageFrame.setContentPane(gui);
    averageFrame.pack();
    averageFrame.setLocationByPlatform(true);
    averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    averageFrame.setVisible(true);
	
}

public void displayAddSpeaker(final AddNewProduct a){
	label0 = new JLabel();
	label0.setText("Watts:");
  	label1 = new JLabel();
	label1.setText("Is there Desktop Controls(true/false):");
	label2 = new JLabel();
	label2.setText("Is there a subwoofer(true/false):");
	label3 = new JLabel();
	label3.setText("Satellite Speaker:");
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
    		result = "," +  text0.getText();
    		result += "," +  text1.getText();
    		result += "," +  text2.getText();
    		result += "," +  text3.getText();
    		try{
    			 a.addProduct(result);
    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
    		}
    		catch(IOException ex){
    			
    		}
    		
    	}
    });

		SUBMIT.setActionCommand("1");
		
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
    
		JPanel gui = new JPanel(new BorderLayout(10,10));
    gui.setBorder(new TitledBorder("New Speaker"));
    gui.add(inputControls, BorderLayout.CENTER);
    gui.add(controls, BorderLayout.SOUTH);

    JFrame averageFrame = new JFrame("New Speaker");
    averageFrame.setContentPane(gui);
    averageFrame.pack();
    averageFrame.setLocationByPlatform(true);
    averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    averageFrame.setVisible(true);
	
}

public void displayAddGPU(final AddNewProduct a){
	label0 = new JLabel();
	label0.setText("Memory Type:");
  	label1 = new JLabel();
	label1.setText("Is it Virtual Reality Ready?(true/false):");
	label2 = new JLabel();
	label2.setText("Number of Display Ports:");
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
    		result = "," +  text0.getText();
    		result += "," +  text1.getText();
    		result += "," +  text2.getText();
    		try{
    			 a.addProduct(result);
    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
    		}
    		catch(IOException ex){
    			
    		}
    		
    	}
    });

		SUBMIT.setActionCommand("1");
		
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
    
		JPanel gui = new JPanel(new BorderLayout(10,10));
    gui.setBorder(new TitledBorder("New GPU"));
    gui.add(inputControls, BorderLayout.CENTER);
    gui.add(controls, BorderLayout.SOUTH);

    JFrame averageFrame = new JFrame("New GPU");
    averageFrame.setContentPane(gui);
    averageFrame.pack();
    averageFrame.setLocationByPlatform(true);
    averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    averageFrame.setVisible(true);
	
}
public void displayAddTablet(final AddNewProduct a){
	label0 = new JLabel();
	label0.setText("OS:");
  	label1 = new JLabel();
	label1.setText("Stylus:(true/false):");
	label2 = new JLabel();
	label2.setText("Screen Size:(inches)");
	label3 = new JLabel();
	label3.setText("Screen resolution:");
	JLabel label4 = new JLabel();
	label4.setText("Attachable Keyboard(true/false):");
	JLabel label5 = new JLabel();
	label5.setText("Weight");
	text0 = new JTextField(15);
		text1 = new JTextField(15);
		text2 = new JTextField(15);
		text3 = new JTextField(15);
		final JTextField text4 = new JTextField(15);
		final JTextField text5 = new JTextField(15);
		
		labelPanel.add(label0);
		labelPanel.add(label1);
		labelPanel.add(label2);
		labelPanel.add(label3);
		labelPanel.add(label4);
		labelPanel.add(label5);
		fieldPanel.add(text0);
		fieldPanel.add(text1);
		fieldPanel.add(text2);
		fieldPanel.add(text3);
		fieldPanel.add(text4);
		fieldPanel.add(text5);
		

    SUBMIT=new JButton("Submit");
    
    SUBMIT.addActionListener(new ActionListener(){
    	@Override
    	public void actionPerformed(ActionEvent e){
    		String result;
    		result = "," +  text0.getText();
    		result += "," +  text1.getText();
    		result += "," +  text2.getText();
    		result += "," +  text3.getText();
    		result += "," +  text4.getText();
    		result += "," +  text5.getText();
    		try{
    			 a.addProduct(result);
    			 ProductListUI createNewProductListUI = new ProductListUI(adminUser);
    		}
    		catch(IOException ex){
    			
    		}
    		
    	}
    });

		SUBMIT.setActionCommand("1");
		
		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
    
		JPanel gui = new JPanel(new BorderLayout(10,10));
    gui.setBorder(new TitledBorder("New Speaker"));
    gui.add(inputControls, BorderLayout.CENTER);
    gui.add(controls, BorderLayout.SOUTH);

    JFrame averageFrame = new JFrame("New Speaker");
    averageFrame.setContentPane(gui);
    averageFrame.pack();
    averageFrame.setLocationByPlatform(true);
    averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    averageFrame.setVisible(true);
	
}
}