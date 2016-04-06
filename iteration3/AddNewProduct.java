package systemAnalysis;

import java.io.*;
import java.util.*;

public class AddNewProduct {
	
	private int maxID;
	private String name;
	private double cost;
	private int stock;
	
	
	public boolean validateProduct(String name , double cost , int stock) throws IOException{
		File productFile = new File("productList.txt");
		maxID = 0;
		boolean valid = true;
		//if()
		String line[];
		String currentProductName;
		Scanner in = new Scanner(productFile);
		while(in.hasNext()){
			line = in.nextLine().split(",");
			if(maxID < Integer.parseInt(line[0]))
				maxID = Integer.parseInt(line[0]);
			currentProductName = line[1];
			if(name.equals(currentProductName))
				valid = false;
		}
		in.close();
		return valid;
	}
	
	public String process(String inName , double inCost , int inStock) throws IOException{
		name = inName;
		cost = inCost;
		stock = inStock;
		
		return inName.substring(0, 3).toUpperCase();
		
	}
	
	public void addProduct(String details) throws IOException{
		File file = new File("productList.txt");
		FileWriter writer = new FileWriter(file , true);
		PrintWriter out = new PrintWriter(writer);
		out.println(maxID + "," + name + "," + cost + ","+ stock  + ",true,false," + details);
		out.close();
	}
	
	
}
