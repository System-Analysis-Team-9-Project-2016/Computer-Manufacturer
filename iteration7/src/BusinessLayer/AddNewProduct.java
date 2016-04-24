package BusinessLayer;

import DataLayer.DataControl;
import java.io.*;

public class AddNewProduct {
	
	private String name;
	private double cost;
	private int stock;
	
	
	public boolean validateProduct(String name) throws IOException{

		boolean valid = true;
		valid = BusinessLayerDataControl.isProductNotAlreadyPresent(name);
		//return valid; -> Overriding return boolean as we are allowing products with the same name
		return true;
	}
	
	public String process(String inName , double inCost , int inStock) throws IOException{
		name = inName;
		cost = inCost;
		stock = inStock;
		
		return this.name;
		
	}
	
	public void addProduct(String details) throws IOException{
		BusinessLayerDataControl.writeNewProductToFile(name, cost, stock, true, false, details);
	}
	
	
}
