public class ComputerSystem extends Product {

    private CPU systemCPU;
    private GPU systemGPU;
    private Motherboard systemMotherboard;
    private RAM systemRam;
    private String OS;

    public ComputerSystem(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, CPU systemCPU, GPU systemGPU, RAM systemRam, Motherboard systemMotherboard, String OS) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.systemCPU = systemCPU;
        this.systemGPU = systemGPU;
        this.systemMotherboard = systemMotherboard;
        this.OS = OS;
    }

    public String toString() {
        return super.getProductName();
    }

    /**
    public static void main(String[] args) {
        CPU compCPU = new CPU(1, "BIGCPU", 11, 1100.23, true, false, "7 Series", "BIGSOCKET", 3.7);
        ComputerSystem me = new ComputerSystem(1, "Hello", 11, 11.23, true, false, compCPU, "Titan", "Windows 7");

        System.out.println("Your name is " + compCPU.getProductName());
        System.out.println("My name is " + me);
    }
     */

    public CPU getSystemCPU() {
        return systemCPU;
    }

    public void setSystemCPU(CPU systemCPU) {
        this.systemCPU = systemCPU;
    }

    public GPU getSystemGPU() {
        return systemGPU;
    }

    public void setSystemGPU(GPU systemGPU) {
        this.systemGPU = systemGPU;
    }

    public Motherboard getSystemMotherboard() {
        return systemMotherboard;
    }

    public void setSystemMotherboard(Motherboard systemMotherboard) {
        this.systemMotherboard = systemMotherboard;
    }

    public RAM getSystemRam() {
        return systemRam;
    }

    public void setSystemRam(RAM systemRam) {
        this.systemRam = systemRam;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
 }
