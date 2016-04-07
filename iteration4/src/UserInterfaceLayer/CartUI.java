package UserInterfaceLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BusinessLayer.Customer;
import BusinessLayer.EditOrderDetails;
import BusinessLayer.Order;

public class CartUI {

	public CartUI(Order userOrder,Customer currentCustomer) {
		System.out.println("[debug] : ****** Starting CartUI Class  ******");
		
// ************************************************************************************************************************
// ************ 	Start JFrame stuff
// ************************************************************************************************************************

		JFrame cartUiFrame = new JFrame("Your Details - please review your details");
		cartUiFrame.setLayout(new FlowLayout());
		cartUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //String[] orderProductNames = userOrder.getOrderProductNames();
	    //JList list = new JList(orderProductNames);
	    //list.setSelectedIndex(1);
	    //list.setMinimumSize(new Dimension(700, 500));
	    //System.out.println(list.getSelectedValue());
	    //cartUiFrame.add(new JScrollPane(list));

		JLabel uiNotReadyLabel = new JLabel();
		uiNotReadyLabel.setText("This UI is under construction. You will be able to review your Ordered products here.");
		
	    JButton purchaseButton = new JButton("Proceed to Details");
   		purchaseButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Proceed to Details button clicked (CartUI) ------");

		    	cartUiFrame.setVisible(false);
		    	cartUiFrame.dispose();
		        EditOrderDetailsUI createNewOrderSummaryUI = new EditOrderDetailsUI(userOrder, currentCustomer);
		    }
		});
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(purchaseButton);
   		controls.add(uiNotReadyLabel);

	    cartUiFrame.pack();
   		cartUiFrame.setContentPane(controls);
	    cartUiFrame.setLocationByPlatform(true);
	    cartUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cartUiFrame.setSize(800, 600);
	    cartUiFrame.setResizable(false);
	    cartUiFrame.setLocationRelativeTo(null);
	    cartUiFrame.setVisible(true);
		
	}
}
