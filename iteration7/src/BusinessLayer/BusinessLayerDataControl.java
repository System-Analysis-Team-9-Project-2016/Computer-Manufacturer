package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class BusinessLayerDataControl extends DataControl {

	public static int checkNextAvailableId(String filename) throws FileNotFoundException {
		return DataControl.checkNextAvailableId(filename);
	}
	
	public static String [] checkAdminLogIn(String email, String password) throws FileNotFoundException {
		return DataControl.checkAdminLogIn(email, password);
	}
	
	public static String[] checkCustomerLogIn(String email, String password) throws FileNotFoundException {
		return DataControl.checkCustomerLogIn(email, password);
	}
	
	public static void addCustomerToTextFile(int id, String firstName, String surname, String address, String email, String password, String creditCardNumber) throws IOException {
		DataControl.addCustomerToTextFile(id, firstName, surname, address, email, password, creditCardNumber);
	}
	
	public static void updateCustomerAddress(String newAddress, int customerId) throws IOException {
		DataControl.updateCustomerAddress(newAddress, customerId);
	}
	
	public static void updateCustomerCreditCardNumber(String newCustomerCreditCard, int customerId) throws IOException {
		DataControl.updateCustomerCreditCardNumber(newCustomerCreditCard, customerId);
	}
	
	public static boolean isProductNotAlreadyPresent(String productName) throws FileNotFoundException {
		return DataControl.isProductNotAlreadyPresent(productName);
	}
	
	public static void writeNewProductToFile(String name, double cost, int stock, boolean isActive, boolean isDiscount, String details) throws FileNotFoundException {
		DataControl.writeNewProductToFile(name, cost, stock, isActive, isDiscount, details);
	}
	
	public static void reduceProductOrderStock(int [] orderProductIds) throws FileNotFoundException {
		DataControl.reduceProductOrderStock(orderProductIds);
	}
	
	public static void rewriteProductFile(ArrayList<Product> products) throws IOException {
		DataControl.rewriteProductFile(products);
	}
	
	public static ArrayList<Product> factoryDesignPatternSearch() throws FileNotFoundException {
		return DataControl.factoryDesignPatternSearch();
	}
	
	public static void writeNewOrderToFile(int orderId, int customerId, String customerName, String orderProductIds) throws FileNotFoundException {
		DataControl.writeNewOrderToFile(orderId, customerId, customerName, orderProductIds);
	}
	
	public static void writeNewDiscountToFile(ArrayList<Integer> added , double discount) throws FileNotFoundException {
		DataControl.writeNewDiscountToFile(added, discount);
	}
	
	public static ArrayList<GroupDiscount> getAllGroupDiscountsFromFile() throws FileNotFoundException {
		return DataControl.getAllGroupDiscountsFromFile();
	}	
}
