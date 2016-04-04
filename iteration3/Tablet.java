public class Tablet extends ComputerSystem {
    private boolean stylus;
    private int screenSize;
    private int screenRez;
    private boolean attachableKeyboard;


    public Tablet(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, CPU systemCPU, GPU systemGPU, RAM systemRam, Motherboard systemMotherboard, String OS, boolean stylus, int screenSize, int screenRez, boolean attachableKeyboard, double weight) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount, systemCPU, systemGPU, systemRam, systemMotherboard, OS);
        this.stylus = stylus;
        this.screenSize = screenSize;
        this.screenRez = screenRez;
        this.attachableKeyboard = attachableKeyboard;
        this.weight = weight;
    }

    public String toString() {
        return super.getProductName();
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
}
