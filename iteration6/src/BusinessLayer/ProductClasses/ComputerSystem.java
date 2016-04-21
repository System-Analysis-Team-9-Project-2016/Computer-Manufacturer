package BusinessLayer.ProductClasses;

public class ComputerSystem extends Product {

    private String OS;

    public ComputerSystem(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.OS = OS;
    }


    /**
    public static void main(String[] args) {
        CPU compCPU = new CPU(1, "BIGCPU", 11, 1100.23, true, false, "7 Series", "BIGSOCKET", 3.7);
        ComputerSystem me = new ComputerSystem(1, "Hello", 11, 11.23, true, false, compCPU, "Titan", "Windows 7");
        System.out.println("Your name is " + compCPU.getProductName());
        System.out.println("My name is " + me);
    }
     */

    /**public CPU getSystemCPU() {
        return systemCPU;
    }
    */


    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
 }