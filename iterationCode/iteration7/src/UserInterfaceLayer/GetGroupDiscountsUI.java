package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.ProductClasses.Product;

public class GetGroupDiscountsUI {
	
	public void display() throws IOException{
		JPanel panel;
	  	JLabel label0 , label1;
		final JLabel label2;
	  	final JTextField  text1;
	  	
	  	JPanel inputControls;
	  	
	  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
	    
	    inputControls = new JPanel(new BorderLayout(5,5));
  		inputControls.add(labelPanel, BorderLayout.WEST);
	  	
		BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
    	ArrayList<GroupDiscount> groupDiscounts = dataControl.getAllGroupDiscountsFromFile();
	  	label1 = new JLabel();
	  	if(groupDiscounts.size() == 0)
	  		label1.setText("No Group Discounts ");
	  	else{
	  		label1.setText("Group Discounts:");
	  		labelPanel.add(label1);
	  		for(int i = 0;i < groupDiscounts.size();i++){
	  			label1 = new JLabel();
	  			label1.setText(groupDiscounts.get(i).toString());
	  			labelPanel.add(label1);
	  		}
	  	}
	  		
   		text1 = new JTextField(15);
   		
   		labelPanel.add(label1);
   		
   		JPanel m = new JPanel();
   		
   		JFrame averageFrame = new JFrame("Group Discount Page");
   		
   		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ OK button clicked (GetGroupDiscountsUI) ------");

				averageFrame.setVisible(false);
				averageFrame.dispose();
			}
		});
		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(okButton, BorderLayout.SOUTH);
   		
   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Group Discounts"));
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