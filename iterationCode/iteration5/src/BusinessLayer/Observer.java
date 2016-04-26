package BusinessLayer;

import java.io.IOException;

import BusinessLayer.ProductClasses.Product;

public interface Observer {
	
	public void Update(Product p) throws IOException;

}
