import java.text.*;
import java.util.*;

/**
 * This class models a Product that can be sold in
 * the on-line e-commerce system example.
 */
public class product {
    private String PID;
    private String name;
    private boolean isActive;
    private boolean isProductDiscount;
    private double price;
    private int stock;

    /**
     * Construct a new product using the provided item
     * and price.
     *
     * @param PID the productId of the product.
     * @param stock the amount left to sell for the product
     * @param isActive states whether the product is active or not.
     * @param isProductDiscount states whether the product has a discount set for it
     * @param name the name of the product.
     * @param price the price for which this Product should be sold.
     */
    public product(String PID, String name, int stock, double price) {
        this.PID = PID; //Generate new Id function should be used here
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.isActive = isActive;
        this.isProductDiscount = isProductDiscount;

    }
    
    /**
     * Get the ID of this Product.
     *
     * @return the ID of this Product.
     */
    public String getPID() {
        return PID;
    }
    public void setPID(String newPID) {
        PID =  newPID;
    }

    /**
     * Get the name of this Product.
     *
     * @return the name of this Product.
     */
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name =  newName;
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
     * Get the price of this Product.
     *
     * @return the inventory number of this Product.
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    
    public void setProductActive()
    {
	    this.isActive = true;
    }
   	
    public void setProductDiscount() {
        this.isProductDiscount =  true;
    }
    
    public String getProductStatus()
    {
	    String statusString = "";
	    if(true == isActive)			statusString = "Product is avilable";
	    else if(true == isProductDiscount)	statusString = "Product is on sale";
	    return statusString;
    }
    

    /**
     * Get a String that describes this Product. Note that
     * this method overrides the toString method inherited
     * from Object.
     *
     * @return a String describing this Product.
     */
    public String getProductDetails() {
        return "Product Name: " + this.name +"\nPrice: " + this.price + "\nStock: " + this.stock;
    }
}
