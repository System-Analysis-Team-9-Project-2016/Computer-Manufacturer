package UserInterfaceLayer;

import BusinessLayer.*;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

@SuppressWarnings({ "unused", "serial" })
public class EditOrderDetailsUI extends JFrame {
	
	EditOrderDetailsUI(Order userOrder, Customer currentCustomer) {
System.out.println("[debug] : ****** Starting EditOrderDetailsUI Class ******");

// ************************************************************************************************************************
// ************ 	Start JFrame stuff
// ************************************************************************************************************************

		JFrame EditOrderDetailsUiFrame = new JFrame("Your Details - please review your details");

		JLabel addressLabel = new JLabel();
   		addressLabel.setText("Address: " + currentCustomer.getCustomerAddress());
   		JTextField newCustomerAddressTextBox = new JTextField(30);

   		JLabel creditCardLabel = new JLabel();
   		creditCardLabel.setText("Credit Card Number: " + currentCustomer.getCreditCardNumber());
   		JTextField newCustomerCreditCardTextBox = new JTextField(20);

		JButton purchaseButton = new JButton("Purchase");
   		purchaseButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Purchase button clicked (EditDetailsUI) ------");

		    	// Set new values for address and credit card for the customer
		    	String newCustomerAddress = "", newCustomerCreditCard = "";
				if (newCustomerAddressTextBox.getText() != currentCustomer.getCustomerAddress())
		    		newCustomerAddress = newCustomerAddressTextBox.getText();
		    	if (newCustomerCreditCardTextBox.getText() != currentCustomer.getCreditCardNumber())
		    		newCustomerCreditCard = newCustomerCreditCardTextBox.getText();

		    	EditOrderDetailsUiFrame.setVisible(false);
		    	EditOrderDetailsUiFrame.dispose();
		        try {
					EditOrderDetails createNewOrderSummary = new EditOrderDetails(newCustomerAddress, newCustomerCreditCard, userOrder, currentCustomer);
				} 
		        catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});

   		JButton goBackButton = new JButton("Go Back");
   		goBackButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Go Back button clicked (EditDetailsUI) ------");
		    	EditOrderDetailsUiFrame.setVisible(false);
		    	EditOrderDetailsUiFrame.dispose();
		    	//Cart createGoBackCart = new Cart(currentCustomer, userOrder);
		    }
		});
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(purchaseButton);
      	controls.add(goBackButton);

   		JPanel gui = new JPanel(new GridLayout(3,2));
        gui.setBorder(new TitledBorder("You may edit your details here"));
        gui.add(addressLabel);
        gui.add(newCustomerAddressTextBox);
        gui.add(creditCardLabel);
        gui.add(newCustomerCreditCardTextBox);
        gui.add(controls);

        EditOrderDetailsUiFrame.setContentPane(gui);
        EditOrderDetailsUiFrame.pack();
        EditOrderDetailsUiFrame.setLocationByPlatform(true);
        EditOrderDetailsUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EditOrderDetailsUiFrame.setSize(800, 600);
        EditOrderDetailsUiFrame.setResizable(false);
        EditOrderDetailsUiFrame.setLocationRelativeTo(null);
        EditOrderDetailsUiFrame.setVisible(true);
	}
}