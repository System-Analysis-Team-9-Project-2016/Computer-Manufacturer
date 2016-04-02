public class CPU extends Product {
    private String series;
    private String CPUSocketType;
    private double OperatingFrequency;

    public CPU(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String series, String CPUSocketType, double operatingFrequency) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.series = series;
        this.CPUSocketType = CPUSocketType;
        this.OperatingFrequency = operatingFrequency;
    }

    public String toString() {

        return super.getProductName();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCPUSocketType() {
        return CPUSocketType;
    }

    public void setCPUSocketType(String CPUSocketType) {
        this.CPUSocketType = CPUSocketType;
    }

    public double getOperatingFrequency() {
        return OperatingFrequency;
    }

    public void setOperatingFrequency(double operatingFrequency) {
        OperatingFrequency = operatingFrequency;
    }
}