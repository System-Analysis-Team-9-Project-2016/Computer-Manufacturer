package BusinessLayer.CustomerClasses;



public class User {
	
	private String firstName;
	private String surname;
	private String email;
	private String password;
	
	public User(String firstName, String surname , String email, String password){
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String name) {
		this.surname = name;
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
}
