public class Monitor extends Product {
    private String screenResolution;
    private boolean curved;
    private boolean is3d;

    public Monitor(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String screenResolution, boolean curved, boolean is3d) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.screenResolution = screenResolution;
        this.curved = curved;
        this.is3d = is3d;
    }

    public String toString() {

        return super.getProductName();
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public boolean isCurved() {
        return curved;
    }

    public void setCurved(boolean curved) {
        this.curved = curved;
    }

    public boolean is3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }
}