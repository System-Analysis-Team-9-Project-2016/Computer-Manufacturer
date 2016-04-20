package BusinessLayer.ProductClasses;

import java.util.ArrayList;

public interface Component {

    public void addProduct(Product component);

    public ArrayList<Product> getComponents();

    public void removeProduct(Product component);
    
    public Product getChildatIndex(int i); 
    
    public int getProductId();
    
    public void setProductId(int newProductId);
    
    public String getProductName();
    
    public void setProductName(String newProductName);
    
    public int getStock();
    
    public void setStock(int newStock);
    
    public double getUnitCost();
    
    public void setUnitCost(double newUnitCost);
    
    public void setProductActive();
    
    public void setProductDiscount(double unitCost);
    
    public String getProductStatus();

    public String getProductDetails();
  
}