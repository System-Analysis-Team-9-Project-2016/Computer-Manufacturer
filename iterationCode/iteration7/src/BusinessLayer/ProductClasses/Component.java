package BusinessLayer.ProductClasses;

public interface Component { 
    
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