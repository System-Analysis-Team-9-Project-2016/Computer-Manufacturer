public class LogIn {
	
	Login() {
		// Create an object of type LogInUI (GUI window) 
		// LogInUI createNewLogInUI = new LogInUI();

	}

	goBackButtonClicked() {
		// Create a new object of type HomeScreen.java
		// HomeScreen createNewHomeScreen = new HomeScreen();
	}

	registerButtonCLicked() {
		// Create an object of type Register.java
		// Register createNewRegister = new Register();
	}

	processLogInButtonClicked() {
		// Read in the text fields in the LogInUI for email and password.
		// Check if they are present and correct against customerList.txt file.

		// If the email is correct but password incorrect, tell the user
		// If the email address entered doesn't match any in the .txt file
		// tell the user that it's incorrect or not registered.
		// Make them enter a correct one until the either click 'Go Back' or 'Register'

		// If the details are correct create an object of Customer or Admin type using them.
		// e.g. String customerName , String customerEmail, String customerPassword, String creditCardNumber

		// Call object of type ProductList and pass in the Customer object created.
		// ProductList createNewProductList = new ProductList(currentCustomer);
		// OR
		// ProductList createNewProductList = new ProductList(currentAdmin);
	}
}