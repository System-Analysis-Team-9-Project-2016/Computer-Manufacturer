package BusinessLayer;

import DataLayer.DataControl;
import java.io.*;

public class AddNewProduct {
	
	private String name;
	private double cost;
	private int stock;
	
	
	public boolean validateProduct(String name) throws IOException{

		boolean valid = true;
		valid = DataControl.isProductNotAlreadyPresent(name);
		return valid;
	}
	
	public String process(String inName , double inCost , int inStock) throws IOException{
		name = inName;
		cost = inCost;
		stock = inStock;
		
		return inName.substring(0, 3).toUpperCase();
		
	}
	
	public void addProduct(String details) throws IOException{
		DataControl.writeNewProductToFile(name, cost, stock, true, false);
	}
	
	
}