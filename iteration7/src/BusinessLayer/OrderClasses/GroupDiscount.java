package BusinessLayer.OrderClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class GroupDiscount {
	
	int id;
	ArrayList<Integer> productsIDInDiscount;
	double discount;
	
	public GroupDiscount(int id ,ArrayList<Integer> selectedProducts , double discount){
		this.id = id;
		productsIDInDiscount = selectedProducts;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getProductsIDInDiscount() {
		return productsIDInDiscount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public boolean areProductsValid(ArrayList<Product> products){
		boolean match = true;
		Product p;
		for(int i = 0; i < productsIDInDiscount.size() && match;i++){
			match = false;
			for(int j = 0;j < products.size();j++){
				p = products.get(j);
				//System.out.println("Comparing " + productsIDInDiscount.get(i) + " and " + p.getProductId());
				if(productsIDInDiscount.get(i) == p.getProductId())
					match = true;
			}
			System.out.println("Match is " + match);
		}
				
		return match;
	}
	
	public String toString(){
		
		String result = " This discount is for ";
		Product p;
		try {
			BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
			ArrayList<Product> products = dataControl.factoryDesignPatternSearch();
			for(int i = 0; i < products.size();i++){
				p = products.get(i);
				for(int j = 0;j < productsIDInDiscount.size();j++){
					if(productsIDInDiscount.get(j) == p.getProductId())
						result += p.getProductName() + " and ";
				}
			}
			result += "the discount is " + (discount) + "%";
			return result;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}