public class Desktop extends ComputerSystem {

//    private Monitor systemMonitor;
//    private Keyboard systemKeyboard;
//    private Mouse systemMouse;
//    private Speaker systemSpeaker;
    private boolean gamingSystem;

    public Desktop(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean gamingSystem) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount, OS);
/*        this.systemMonitor = systemMonitor;
        this.systemKeyboard = systemKeyboard;
        this.systemMouse = systemMouse;
        this.systemSpeaker = systemSpeaker;*/
        this.gamingSystem = gamingSystem;
    }

//    public String toString() {
//        return super.getProductName();
//    }
//
//    public Monitor getSystemMonitor() {
//        return systemMonitor;
//    }
//
//    public void setSystemMonitor(Monitor systemMonitor) {
//        this.systemMonitor = systemMonitor;
//    }
//
//    public Keyboard getSystemKeyboard() {
//        return systemKeyboard;
//    }
//
//    public void setSystemKeyboard(Keyboard systemKeyboard) {
//        this.systemKeyboard = systemKeyboard;
//    }
//
//    public Mouse getSystemMouse() {
//        return systemMouse;
//    }
//
//    public void setSystemMouse(Mouse systemMouse) {
//        this.systemMouse = systemMouse;
//    }

    public boolean isGamingSystem() {
        return gamingSystem;
    }

    public void setGamingSystem(boolean gamingSystem) {
        this.gamingSystem = gamingSystem;
    }

//    public Speaker getSystemSpeaker() {
//        return systemSpeaker;
//    }
//
//    public void setSystemSpeaker(Speaker systemSpeaker) {
//        this.systemSpeaker = systemSpeaker;
//    }
}