public class ShippingInfo {
	
	private int shippingId;
	private double shippingCost;
	private int shippingRegionId;

	ShippingInfo (int shippingId) {
		this.shippingId = shippingId;
		this.shippingCost = 5.0;
		this.shippingRegionId = 1;
	}

	public String getShippingInfo() {
		return "\nShipping ID: " + shippingId + 
				"\nShipping Cost: " + shippingCost + 
				"\nShipping Region: " + shippingRegionId;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public void setShippingRegionId(int shippingRegionId) {
		this.shippingRegionId = shippingRegionId;
	}
}