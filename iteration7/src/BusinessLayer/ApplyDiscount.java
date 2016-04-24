package BusinessLayer;

import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

import java.io.*;
import java.util.ArrayList;


public class ApplyDiscount {

	public ApplyDiscount(Product p) throws IOException{
		ProductList r = new ProductList();
		p.registerObserver(r);
	}

	public void applyDiscount(Product p, double discount) throws IOException {
		p.setProductDiscount(discount);
		p.notifyObservers();
	}
	
	public void removeDiscount(Product p) throws IOException {
		p.removeDiscount();
		p.notifyObservers();	
	}
}