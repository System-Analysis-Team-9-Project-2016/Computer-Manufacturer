package DataLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;

public interface DatabaseInterface {
	
	public int checkNextAvailableId(String filename) throws FileNotFoundException;
	public String [] checkAdminLogIn(String email, String password) throws FileNotFoundException;
	public String [] checkCustomerLogIn(String email, String password) throws FileNotFoundException;
	public void addCustomerToTextFile(int id, String firstName, String surname, String address, String email, String password, String creditCardNumber) throws IOException;
	public void updateCustomerAddress(String newAddress, int customerId) throws IOException;
	public void updateCustomerCreditCardNumber(String newCustomerCreditCard, int customerId) throws IOException;
	public boolean isProductNotAlreadyPresent(String productName) throws FileNotFoundException;
	public void writeNewProductToFile(String name, double cost, int stock, boolean isActive, boolean isDiscount, String details) throws FileNotFoundException;
	public ArrayList<Product> factoryDesignPatternSearch() throws FileNotFoundException;
	public void reduceProductOrderStock(int [] orderProductIds) throws FileNotFoundException;
	public void rewriteProductFile(ArrayList<Product> products) throws IOException;
	public void writeNewCommentToFile(int customerId, String comment ,String customerName) throws FileNotFoundException;
	public ArrayList<String> getComments(int productID) throws IOException;
	public ArrayList<Order> getAllOrdersFromFile() throws IOException;
	public void writeNewOrderToFile(int orderId, int customerId, String customerName, String orderProductIds) throws FileNotFoundException;
	public void writeNewDiscountToFile(ArrayList<Integer> added , double discount) throws FileNotFoundException;
	public ArrayList<GroupDiscount> getAllGroupDiscountsFromFile() throws FileNotFoundException;
}