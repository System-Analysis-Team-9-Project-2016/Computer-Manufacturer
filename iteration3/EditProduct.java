package systemAnalysis;

import java.io.IOException;

public class EditProduct {
	
	public EditProduct(Product p) throws IOException{
		ReadProductList r = new ReadProductList();
		p.registerObserver(r);
	}
	
	
	
	public void applyDiscount(Product p , double discount) throws IOException{
		p.setProductDiscount(discount);
		p.notifyObservers();
	}

}
