package systemAnalysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DBHelper {
	
	
	public void writeProductToFile(String result) throws IOException{
		File file = new File("productList.txt");
		FileWriter writer = new FileWriter(file , true);
		PrintWriter out = new PrintWriter(writer);
		out.println(result);
		out.close();
	}
	
	public static void rewriteFile(ArrayList<Product> products) throws IOException{
		File file = new File("productList.txt");
		FileWriter writer = new FileWriter(file);
		PrintWriter out = new PrintWriter(writer);
		Product p;
		for(int i =0; i < products.size();i++){
			p= products.get(i);
			out.println(p.toString());
		}
		out.close();
		
	}
	
	public static void updateCustomerAddress(String newAddress, int customerId) throws IOException {
		File searchTextFile = new File("customerList.txt");
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
		File searchTextFile = new File("customerList.txt");
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

}
