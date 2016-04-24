package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BusinessLayer.AddNewComment;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class AddNewCommentUI {
	
	private JList choices;
	private ArrayList<Product> customerProduct;
	private DefaultListModel<String> model;
	private Customer c;
	
	public AddNewCommentUI(Customer c){
		this.c = c;
	}
	
	public void display() throws IOException{
		JButton SUBMIT;
	  	JPanel panel;
	  	JLabel label0 , label1;
		final JLabel label2;
	  	final JTextField  text1;
	  	
	  	JPanel inputControls;
	  	
	  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
	    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
	    JPanel addedPanel = new JPanel(new GridLayout(0,1,3,3));
	    
	    inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
    	inputControls.add(fieldPanel, BorderLayout.CENTER);
    	inputControls.add(addedPanel, BorderLayout.SOUTH);
	  	
	  	label1 = new JLabel();
   		label1.setText("Please enter your Comment");
   		text1 = new JTextField(15);
   		
   		labelPanel.add(label1);
   		fieldPanel.add(text1);
   		
        JFrame averageFrame = new JFrame("Comment Page");
   		
   		JPanel m = new JPanel();
		model = new DefaultListModel<String>();
		
		AddNewComment a = new AddNewComment();
		customerProduct = a.getProducts(c);
		choices = new JList(model);
		for(int i = 0; i < customerProduct.size(); i++){
			   Product someProduct = customerProduct.get(i);
			   model.addElement(someProduct.getProductUIDetails());
			   choices = new JList(model);
		}
		m.add(choices);

	    SUBMIT=new JButton("Submit");
	    
	    SUBMIT.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
				int selected = choices.getSelectedIndex();
				AddNewComment a = new AddNewComment();
				Product p = customerProduct.get(selected);
				try {
					a.addComment(text1.getText(), p.getProductId() , c.getFirstName() + " " + c.getSurname());
					averageFrame.setVisible(false);
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
        gui.setBorder(new TitledBorder("Add Comment"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);
        
		gui.add(m, BorderLayout.WEST);
		m.setFont(new Font("Courier",Font.BOLD,14));

        averageFrame.setContentPane(gui);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        averageFrame.setVisible(true);
	}
}