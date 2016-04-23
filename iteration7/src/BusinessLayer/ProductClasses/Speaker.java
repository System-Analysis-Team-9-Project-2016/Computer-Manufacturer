package BusinessLayer.ProductClasses;

public class Speaker extends Product {
    private int watts;
    private boolean desktopControls;
    private boolean subwoofer;
    private int satelliteSpeakers;

    public Speaker(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, int watts, boolean desktopControls, boolean subwoofer, int satelliteSpeakers) {
        super(productId, productName, stock, unitCost, isActive, isProductDiscount);
        this.watts = watts;
        this.desktopControls = desktopControls;
        this.subwoofer = subwoofer;
        this.satelliteSpeakers = satelliteSpeakers;

    }

    public String toString() {
    	return super.toString() + "," + this.watts + "," + this.desktopControls + "," + this.subwoofer + "," + this.satelliteSpeakers;
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
        return satelliteSpeakers;
    }

    public void setSatelliteSpeakersSpeakers(int satelliteSpeakers) {
        this.satelliteSpeakers = satelliteSpeakers;
    }
    
    public String getSpecs() {
    	return "Watts: " + watts + " Desktop Controls: " + desktopControls + " SubWoofer: "  + subwoofer + " Satellite Speakers: " + satelliteSpeakers;
    }
    
    
}