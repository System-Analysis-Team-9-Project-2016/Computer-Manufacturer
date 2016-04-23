package BusinessLayer.ProductClasses;

public class RAM extends Product {


    private String type;
    private String multiChannel;
    private double casLatency;

    public RAM(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String type, String multiChannel, double casLatency) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.type = type;
        this.multiChannel = multiChannel;
        this.casLatency = casLatency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMultiChannel() {
        return multiChannel;
    }

    public void setMultiChannel(String multiChannel) {
        this.multiChannel = multiChannel;
    }

    public double getCasLatency() {
        return casLatency;
    }

    public void setCasLatency(double casLatency) {
        this.casLatency = casLatency;
    }
    
    public String getSpecs() {
    	return "Type: " + type + " Multi Channel: " + multiChannel + " CAS latency: "  + casLatency;
    }
}