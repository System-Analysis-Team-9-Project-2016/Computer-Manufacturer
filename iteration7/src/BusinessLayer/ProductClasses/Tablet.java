package BusinessLayer.ProductClasses;

public class Tablet extends ComputerSystem {
    private boolean stylus;
    private int screenSize;
    private int screenRez;
    private boolean attachableKeyboard;
    private double weight;

    public Tablet(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean stylus, int screenSize, int screenRez, boolean attachableKeyboard, double weight) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount, OS);
        this.stylus = stylus;
        this.screenSize = screenSize;
        this.screenRez = screenRez;
        this.attachableKeyboard = attachableKeyboard;
        this.weight = weight;
    }

    public String toString() {
    	 return super.toString() + "," + this.stylus + "," + this.screenSize + "," + this.screenRez + "," + this.attachableKeyboard + "," +  this.weight;
    }

    public boolean isStylus() {
        return stylus;
    }

    public void setStylus(boolean stylus) {
        this.stylus = stylus;
    }

    public boolean isAttachableKeyboard() {
        return attachableKeyboard;
    }

    public void setAttachableKeyboard(boolean attachableKeyboard) {
        this.attachableKeyboard = attachableKeyboard;
    }

    public int getScreenRez() {
        return screenRez;
    }

    public void setScreenRez(int screenRez) {
        this.screenRez = screenRez;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
    public double getWeight() {
    	return weight;
    }
    public void setWeight(double weight) {
    	this.weight = weight;
    }
}