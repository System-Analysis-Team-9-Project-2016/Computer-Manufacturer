public class RAM extends Product {


    private String type;
    private String multiChanel;
    private double casLatency;

    public RAM(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String type, String multiChanel, double casLatency) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.type = type;
        this.multiChanel = multiChanel;
        this.casLatency = casLatency;
    }



    public String toString() {
        return super.getProductName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMultiChanel() {
        return multiChanel;
    }

    public void setMultiChanel(String multiChanel) {
        this.multiChanel = multiChanel;
    }

    public double getCasLatency() {
        return casLatency;
    }

    public void setCasLatency(double casLatency) {
        this.casLatency = casLatency;
    }


}