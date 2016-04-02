public class GPU extends Product {


    private String memory;
    private boolean virtualRealityReady = false;
    private int displayPorts = 1;
    private String maxResolution = "";

    public GPU(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String memory, boolean virtualRealityReady, int displayPorts) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.memory = memory;
        this.virtualRealityReady = virtualRealityReady;
        this.displayPorts = displayPorts;
    }



    public String toString() {
        return super.getProductName();
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public int getDisplayPorts() {
        return displayPorts;
    }

    public void setDisplayPorts(int displayPorts) {
        this.displayPorts = displayPorts;
    }

    public boolean isVirtualRealityReady() {
        return virtualRealityReady;
    }

    public void setVirtualRealityReady(boolean virtualRealityReady) {
        this.virtualRealityReady = virtualRealityReady;
    }
}