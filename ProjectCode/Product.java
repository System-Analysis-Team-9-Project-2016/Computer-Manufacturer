import java.text.*;
import java.util.*;

/**
 * This class models a Product that can be sold in
 * the on-line e-commerce system example.
 */
public class Product {
    private int productId;
    private String productName;
    private boolean isActive;
    private boolean isProductDiscount;
    private double unitCost;
    private int stock;

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
    Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount) {
        this.productId = productId; //Generate new Id function should be used here
        this.productName = productName;
        this.stock = stock;
        this.unitCost= unitCost;
        this.isActive = isActive;
        this.isProductDiscount = isProductDiscount;
    }
    
    /**
     * Get the ID of this Product.
     *
     * @return the ID of this Product.
     */
    public int getProductId() {
        return productId;
    }
  
    /**
     * Get the productName of this Product.
     *
     * @return the productName of this Product.
     */
    public String getProductName() {
        return productName;
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
        return unitCost;
    }

    public void setUnitCost(double newUnitCost) {
        this.unitCost= newUnitCost;
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
	    if(true == isActive)			statusString = "Product is available";
	    else if(true == isProductDiscount)	statusString = "Product is on sale";
	    return statusString;
    }
}
