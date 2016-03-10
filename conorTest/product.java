import java.text.*;
import java.util.*;

/**
 * This class models a Product that can be sold in
 * the on-line e-commerce system example.
 */
public class Product {
    private PID;
    private string Name;
    private boolean isActive;
    private date LaunchDate;
    private double price;

    /**
     * Construct a new product using the provided item
     * and price.
     *
     * @param PID the productId of the product.
     * @param isActive states wether the product is active or not.
     * @param name the name of the product.
     * @param launchDate the launchdate of this product
     * @param price the price for which this Product should be sold.
     */
    public Product(string name, boolean launchDate, double price, boolean isActive) {
        this.PID = generateNewID();
        this.name = name;
        this.launchdate = launchdate;
        this.price = price
        this.isActive = isActive;

    }

    /**
     * Get the name of this Product.
     *
     * @return the name of this Product.
     */
    public string getName() {
        return name;
    }
    public void setName(string name) {
        this.name =  name;
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
        price = newPrice;
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
     * Get the launchdate of this Product.
     *
     * @return the launchdate of this Product.
     */
    public date getLaunchDate() {
        return launchDate;
    }
    public void setLaunchDate(date launchDate) {
        this.launchdate =  launchDate;
    }

    /**
     * Get a String that describes this Product. Note that
     * this method overrides the toString method inherited
     * from Object.
     *
     * @return a String describing this Product.
     */
    public String getProductDetails() {
        return "Product Name: " + this.name +"\nPrice: " + this.price + "\nLaunchDate" + LaunchDate;
    }
}
