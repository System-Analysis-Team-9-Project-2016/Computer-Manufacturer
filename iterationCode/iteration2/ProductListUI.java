public class ProductListUI {
	
	ProductListUI(Customer currentCustomer) {
		// Creates a new GUI window

		// Displays list of products available to buy.
		// Beside each product is an 'Add to Cart' button.

		// There are also buttons for 'Log Out' and 'Go to Cart',
		// which will call their relevant methods in ProductList.java

		// Clicking 'Go to Cart' will send an arraylist the user chosen products back to its method in ProductList.java
	}

	ProductListUI(Admin currentAdmin) {
		// Creates a new GUI window

		// Displays list of products available to buy.
		// Beside each product is an 'Add to Cart' button.

		// There are also buttons for 'Log Out', 'Add New Product', 'Apply Discount' and 'Go to Cart',
		// which will call their relevant methods in ProductList.java

		// *** 'Add New Product' and 'Apply Discount' buttons only available to Admin users.

		// Clicking 'Go to Cart' will send an arraylist the user chosen products back to its method in ProductList.java
	}
}