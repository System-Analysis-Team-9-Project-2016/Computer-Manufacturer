package BusinessLayer.ProductClasses;

import java.util.ArrayList;

public class ComputerSystem extends Product implements System{

    private String OS;
    private ArrayList<Product> components;

    public ComputerSystem(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.OS = OS;
        components = new ArrayList<Product>();
    }

    public void addProduct(Product component) {
    	components.add(component);
    }
    
    public ArrayList<Product> getComponents() {
        return components;

    }

    public void removeProduct(Product component) {
    	components.remove(component);
    }
    
    public Product getChildatIndex(int i) {
        return components.get(i);
    }
    
    public String toString(){
    	 return super.toString() + "," + OS;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
 }