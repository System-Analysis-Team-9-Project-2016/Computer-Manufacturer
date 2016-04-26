package BusinessLayer.OrderClasses;

import java.util.ArrayList;
import java.util.Date;

import BusinessLayer.ProductClasses.Product;

@SuppressWarnings("unused")
public class Order {
	
	private OrderDetail orderDetail;
	private ShippingInfo shippingInfo;

	private int orderId;
	private int customerId;
	private int shippingId;
	private String customerName;
	private String dateOrderCreated;
	private String dateOrderShipped;
	private ArrayList<Product> orderProducts;

	private boolean isNewOrder;
	private boolean isProcessedOrder;
	private boolean isCancelledOrder;
	
	public Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts) {

		this.orderDetail = new OrderDetail(orderId, orderProducts);
		this.shippingInfo = new ShippingInfo(shippingId);

		this.orderId = orderId;
		this.customerId = customerId;
		this.shippingId = shippingId;
		this.customerName = customerName;
		Date date = new Date();
		this.dateOrderCreated = date.toString();
		this.isNewOrder = true;
		this.orderProducts = orderProducts;
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

// OrderDetail Methods
	public double getTotalCost() {
		return orderDetail.getTotalCost();
	}

	public int [] getOrderProductIds() {
		return orderDetail.getOrderProductIds();
	}
	
	public String getOrderProductIdsToString() {
		return orderDetail.getOrderProductIdsToString();
	}

	public String getPreOrderDetails() {
		String orderInfo = orderDetail.getOrderDetails();
		return orderInfo;
	}

	public String getPostOrderDetails() {
		String orderInfo = orderDetail.getOrderDetails() +
				"<br>Customer: " + customerName +
				"<br>" + getOrderStatus() +
				"<br>Date Order Created: " + dateOrderCreated;
		if (dateOrderShipped != null) orderInfo += "<br>Date Order Shipped: " + dateOrderShipped;
		return orderInfo;
	}
	
	public String [] getOrderProductNames() {
		return orderDetail.getOrderProductNames();
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

	public void setOrderShippingDate(String dateOrderShipped) {
		this.dateOrderShipped = dateOrderShipped;
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
	
	public ArrayList<Product> getProducts() {
		return orderProducts;
	}
	
	public void setProducts(ArrayList<Product> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
