package BusinessLayer.OrderClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class OrderDetail {
	
	private int orderId;
	private ArrayList<Product> orderProducts;
	private double totalCost;

	OrderDetail (int orderId, ArrayList<Product> orderProducts) throws IOException {
		this.orderId = orderId;
		this.orderProducts = orderProducts;
		for (int i = 0; i < orderProducts.size(); i++)
			this.totalCost += orderProducts.get(i).getUnitCost();
		// Add shipping cost
		ArrayList<GroupDiscount> groupDiscounts = DataControl.getAllGroupDiscountsFromFile();
		double maxDiscount = 0;
		GroupDiscount g;
		for(int j = 0;j < groupDiscounts.size();j++){
			g = groupDiscounts.get(j);
			if(g.areProductsValid(orderProducts)){
				if(g.getDiscount() > maxDiscount)
					maxDiscount = g.getDiscount();
				//System.out.println("Found Discount");
			}
		}
		totalCost = totalCost * (1 - (maxDiscount / 100));
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


