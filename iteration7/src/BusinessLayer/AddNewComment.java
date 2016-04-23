package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class AddNewComment {
	
	public ArrayList<Product> getProducts(Customer c) throws IOException{
		ArrayList<Product> allProducts = BusinessLayerDataControl.factoryDesignPatternSearch();
		ArrayList<Order> allOrders = BusinessLayerDataControl.getAllOrdersFromFile();
		ArrayList<Product> myProductsID = new ArrayList<Product>();
		ArrayList<Product> orderProducts = new ArrayList<Product>();
		for(int i = 0; i < allOrders.size();i++){
			if(allOrders.get(i).getCustomerID() == c.getCustomerId()){
				orderProducts = allOrders.get(i).getProducts();
				for(int j = 0;j < orderProducts.size();j++){
					myProductsID.add(orderProducts.get(j));
				}
			}
		}
		
		for(int i = 0; i < myProductsID.size() - 1;i++){
			for(int j = i + 1;j < myProductsID.size(); j++){
				if(myProductsID.get(i).getProductId() == myProductsID.get(j).getProductId()){
					myProductsID.remove(j);
					j--;
				}			
			}
		}
		
		ArrayList<Product> myProducts = new ArrayList<Product>();
		for(int i = 0; i < myProductsID.size();i++){
			for(int j = 0;j < allProducts.size(); j++){
				if(myProductsID.get(i).getProductId() == allProducts.get(j).getProductId()){
					myProducts.add(allProducts.get(j));
				}			
			}
		}
		
		return myProducts;
		
	}
	
	public void addComment(String text , int ID , String name) throws IOException{
		BusinessLayerDataControl.writeNewCommentToFile(ID, text, name);
		
	}

}