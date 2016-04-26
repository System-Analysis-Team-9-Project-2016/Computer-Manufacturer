import java.util.ArrayList;

public class Customer {
	
	private String firstName;
	private String surname;
	private String email;
	private String password;
	private String creditCardNumber;
	private ArrayList<String> orders;
	
	Customer(String firstName , String surname, String email, String password, String creditCardNumber){
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.creditCardNumber = creditCardNumber;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setSurname(String name) {
		this.surname = name;
	}
	
	public String getSurname() {
		return surname;
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
