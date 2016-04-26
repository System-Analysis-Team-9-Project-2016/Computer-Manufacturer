package BusinessLayer.ProductClasses;

public class Motherboard extends Product {


    private String cpuSocketType;
    private String series;
    private String formFactor;
    private String memoryStandard;

    public Motherboard(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String cpuSocketType, String series, String formFactor, String memoryStandard) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.cpuSocketType = cpuSocketType;
        this.series = series;
        this.formFactor = formFactor;
        this.memoryStandard = memoryStandard;
    }


    public String getCpuSocketType() {
        return cpuSocketType;
    }

    public void setCpuSocketType(String cpuSocketType) {
        this.cpuSocketType = cpuSocketType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getMemoryStandard() {
        return memoryStandard;
    }

    public void setMemoryStandard(String memoryStandard) {
        this.memoryStandard = memoryStandard;
    }
    
    public String getSpecs() {
    	return "CPU Socket Type: " + cpuSocketType + " Series: " + series + " Form Factor: "  + formFactor + " Memory Standard: " + memoryStandard;
    }
}