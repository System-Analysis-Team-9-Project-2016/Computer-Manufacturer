package BusinessLayer;

import java.io.FileNotFoundException;

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

		String postOrderDetails = userOrder.getPostOrderDetails();	
		OrderSummaryUI createNewOrderSummaryUI = new OrderSummaryUI(postOrderDetails);

	}	
}