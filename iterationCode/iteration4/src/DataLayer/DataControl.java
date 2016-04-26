package DataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLayer.Product;

public class DataControl {
	
	public static final String customerFileName = "customerList.txt";
	public static final String adminFileName = "adminList.txt";
	public static final String productFileName = "productList.txt";

//########################################################################################################################################
//	General Methods
//########################################################################################################################################
	
	public static int checkNextAvailableId(String textFileName) throws FileNotFoundException {
		int nextAvailableId = 0;
		
		File searchTextFile = new File(textFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (Integer.parseInt(splitLineFromFile[0]) > nextAvailableId) 
				nextAvailableId = Integer.parseInt(splitLineFromFile[0]);
		}
		lineIn.close();
		nextAvailableId++;
		return nextAvailableId;
	}
	
//########################################################################################################################################
//	adminList.txt Methods
//########################################################################################################################################
	
	public static String [] checkAdminLogIn(String email, String password) throws FileNotFoundException {
		String [] adminDetails = new String [5];
		
		File searchTextFile = new File(adminFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			adminDetails = aLineFromFile.split(",");
			if (adminDetails[3].equalsIgnoreCase(email) && adminDetails[4].equalsIgnoreCase(password)) {
				lineIn.close();
				return adminDetails;
			}
		}
		lineIn.close();
		for(int i = 0; i < adminDetails.length; i++)
			adminDetails[i] = "fail";
		
		return adminDetails;
	}
	
//########################################################################################################################################
//	customerList.txt Methods
//########################################################################################################################################
	
	public static String [] checkCustomerLogIn(String email, String password) throws FileNotFoundException {
		String [] customerDetails = new String [7];
		
		File searchTextFile = new File(customerFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			customerDetails = aLineFromFile.split(",");
			if (customerDetails[4].equalsIgnoreCase(email) && customerDetails[5].equalsIgnoreCase(password)) {
				lineIn.close();
				return customerDetails;
			}
		}
		lineIn.close();
		for(int i = 0; i < customerDetails.length; i++)
			customerDetails[i] = "fail";
		
		return customerDetails;
	}
	
	public static void addCustomerToTextFile(int id, String firstName, String surname, String address, String email, String password, String creditCardNumber) throws IOException {
		String lineToAppend = "\n" + id + "," + firstName + "," + surname + "," + address + "," + email + "," + password + "," + creditCardNumber;
		try {
		    Files.write(Paths.get(customerFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public static void updateCustomerAddress(String newAddress, int customerId) throws IOException {
		File searchTextFile = new File(customerFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (customerId == Integer.parseInt(splitLineFromFile[0])) {
				// Update text file
			}
		}
		lineIn.close();
	}

	public static void updateCustomerCreditCardNumber(String newCustomerCreditCard, int customerId) throws IOException {
		File searchTextFile = new File(customerFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (customerId == Integer.parseInt(splitLineFromFile[0])) {
				// Update text file
			}
		}
		lineIn.close();	
	}
	
//########################################################################################################################################
//	productList.txt Methods
//########################################################################################################################################
	
	public static boolean isProductNotAlreadyPresent(String productName) throws FileNotFoundException {
		boolean isProductNotPresent = true;

		File searchTextFile = new File(productFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (productName.equals(splitLineFromFile[1])) {
				isProductNotPresent = false;
			}
		}
		lineIn.close();	
		
		return isProductNotPresent;
	}
	
	public static void writeNewProductToFile(String name, double cost, int stock, boolean isActive, boolean isDiscount) throws FileNotFoundException {
		int nextAvailableProductId = checkNextAvailableId(productFileName);
		String lineToAppend = "\n" + nextAvailableProductId + "," + name + "," + cost + "," + stock + "," + isActive + "," + isDiscount;
		try {
		    Files.write(Paths.get(productFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public static ArrayList<Product> getAllProductsFromFile() throws FileNotFoundException {
		ArrayList<Product> allFileProducts = new ArrayList<Product>();
		
		File searchTextFile = new File(productFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (splitLineFromFile.length > 0) {
				// Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount)
				Product lineProduct = new Product(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), 
						Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5]));
				allFileProducts.add(lineProduct);
			}
		}
		lineIn.close();
		
		return allFileProducts;
	}
}
