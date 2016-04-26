package BusinessLayer;

import DataLayer.DataControl;
import java.io.IOException;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;

public class EditOrderDetails {
	
	public EditOrderDetails(String newCustomerAddress, String newCustomerCreditCard, Order userOrder, Customer currentCustomer) throws IOException {
		System.out.println("[debug] : ****** Starting EditOrderDetails Class ******");

		if (!newCustomerAddress.equalsIgnoreCase("")) {
			currentCustomer.setCustomerAddress(newCustomerAddress);
			BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
			dataControl.updateCustomerAddress(newCustomerAddress, currentCustomer.getCustomerId());
		}
		
		if (!newCustomerCreditCard.equalsIgnoreCase("")) {
			currentCustomer.setCreditCardNumber(newCustomerCreditCard);
			BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
			dataControl.updateCustomerCreditCardNumber(newCustomerCreditCard, currentCustomer.getCustomerId());
		}
		
		//EditOrderDetailsUI createNewEditOrderDetails = new EditOrderDetailsUI(userOrder, currentCustomer);
		@SuppressWarnings("unused")
		OrderSummary createNewOrderSummary = new OrderSummary(userOrder, currentCustomer); 
	}
}