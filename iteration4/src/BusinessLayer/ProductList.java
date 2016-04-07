package BusinessLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import DataLayer.DataControl;
import UserInterfaceLayer.CartUI;

public class ProductList {

	public ProductList(ArrayList<Product> boughtbought, Customer customer) throws FileNotFoundException {
		
		// Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts)
		
		int orderId = DataControl.checkNextAvailableId("ordersList.txt");
		int customerId = customer.getCustomerId();
		String customerName = customer.getFirstName() + customer.getSurname();
		int shippingId = orderId;
		
		Order customerOrder = new Order(orderId, customerId, customerName, shippingId, boughtbought);
		
		CartUI createNewCartUi = new CartUI(customerOrder,customer);
	}
}
