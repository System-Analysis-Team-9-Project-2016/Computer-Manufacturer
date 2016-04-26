package DataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;

public class DataControl {
	
	public static final String customerFileName = "customerList.txt";
	public static final String commentsFileName = "commentsList.txt";
	public static final String adminFileName = "adminList.txt";
	public static final String productFileName = "productList.txt";
	public static final String ordersFileName = "ordersList.txt";
	public static final String groupDiscountsFileName = "groupDiscountList.txt";

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
		String lineToAppend = "\n" + nextAvailableProductId + "," + name + "," + stock + "," + cost + "," + isActive + "," + isDiscount;
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
				Product lineProduct = new Product(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5]));
				allFileProducts.add(lineProduct);
			}
		}
		lineIn.close();
		
		return allFileProducts;
	}
	
	public static void reduceProductOrderStock(int [] orderProductIds) throws FileNotFoundException {
		File searchTextFile = new File(productFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		for (int i = 0; i < orderProductIds.length; i++) {
			while (lineIn.hasNextLine()) {
				String aLineFromFile = lineIn.nextLine();
				String [] splitLineFromFile = aLineFromFile.split(",");
				if (orderProductIds[i] == Integer.parseInt(splitLineFromFile[0])) {
					// Update text file by reducing the stock for that product
				}
			}	
		}
		lineIn.close();
	}
	
	public static void rewriteProductFile(ArrayList<Product> products) throws IOException{
		File file = new File("productList.txt");
		FileWriter writer = new FileWriter(file);
		PrintWriter out = new PrintWriter(writer);
		Product p;
		for(int i =0; i < products.size();i++){
			System.out.println("[info]  : ------ Rewriting File (DataControl) ------");
			p= products.get(i);
			out.println(p.toString());
		}
		out.close();
		
	}
	
	public static ArrayList<Product> factoryDesignPatternSearch() throws FileNotFoundException {
		File searchTextFile = new File(productFileName);
		ArrayList<Product> allFileProducts = new ArrayList<Product>();
		Scanner lineIn = new Scanner(searchTextFile); 
		productFactoryDesign productFactory = new productFactoryDesign();
		while(lineIn.hasNextLine()){
			String aLineFromFile = lineIn.nextLine();
			String[] splitLineFromFile = aLineFromFile.split(",");
			switch(splitLineFromFile[1]){
			case "CPU":
				CPU cCPU = productFactory.getCPU(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5]), 
						splitLineFromFile[6], splitLineFromFile[7], Double.parseDouble(splitLineFromFile[8]));
				allFileProducts.add(cCPU);
				break;
			case "RAM":
				RAM cRAM = productFactory.getRAM(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						,splitLineFromFile[6], splitLineFromFile[7], Double.parseDouble(splitLineFromFile[8]));
				allFileProducts.add(cRAM);
				break;
			case "GPU":
				GPU cGPU = productFactory.getGPU(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						,splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]), Integer.parseInt(splitLineFromFile[8]));
				allFileProducts.add(cGPU);
				break;		
			case "Keyboard":
				Keyboard cKeyboard = productFactory.getKeyboard(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]));
				allFileProducts.add(cKeyboard);
				break;
			case "MemoryDrives":
				MemoryDrives cMemory = productFactory.getMemory(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, Boolean.parseBoolean(splitLineFromFile[6]), Integer.parseInt(splitLineFromFile[7]), splitLineFromFile[8]);
				allFileProducts.add(cMemory);
				break;
			case "Monitor":
				Monitor cMonitor = productFactory.getMonitor(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						,splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]), Boolean.parseBoolean(splitLineFromFile[8]));
				allFileProducts.add(cMonitor);
				break;
			case "Mouse":
				Mouse cMouse = productFactory.getMouse(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						,Integer.parseInt(splitLineFromFile[6]), Boolean.parseBoolean(splitLineFromFile[7]), Boolean.parseBoolean(splitLineFromFile[8]));
				allFileProducts.add(cMouse);
				break;
			case "Speaker":
				Speaker cSpeaker = productFactory.getSpeaker(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						,Integer.parseInt(splitLineFromFile[6]), Boolean.parseBoolean(splitLineFromFile[7]), Boolean.parseBoolean(splitLineFromFile[8]), Integer.parseInt(splitLineFromFile[9]));
				allFileProducts.add(cSpeaker);
				break;
			case "Laptop":
				Laptop cLaptop = productFactory.getLaptop(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]), Integer.parseInt(splitLineFromFile[8]), Integer.parseInt(splitLineFromFile[9]), Double.parseDouble(splitLineFromFile[10]));
				allFileProducts.add(cLaptop);
				break;
			case "Tablet":
				Tablet cTablet = productFactory.getTablet(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]), Integer.parseInt(splitLineFromFile[8]), Integer.parseInt(splitLineFromFile[9]), Boolean.parseBoolean(splitLineFromFile[10]), Double.parseDouble(splitLineFromFile[11]));
				allFileProducts.add(cTablet);
				break;
			case "Desktop":
				Desktop cDesktop = productFactory.getDesktop(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, splitLineFromFile[6], Boolean.parseBoolean(splitLineFromFile[7]));
				allFileProducts.add(cDesktop);
				break;
			case "Motherboard":
				Motherboard cMotherboard = productFactory.getMotherboard(Integer.parseInt(splitLineFromFile[0]), splitLineFromFile[1], Integer.parseInt(splitLineFromFile[2]), Double.parseDouble(splitLineFromFile[3]), Boolean.parseBoolean(splitLineFromFile[4]), Boolean.parseBoolean(splitLineFromFile[5])
						, splitLineFromFile[6], splitLineFromFile[7], splitLineFromFile[8], splitLineFromFile[9]);
				allFileProducts.add(cMotherboard);
				break;
			}
		}
		lineIn.close();
		return allFileProducts;
	}
	
	public static void writeNewCommentToFile(int customerId, String comment ,String customerName) throws FileNotFoundException {
		int nextAvailableProductId = checkNextAvailableId(commentsFileName);
		String lineToAppend = "\n" + nextAvailableProductId + "," + customerId + "," + comment + "," + customerName;
		try {
		    Files.write(Paths.get(commentsFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public static ArrayList<String> getComments(int productID) throws IOException{
		
		ArrayList<String> commentsInFile = new ArrayList<String>();
		
		File searchTextFile = new File(commentsFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		String comment;
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (splitLineFromFile.length > 0) {
				if(Integer.parseInt(splitLineFromFile[1]) == productID){
					comment = splitLineFromFile[2];
					comment += "\n-" + splitLineFromFile[3];
					commentsInFile.add(comment);
				}
			}
		}
		lineIn.close();
		
		return commentsInFile;
		
	}

//########################################################################################################################################
//ordersList.txt Methods
//########################################################################################################################################

	public static void writeNewOrderToFile(int orderId, int customerId, String customerName, String orderProductIds) throws FileNotFoundException {
		int nextAvailableProductId = checkNextAvailableId(ordersFileName);
		String lineToAppend = "\n" + nextAvailableProductId + "," + orderId + "," + customerId + "," + customerName + "," + orderProductIds;
		try {
		    Files.write(Paths.get(ordersFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public static void writeNewDiscountToFile(ArrayList<Integer> added , double discount) throws FileNotFoundException {
		int nextAvailableDiscountId = checkNextAvailableId(groupDiscountsFileName);
		String IDs = "";
		for(int i =0;i < added.size();i++)
			IDs += added.get(i) + ",";
		String lineToAppend = "\n" + nextAvailableDiscountId + "," + added.size() + "," + IDs  + discount;
		try {
		    Files.write(Paths.get(groupDiscountsFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public static ArrayList<GroupDiscount> getAllGroupDiscountsFromFile() throws FileNotFoundException {
		
		
		ArrayList<GroupDiscount> allDiscountsInFile = new ArrayList<GroupDiscount>();
		
		File searchTextFile = new File(groupDiscountsFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		int prices;
		int i;
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (splitLineFromFile.length > 0) {
				ArrayList<Integer> productsInDiscount = new ArrayList<Integer>();
				prices = Integer.parseInt(splitLineFromFile[1]);
				for( i = 0; i< prices;i++){
					productsInDiscount.add(Integer.parseInt(splitLineFromFile[2 + i]));
				}
					
				GroupDiscount lineDiscount = new GroupDiscount(Integer.parseInt(splitLineFromFile[0]), productsInDiscount, Double.parseDouble(splitLineFromFile[i+2]));
				allDiscountsInFile.add(lineDiscount);
			}
		}
		lineIn.close();
		
		return allDiscountsInFile;
	}
	
	public static ArrayList<Order> getAllOrdersFromFile() throws IOException {
		
		
		ArrayList<Order> allOrdersInFile = new ArrayList<Order>();
		
		File searchTextFile = new File(ordersFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		int prices;
		int i;
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (splitLineFromFile.length > 0) {
				ArrayList<Product> productsInOrder = new ArrayList<Product>();
				int orderID = Integer.parseInt(splitLineFromFile[0]);
				int shippingID = Integer.parseInt(splitLineFromFile[1]);
				int customerID = Integer.parseInt(splitLineFromFile[2]);
				String customerName = splitLineFromFile[3];
				String[] orderProducts = splitLineFromFile[4].split(" ");
				for( i = 0; i< orderProducts.length;i++){
					productsInOrder.add(new Product(Integer.parseInt(orderProducts[i]) , "" , 0 , 0 ,true , false));
				}
					
				Order lineOrder = new Order(orderID, customerID, customerName , shippingID , productsInOrder);
				allOrdersInFile.add(lineOrder);
			}
		}
		lineIn.close();
		
		return allOrdersInFile;
	}

}



