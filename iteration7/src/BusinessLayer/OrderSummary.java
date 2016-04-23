package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.OrderClasses.*;
import BusinessLayer.CustomerClasses.Customer;
import DataLayer.DataControl;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import UserInterfaceLayer.OrderSummaryUI;

public class OrderSummary {

	@SuppressWarnings("unused")
	public OrderSummary(Order userOrder, Customer currentCustomer) throws IOException {
		System.out.println("[debug] : ****** Entering OrderSummary Class ******");
		
		// Write the new order to ordersList.txt
		int orderId = userOrder.getOrderId();
		int customerId = currentCustomer.getCustomerId();
		String customerName = currentCustomer.getFirstName() + " " + currentCustomer.getSurname();
		String orderProductIds = userOrder.getOrderProductIdsToString();
		BusinessLayerDataControl.writeNewOrderToFile(orderId, customerId, customerName, orderProductIds);
/*
		// Reduce the stock amount of the products the customer is buying
		BusinessLayerDataControl.reduceProductOrderStock(userOrder.getOrderProductIds());
		int[] orderProductIDs = userOrder.getOrderProductIds();
		ArrayList<Product> myProducts = new ArrayList<Product>();
		ArrayList<Product> allProducts = BusinessLayerDataControl.factoryDesignPatternSearch();
		for(int i = 0; i < orderProductIDs.length;i++){
			for(int j = 0;j < allProducts.size(); j++){
				if(orderProductIDs[i] == allProducts.get(j).getProductId()){
					myProducts.add(allProducts.get(j));

				}			
			}
		}
		ProductList listOfProducts = new ProductList();
		for(int i =0; i < myProducts.size();i++){
			myProducts.get(i).registerObserver(listOfProducts);
			myProducts.get(i).setStock(myProducts.get(i).getStock() - 1);
			myProducts.get(i).notifyObservers();		
		}
*/
		// Use Decorator Design pattern for printing receipt
		Receipt headerReceipt = new HeaderReceipt(new BasicReceipt());
		String postOrderDetails = headerReceipt.printReceipt();
		
		postOrderDetails += userOrder.getPostOrderDetails();	
		
		Receipt shippingReceipt = new ShippingReceipt(new BasicReceipt());
		postOrderDetails += shippingReceipt.printReceipt();
		
		OrderSummaryUI createNewOrderSummaryUI = new OrderSummaryUI(postOrderDetails);

	}	
}