//package systemAnalysis;  <-  Weirdly causing a compile error on my machine so commented out

import java.util.ArrayList;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private String creditCardNumber;
	private ArrayList<Integer> customerOrders;
	
	Customer(int customerId, String customerName , String customerEmail, String customerPassword, String creditCardNumber){
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.creditCardNumber = creditCardNumber;
		this.customerOrders = new ArrayList<Integer>();
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getCustomersOrders(){
		String customerOrderIdList = "";
		for (int i = 0; i < customerOrders.size(); i++) {
			customerOrderIdList += customerOrders.get(i);
		}
		if (customerOrderIdList == "") return "No orders for this customer";
		return customerOrderIdList;
	}
	
	public void addToCustomersOrders(int orderId) {
		customerOrders.add(orderId);
	}
}
