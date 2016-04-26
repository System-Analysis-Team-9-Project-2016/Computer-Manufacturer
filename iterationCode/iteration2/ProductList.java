public class ProductList {
	
	ProductList(Customer currentCustomer) {
		// Takes in object of Customer type from either Register or LogIn

		// Read from the productList.txt file all products currently sold by our company.
		// Create an object of Product type for each.

		// Creates a new object of type ProductListUI passing in ***********************************************************

	}

	ProductList(Admin currentAdmin) {
		// Takes in object of Admin type from LogIn

		// Read from the productList.txt file all products currently sold by our company.
		// Create an object of Product type for each.

		// Creates a new object of type ProductListUI passing in ***********************************************************

	}

	processLogOutButtonClicked() {
		// Create a new object of type HomeScreen
		// As currentCustomer/currentAdmin will no longer be referenced will that be enough to count as Log Out??
		// HomeScreen createNewHomeScreen = new HomeScreen();
	}

	processGoToCartButtonClicked(Customer currentCustomer) {
		// Create new object of type Cart
		// Capture the list of product ID's the user wants to buy
		// Cart createNewCart = new Cart(currentCustomer, productIds);
	}

	processGoToCartButtonClicked(Admin currentAdmin) {
		// Create new object of type Cart
		// Capture the list of product ID's the user wants to buy
		// Cart createNewCart = new Cart(currentAdmin, productIds);
	}

	// Button only available to Admin users.
	processAddNewProductButtonClicked(Admin currentAdmin) {
		// Create a new object of type AddNewProduct
		// AddNewProduct createNewAddNewProduct = new AddNewProduct(currentAdmin);
	}

	// Button only available to Admin users.
	processApplyDiscountButtonClicked(Admin currentAdmin) {
		// Create a new object of type ApplyDiscount
		// ApplyDiscount createNewApplyDiscount = new ApplyDiscount(currentAdmin);
	}
}