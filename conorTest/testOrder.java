public class testOrder {
	
	private int orderId;
	private int customerId;
	private int [] productIds;
	private double totalPrice;
	private String shippingAddress;
	private boolean isNewOrder;
	private boolean isProcessedOrder;
	private boolean isCancelledOrder;
	
	testOrder(int orderId, int customerId, int [] productIds, double totalPrice, String shippingAddress) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.productIds = productIds;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.isNewOrder = true;
	}

	public String getProductIds() {
		String productIdString = "";

		for (int i = 0; i < productIds.length; i++) {
			if (productIds.length - 1 == i) productIdString += productIds[i];
			else productIdString += productIds[i] + ", ";
		}
		return productIdString;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setProcessOrder() {
		this.isNewOrder = false;
		this.isProcessedOrder = true;
		this.isCancelledOrder = false;
	}

	public void setCancelOrder() {
		this.isNewOrder = false;
		this.isProcessedOrder = false;
		this.isCancelledOrder = true;
	}

	public String getOrderStatus() {
		String orderStatusString = "";
		if (true == isNewOrder) 		orderStatusString = "Order has been created!";
		if (true == isProcessedOrder) 	orderStatusString = "Order is being processed!";
		if (true == isCancelledOrder) 	orderStatusString = "Order has been cancelled!";
		return orderStatusString;
	}
}
