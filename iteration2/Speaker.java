public class Speaker extends Product {
    private int watts;
    private boolean desktopControls;
    private boolean subwoofer;
    private int sataliteSpeakers;

    public Speaker(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, int watts, boolean desktopControls, boolean subwoofer, int sataliteSpeakers) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.watts = watts;
        this.desktopControls = desktopControls;
        this.subwoofer = subwoofer;
        this.sataliteSpeakers = sataliteSpeakers;

    }

    public String toString() {

        return super.getProductName();
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public boolean isDesktopControls() {
        return desktopControls;
    }

    public void setDesktopControls(boolean desktopControls) {
        this.desktopControls = desktopControls;
    }

    public boolean isSubwoofer() {
        return subwoofer;
    }

    public void setSubwoofer(boolean subwoofer) {
        this.subwoofer = subwoofer;
    }

    public int getSataliteSpeakers() {
        return sataliteSpeakers;
    }

    public void setSataliteSpeakers(int sataliteSpeakers) {
        this.sataliteSpeakers = sataliteSpeakers;
    }
}