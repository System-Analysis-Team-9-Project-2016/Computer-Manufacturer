package BusinessLayer;

import DataLayer.DataControl;
import UserInterfaceLayer.OrderSummaryUI;

import java.io.IOException;

public class EditOrderDetails {
	
	public EditOrderDetails(String newCustomerAddress, String newCustomerCreditCard, Order userOrder, Customer currentCustomer) throws IOException {
		System.out.println("[debug] : ****** Starting EditOrderDetails Class ******");

		if (!newCustomerAddress.equalsIgnoreCase("")) {
			currentCustomer.setCustomerAddress(newCustomerAddress);
			DataControl.updateCustomerAddress(newCustomerAddress, currentCustomer.getCustomerId());
		}
		
		if (!newCustomerCreditCard.equalsIgnoreCase("")) {
			currentCustomer.setCreditCardNumber(newCustomerCreditCard);
			DataControl.updateCustomerCreditCardNumber(newCustomerCreditCard, currentCustomer.getCustomerId());
		}
		
		//EditOrderDetailsUI createNewEditOrderDetails = new EditOrderDetailsUI(userOrder, currentCustomer);
		@SuppressWarnings("unused")
		OrderSummaryUI createNewOrderSummaryUI = new OrderSummaryUI(userOrder, currentCustomer); 
	}
}