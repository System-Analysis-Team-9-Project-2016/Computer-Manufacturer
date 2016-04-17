package BusinessLayer.OrderClasses;

import java.util.ArrayList;

import BusinessLayer.ProductClasses.Product;

public class OrderDetail {
	
	private int orderId;
	private ArrayList<Product> orderProducts;
	private double totalCost;

	OrderDetail (int orderId, ArrayList<Product> orderProducts) {
		this.orderId = orderId;
		this.orderProducts = orderProducts;
		for (int i = 0; i < orderProducts.size(); i++)
			this.totalCost += orderProducts.get(i).getUnitCost();
		// Add shipping cost
		this.totalCost += 5.0;
	}

	public int [] getOrderProductIds() {
		int [] orderProductIds = new int [orderProducts.size()];
		for (int i = 0; i < orderProducts.size(); i++) {
			orderProductIds[i] = orderProducts.get(i).getProductId();
		}
		return orderProductIds; 
	}
	
	public String getOrderProductIdsToString() {
		String productIdString = "";
		for (int i = 0; i < orderProducts.size(); i++) {
			productIdString += orderProducts.get(i).getProductId() + " ";
		}
		return productIdString;
	}
	
	public String [] getOrderProductNames() {
		String [] orderProductNames = new String [orderProducts.size()];
		for (int i = 0; i < orderProducts.size(); i++) {
			orderProductNames[i] = orderProducts.get(i).getProductName();
		}
		return orderProductNames;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public String getOrderDetails() {
		String returnString = "Order ID: " + orderId;
		
		for (int i = 0; i < orderProducts.size(); i++) {
			returnString += "<br>Product ID:" + orderProducts.get(i).getProductId();
			returnString += "<br>Product Name:" + orderProducts.get(i).getProductName();
			returnString += "<br>Product Price:" + orderProducts.get(i).getUnitCost() + "<br>";
		}

		returnString += "<br>TotalCost: " + totalCost + "<br>";
		return returnString;
	}
	
	public ArrayList<Product> getProducts() {
		return orderProducts;
	}
	
	public void setProducts(ArrayList<Product> orderProducts) {
		this.orderProducts = orderProducts;
		this.totalCost = 0.0;
		for (int i = 0; i < orderProducts.size(); i++)
			totalCost += orderProducts.get(i).getUnitCost();
	}
}