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
    private Date launchDate;
    private double price;

    /**
     * Construct a new product using the provided item
     * and price.
     *
     * @param PID the productId of the product.
     * @param isActive states wether the product is active or not.
     * @param name the name of the product.
     * @param launchDate the launchDate of this product
     * @param price the price for which this Product should be sold.
     */
    public product(String name, Date launchDate, double price, boolean isActive) {
        this.PID = "1234567890"; //Generate new Id function should be used here
        this.name = name;
        this.launchDate = launchDate;
        this.price = price;
        this.isActive = isActive;

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
    /**
     * Get the active state of this Product.
     *
     * @return the active state of this Product.
     */
    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isItActive) {
        this.isActive =  isItActive;
    }
    /**
     * Get the launchDate of this Product.
     *
     * @return the launchDate of this Product.
     */
    public Date getlaunchDate() {
        return launchDate;
    }
    public void setlaunchDate(Date launchDate) {
        this.launchDate =  launchDate;
    }

    /**
     * Get a String that describes this Product. Note that
     * this method overrides the toString method inherited
     * from Object.
     *
     * @return a String describing this Product.
     */
    public String getProductDetails() {
        return "Product Name: " + this.name +"\nPrice: " + this.price + "\nlaunchDate" + launchDate;
    }
}
