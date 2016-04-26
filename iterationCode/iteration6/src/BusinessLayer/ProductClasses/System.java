package BusinessLayer.ProductClasses;

import java.util.ArrayList;

public interface System {

    public void addProduct(Product component);

    public ArrayList<Product> getComponents();

    public void removeProduct(Product component);
    
    public Product getChildatIndex(int i); 
  
}