

public class Admin extends User{
	
	int adminID;
	
	public Admin(int adminID , String username , String email , String password ){
		super(username , email , password);
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}

	
	
	
	

}


