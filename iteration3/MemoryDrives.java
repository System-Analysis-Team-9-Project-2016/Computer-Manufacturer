public class MemoryDrives extends Product {
    private boolean desktopType;
    private int driveCapacity;
    private String RPM;

    public MemoryDrives(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, boolean desktopType, int driveCapacity, String RPM) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.desktopType = desktopType;
        this.driveCapacity = driveCapacity;
        this.RPM = RPM;
    }

    public boolean isDesktopType() {
        return desktopType;
    }

    public void setDesktopType(boolean desktopType) {
        this.desktopType = desktopType;
    }

    public int getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(int driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public String getRPM() {
        return RPM;
    }

    public void setRPM(String RPM) {
        this.RPM = RPM;
    }
}
