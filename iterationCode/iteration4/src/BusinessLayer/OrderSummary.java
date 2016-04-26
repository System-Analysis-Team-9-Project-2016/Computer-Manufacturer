package BusinessLayer;

import UserInterfaceLayer.OrderSummaryUI;

public class OrderSummary {

	@SuppressWarnings("unused")
	public OrderSummary(Order userOrder, Customer currentCustomer) {
		System.out.println("[debug] : ****** Entering OrderSummary Class ******");

		String postOrderDetails = userOrder.getPostOrderDetails();

		OrderSummaryUI createNewOrderSummaryUI = new OrderSummaryUI(userOrder, currentCustomer);

	}	
}