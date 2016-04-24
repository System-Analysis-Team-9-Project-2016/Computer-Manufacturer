package BusinessLayer.ProductClasses;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.Observer;
import BusinessLayer.Subject;

/**
 * This class models a Product that can be sold in
 * the on-line e-commerce system example.
 */

public class Product implements Component, Subject {

    private int productId;
    private String productName;
    private boolean isActive;
    private boolean isProductDiscount;
    protected double unitCost;
    private int stock;
    private ArrayList<Observer> observers;

    /**
     * Construct a new product using the provided item
     * and price.
     *
     * @param productId the productId of the product.
     * @param stock the amount left to sell for the product
     * @param isActive states whether the product is active or not.
     * @param isProductDiscount states whether the product has a discount set for it
     * @param productName the productName of the product.
     * @param unitCostthe unitCostfor which this Product should be sold.
     */
    public Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount) {
        this.productId = productId; //Generate new Id function should be used here
        this.productName = productName;
        this.stock = stock;
        this.unitCost= unitCost;
        this.isActive = isActive;
        this.isProductDiscount = isProductDiscount;
        observers = new ArrayList<Observer>();
    }
    
    /**
     * Get the ID of this Product.
     *
     * @return the ID of this Product.
     */
    public int getProductId() {
        return productId;
    }
    public void setProductId(int newProductId) {
        productId =  newProductId;
    }

    /**
     * Get the productName of this Product.
     *
     * @return the productName of this Product.
     */
    public String getProductName() {
        return productName;
    }
    public void setProductName(String newProductName) {
        productName =  newProductName;
    }
    
    /**
     * Get the stock of this Product.
     *
     * @return the stock of this Product.
     */
    public int getStock() {
        return stock;
    }
    public void setStock(int newStock) {
        stock =  newStock;
    }

    /**
     * Get the unitCostof this Product.
     *
     * @return the inventory number of this Product.
     */
    public double getUnitCost() {
    	if(isProductDiscount){
    		try {
    			return unitCost * (1 - (getDiscount() / 100));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			return unitCost;
    		}
    	}
    	else{
    		return unitCost;
    	}
    }

    public void setUnitCost(double newUnitCost) {
        this.unitCost= newUnitCost;
    }

    public void setProductActive()
    {
        this.isActive = true;
    }

    public void setProductDiscount(double discount) {
        this.isProductDiscount =  true;
        try {
        	BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
    		dataControl.addDiscount(productId, discount);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    public void removeDiscount(){
    	this.isProductDiscount = false;
    }

    public String getProductStatus()
    {
        String statusString = "";
        if(true == isActive)            statusString = "Product is available";
        else if(true == isProductDiscount)  statusString = "Product is on sale";
        return statusString;
    }

    public double getDiscount() throws IOException{
    	BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
    	return dataControl.getDiscount(productId);
    }

    /**
     * Get a String that describes this Product. Note that
     * this method overrides the toString method inherited
     * from Object.
     *
     * @return a String describing this Product.
     */
    public String getProductDetails() {
        return "\nProduct ID: " + this.productId + "\nProduct Name: " + this.productName +"\nPrice: " + getUnitCost() + "\nStock: " + this.stock + "\n";
    }

    public String getProductUIDetails(){
        return  this.productName + "  \u20ac" + new DecimalFormat("##.##").format(getUnitCost()) + "  " + this.stock;
    }
    public String toString(){
        return "" + this.productId + "," + this.productName +","  + this.stock + "," + this.unitCost + "," + this.isActive + "," 
                + this.isProductDiscount;


    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void notifyObservers() throws IOException {
        Observer o;
        try {
            for(int i = 0; i < observers.size();i++ )
            {
                o = observers.get(i);
                o.Update(this);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}




