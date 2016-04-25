package BusinessLayer.OrderClasses;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class OrderDetail {
	
	private int orderId;
	private ArrayList<Product> orderProducts;
	private double totalCost;
	private boolean isGroupDiscount;
	private double maxDiscount;

	OrderDetail (int orderId, ArrayList<Product> orderProducts) throws IOException {
		this.orderId = orderId;
		this.orderProducts = orderProducts;
		this.isGroupDiscount = false;
		for (int i = 0; i < orderProducts.size(); i++)
			this.totalCost += orderProducts.get(i).getUnitCost();
		
		
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
			try {
				if(orderProducts.get(i).getDiscount() == 0)
					returnString += "<br>Product Price:" + orderProducts.get(i).getUnitCost() + "<br>";
				else{
					returnString += "<br>Discount Applied:" + orderProducts.get(i).getDiscount() + "%";
					returnString += "<br>Product Price:" + new DecimalFormat("##.##").format(orderProducts.get(i).getUnitCost()) + "<br>";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(this.isGroupDiscount)
			returnString += "<br>Group Discount of " + maxDiscount  + "% applied.<br>";

		returnString += "<br>TotalCost: " +  new DecimalFormat("##.##").format(totalCost) + "<br>";
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
		BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
		ArrayList<GroupDiscount> groupDiscounts;
		try {
			groupDiscounts = dataControl.getAllGroupDiscountsFromFile();
			maxDiscount = 0;
			GroupDiscount g;
			for(int j = 0;j < groupDiscounts.size();j++){
				g = groupDiscounts.get(j);
				if(g.areProductsValid(orderProducts)){
					if(g.getDiscount() > maxDiscount)
						maxDiscount = g.getDiscount();
						this.isGroupDiscount = true;
					//System.out.println("Found Discount");
				}
			 }
			 totalCost = totalCost * (1 - (maxDiscount / 100));
			 
			// Add shipping cost
			this.totalCost += 5.0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}