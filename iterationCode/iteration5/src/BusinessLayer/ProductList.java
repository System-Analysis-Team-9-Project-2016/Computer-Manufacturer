package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;
import UserInterfaceLayer.CartUI;

public class ProductList implements Observer {

	public ProductList(ArrayList<Product> boughtbought, Customer customer) throws FileNotFoundException {
		
		// Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts)
		
		int orderId = DataControl.checkNextAvailableId("ordersList.txt");
		int customerId = customer.getCustomerId();
		String customerName = customer.getFirstName() + customer.getSurname();
		int shippingId = orderId;
		
		Order customerOrder = new Order(orderId, customerId, customerName, shippingId, boughtbought);
		
		CartUI createNewCartUi = new CartUI(customerOrder,customer);
	}
	
	public ProductList(){
		
	}

	@Override
	public void Update(Product p) throws IOException {
		ArrayList<Product> x = DataControl.getAllProductsFromFile();
		for(int i =0;i < x.size();i++){
			if(x.get(i).getProductId() == p.getProductId()){
				x.remove(i);
				x.add(i , p);
			}
		}
		DataControl.rewriteProductFile(x);
		
		
	}
}
