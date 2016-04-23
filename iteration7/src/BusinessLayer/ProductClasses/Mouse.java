package BusinessLayer.ProductClasses;

public class Mouse extends Product {
    private int dpi;
    private boolean programmableButtons;
    private boolean dpiSwitching;
    public Mouse(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, int dpi, boolean programmableButtons, boolean dpiSwitching) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.dpi = dpi;
        this.programmableButtons = programmableButtons;
        this.dpiSwitching = dpiSwitching;
    }

    public String toString() {
    	return super.toString() + "," + this.dpi + "," + this.programmableButtons + "," + this.dpiSwitching;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public boolean isProgrammableButtons() {
        return programmableButtons;
    }

    public void setProgrammableButtons(boolean programmableButtons) {
        this.programmableButtons = programmableButtons;
    }

    public boolean isDpiSwitching() {
        return dpiSwitching;
    }

    public void setDpiSwitching(boolean dpiSwitching) {
        this.dpiSwitching = dpiSwitching;
    }
    
    public String getSpecs() {
    	return "DPI: " + dpi + " Programmable: " + programmableButtons + " DPI Switching: "  + dpiSwitching;
    }
}