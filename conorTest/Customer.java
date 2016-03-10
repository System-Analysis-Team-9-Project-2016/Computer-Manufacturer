package systemAnalysis;

import java.util.ArrayList;

public class Customer {
	
	private String name;
	private String email;
	private String password;
	private String creditCardNumber;
	private ArrayList<String> orders;
	
	Customer(String name , String email, String password, String creditCardNumber){
		this.name = name;
		this.email = email;
		this.password = password;
		this.creditCardNumber = creditCardNumber;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public ArrayList<String> getOrders(){
		return orders;
	}
	
	//Replace String with order
	public void addToOrders(String o){
		orders.add(o);
	}
	
	
	
}
