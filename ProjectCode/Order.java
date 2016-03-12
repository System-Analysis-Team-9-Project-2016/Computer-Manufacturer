import java.util.Date;

public class Order {
	
	private OrderDetail orderDetail;
	private ShippingInfo shippingInfo;

	private int orderId;
	private int customerId;
	private int shippingId;
	private String customerName;
	private String dateOrderCreated;
	private String dateOrderShipped;

	private boolean isNewOrder;
	private boolean isProcessedOrder;
	private boolean isCancelledOrder;
	
	Order(int orderId, int customerId, String customerName, int shippingId, int [] productId, String [] productName, double [] unitCost) {

		this.orderDetail = new OrderDetail(orderId, productId, productName, unitCost);
		this.shippingInfo = new ShippingInfo(shippingId);

		this.orderId = orderId;
		this.customerId = customerId;
		this.shippingId = shippingId;
		this.customerName = customerName;
		Date date = new Date();
		this.dateOrderCreated = date.toString();
		this.isNewOrder = true;
	}

// ShippingInfo Methods
	public String getShippingInfo() {
		return shippingInfo.getShippingInfo();
	}

	public void setShippingCost(double shippingCost) {
		shippingInfo.setShippingCost(shippingCost);
	}

	public void setShippingRegionId(int shippingRegionId) {
		shippingInfo.setShippingRegionId(shippingRegionId);
	}

// OrderDeatil Methods
	public String getOrderDetails() {
		String orderInfo = orderDetail.getOrderDetails() +
				"\nCustomer: " + customerName +
				"\n" + getOrderStatus() +
				"\nDate Order Created: " + dateOrderCreated;
		if (dateOrderShipped != null) orderInfo += "\nDate Order Shipped: " + dateOrderShipped;
		return orderInfo;
	}

// Order Methods
	public int getOrderId() {
		return orderId;
	}

	public String getOrderCreateDate() {
		return dateOrderShipped;
	}

	public String getOrderShippingDate() {
		return dateOrderShipped;
	}

	public void setOrderShippingDate() {
		Date date = new Date();
		this.dateOrderShipped = date.toString();
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
