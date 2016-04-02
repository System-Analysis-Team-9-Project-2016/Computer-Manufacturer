public class Keyboard extends Product {
    private String keySwitchType;
    private boolean backlit;

    public Keyboard(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String keySwitchType, boolean backlit) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.keySwitchType = keySwitchType;
        this.backlit = backlit;
    }

    public String toString() {

        return super.getProductName();
    }

    public String getKeySwitchType() {
        return keySwitchType;
    }

    public void setKeySwitchType(String keySwitchType) {
        this.keySwitchType = keySwitchType;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }
}