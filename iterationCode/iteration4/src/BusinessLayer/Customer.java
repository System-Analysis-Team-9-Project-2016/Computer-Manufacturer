package BusinessLayer;


import java.util.ArrayList;

public class Customer extends User {
	
	private int customerId;
	private String creditCardNumber;
	private String customerAddress;
	private ArrayList<Integer> customerOrders;
	
	public Customer(int id, String firstName, String surname, String address, String email, String password, String creditCardNumber){
		super(firstName, surname ,email , password);
		this.customerId = id;
		this.customerAddress = address;
		this.creditCardNumber = creditCardNumber;
		
		
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}	
}
