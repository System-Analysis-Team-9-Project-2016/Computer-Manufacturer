package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;
import DataLayer.DatabaseInterface;

public class BusinessLayerDataControl implements DatabaseInterface {

	private DataControl dataControl = new DataControl();
	
	public int checkNextAvailableId(String filename) throws FileNotFoundException {
		return dataControl.checkNextAvailableId(filename);
	}
	
	public String [] checkAdminLogIn(String email, String password) throws FileNotFoundException {
		return dataControl.checkAdminLogIn(email, password);
	}
	
	public String[] checkCustomerLogIn(String email, String password) throws FileNotFoundException {
		return dataControl.checkCustomerLogIn(email, password);
	}
	
	public void addCustomerToTextFile(int id, String firstName, String surname, String address, String email, String password, String creditCardNumber) throws IOException {
		dataControl.addCustomerToTextFile(id, firstName, surname, address, email, password, creditCardNumber);
	}
	
	public void updateCustomerAddress(String newAddress, int customerId) throws IOException {
		dataControl.updateCustomerAddress(newAddress, customerId);
	}
	
	public void updateCustomerCreditCardNumber(String newCustomerCreditCard, int customerId) throws IOException {
		dataControl.updateCustomerCreditCardNumber(newCustomerCreditCard, customerId);
	}
	
	public boolean isProductNotAlreadyPresent(String productName) throws FileNotFoundException {
		return dataControl.isProductNotAlreadyPresent(productName);
	}
	
	public void writeNewProductToFile(String name, double cost, int stock, boolean isActive, boolean isDiscount, String details) throws FileNotFoundException {
		dataControl.writeNewProductToFile(name, cost, stock, isActive, isDiscount, details);
	}
	
	public void reduceProductOrderStock(int [] orderProductIds) throws FileNotFoundException {
		dataControl.reduceProductOrderStock(orderProductIds);
	}
	
	public void rewriteProductFile(ArrayList<Product> products) throws IOException {
		dataControl.rewriteProductFile(products);
	}
	
	public ArrayList<Product> factoryDesignPatternSearch() throws FileNotFoundException {
		return dataControl.factoryDesignPatternSearch();
	}
	
	public void writeNewCommentToFile(int customerId, String comment ,String customerName) throws FileNotFoundException {
		dataControl.writeNewCommentToFile(customerId, comment, customerName);
	}
	
	public ArrayList<String> getComments(int productID) throws IOException {
		return dataControl.getComments(productID);
	}
	
	public ArrayList<Order> getAllOrdersFromFile() throws IOException {
		return dataControl.getAllOrdersFromFile();
	}
	
	public void writeNewOrderToFile(int orderId, int customerId, String customerName, String orderProductIds) throws FileNotFoundException {
		dataControl.writeNewOrderToFile(orderId, customerId, customerName, orderProductIds);
	}
	
	public void writeNewDiscountToFile(ArrayList<Integer> added , double discount) throws FileNotFoundException {
		dataControl.writeNewDiscountToFile(added, discount);
	}
	
	public ArrayList<GroupDiscount> getAllGroupDiscountsFromFile() throws FileNotFoundException {
		return dataControl.getAllGroupDiscountsFromFile();
	}	
}
