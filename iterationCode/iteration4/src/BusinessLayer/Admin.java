package BusinessLayer;



public class Admin extends User{
	
	int adminID;
	
	public Admin(int adminID , String firstName, String surname, String email , String password ){
		super(firstName, surname , email , password);
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}
}