package BusinessLayer.ProductClasses;

import java.util.ArrayList;

public interface Component {

    public void addProduct(Component component);

    public ArrayList<Component> getComponents();

    public void removeProduct(Component component);
    
    public Component getChildatIndex(int i); 
    
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