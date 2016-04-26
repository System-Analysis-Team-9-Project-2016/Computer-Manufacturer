package systemAnalysis;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.border.*;

public class EditProductUI {
	
	EditProductUI(Admin a){
		
	}
	
	public void display(final Product p){
		JButton SUBMIT;
	  	JPanel panel;
	  	JLabel label0 , label1;
	  	final JTextField  text1;
	  	
	  	JPanel inputControls;
	  	
	  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
	    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
	    
	    inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
	  	
    	
    	label0 = new JLabel();
    	label0.setText("Current Price is " +p.getUnitCost());
	  	label1 = new JLabel();
   		label1.setText("Please enter your discount");
   		text1 = new JTextField(15);
   		
   		labelPanel.add(label0);
   		labelPanel.add(label1);
   		fieldPanel.add(text1);

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		double discount = Double.parseDouble(text1.getText());
	    		EditProduct edit;
				try {
					edit = new EditProduct(p);
					edit.applyDiscount(p, discount);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	}
	    });
   
   		SUBMIT.setActionCommand("1");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(SUBMIT);
        
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Edit Discount"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("Discount Page");
        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
        
		
		
		
	}

}
