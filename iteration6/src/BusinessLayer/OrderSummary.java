package BusinessLayer;

import java.io.FileNotFoundException;

import BusinessLayer.OrderClasses.*;
import BusinessLayer.CustomerClasses.Customer;
import DataLayer.DataControl;
import BusinessLayer.OrderClasses.Order;
import UserInterfaceLayer.OrderSummaryUI;

public class OrderSummary {

	@SuppressWarnings("unused")
	public OrderSummary(Order userOrder, Customer currentCustomer) throws FileNotFoundException {
		System.out.println("[debug] : ****** Entering OrderSummary Class ******");
		
		// Write the new order to ordersList.txt
		int orderId = userOrder.getOrderId();
		int customerId = currentCustomer.getCustomerId();
		String customerName = currentCustomer.getFirstName() + " " + currentCustomer.getSurname();
		String orderProductIds = userOrder.getOrderProductIdsToString();
		DataControl.writeNewOrderToFile(orderId, customerId, customerName, orderProductIds);
		
		// Reduce the stock amount of the products the customer is buying
		DataControl.reduceProductOrderStock(userOrder.getOrderProductIds());

		// Use Decorator Design pattern for printing receipt
		Receipt headerReceipt = new HeaderReceipt(new BasicReceipt());
		String postOrderDetails = headerReceipt.printReceipt();
		
		postOrderDetails += userOrder.getPostOrderDetails();	
		
		Receipt shippingReceipt = new ShippingReceipt(new BasicReceipt());
		postOrderDetails += shippingReceipt.printReceipt();
		
		OrderSummaryUI createNewOrderSummaryUI = new OrderSummaryUI(postOrderDetails);

	}	
}