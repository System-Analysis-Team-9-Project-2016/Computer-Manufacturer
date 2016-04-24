package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;

@SuppressWarnings("serial")
public class CartUI extends JPanel{
	int counter = 0;

	public CartUI(Order userOrder,Customer currentCustomer) {
		System.out.println("[debug] : ****** Starting CartUI Class  ******");

		// ************************************************************************************************************************
		// ************ 	Start JFrame stuff
		// ************************************************************************************************************************

		JList list;
		ArrayList<Product> orderProducts = userOrder.getProducts();

		DefaultListModel model;

		JFrame cartUiFrame = new JFrame("Your Details - please review your details");
		cartUiFrame.setLayout(new BorderLayout());
		model = new DefaultListModel();
		list = new JList(model);
		JScrollPane pane = new JScrollPane(list);
		JButton addButton = new JButton("Add Element");
		JButton removeButton = new JButton("Remove Element");
		for (int i = 0; i < orderProducts.size(); i++)
			model.addElement("Product " + orderProducts.get(i).getProductDetails());

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedIndex =list.getSelectedIndex();
				if (selectedIndex != -1) {
					model.removeElementAt(selectedIndex);
					orderProducts.remove(selectedIndex);
					userOrder.setProducts(orderProducts);
				}	          
			}
		});

		cartUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel addShippingCostLabel = new JLabel();
		addShippingCostLabel.setText("<html><br><b>There is a \u20ac5.00 shipping cost that will be added to your order.</b><br><br></html>");

		JButton purchaseButton = new JButton("Proceed to Details");
		purchaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Proceed to Details button clicked (CartUI) ------");

				cartUiFrame.setVisible(false);
				cartUiFrame.dispose();
				userOrder.setProducts(orderProducts);
				EditOrderDetailsUI createNewOrderSummaryUI = new EditOrderDetailsUI(userOrder, currentCustomer);
			}
		});

		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));

		controls.add(addShippingCostLabel);
		controls.add(pane, BorderLayout.NORTH);
		controls.add(addButton, BorderLayout.WEST);
		controls.add(removeButton, BorderLayout.EAST);
		controls.add(purchaseButton, BorderLayout.SOUTH);

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