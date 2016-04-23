package BusinessLayer;

import java.util.ArrayList;
import java.io.IOException;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;
import UserInterfaceLayer.CartUI;

public class ProductList implements Observer {

	public ProductList(ArrayList<Product> pickedProducts, Customer customer) throws IOException {
		
		// Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts)
		
		int orderId = BusinessLayerDataControl.checkNextAvailableId("ordersList.txt");
		int customerId = customer.getCustomerId();
		String customerName = customer.getFirstName() + customer.getSurname();
		int shippingId = orderId;
		
		Order customerOrder = new Order(orderId, customerId, customerName, shippingId, pickedProducts);
		
		@SuppressWarnings("unused")
		CartUI createNewCartUi = new CartUI(customerOrder,customer);
	}
	
	public ProductList(){

	}		 
	@Override
	public void Update(Product p) throws IOException {
		ArrayList<Product> x =BusinessLayerDataControl.factoryDesignPatternSearch();
		for(int i =0;i < x.size();i++){
			if(x.get(i).getProductId() == p.getProductId()){
				x.remove(i);
				x.add(i , p);
			}
		}
		BusinessLayerDataControl.rewriteProductFile(x);


	}
}
