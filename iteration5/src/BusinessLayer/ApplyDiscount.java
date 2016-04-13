package BusinessLayer;


import DataLayer.DataControl;
import BusinessLayer.ProductClasses.Product;


import java.io.*;


public class ApplyDiscount {
	
	public ApplyDiscount(Product p) throws IOException{
		ProductList r = new ProductList();
		p.registerObserver(r);
	}

	public void applyDiscount(Product p, double discount) throws IOException {
		p.setProductDiscount(discount);
		p.notifyObservers();
		
	}

}
