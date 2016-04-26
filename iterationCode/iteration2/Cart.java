public class Cart {
	
	Cart(Customer currentCustomer, int [] productIds) {
		// Read in productIds int array and pull the details of each product 
		// the user wants to buy from the productList.txt file.
		// Create an Order object using them and the Customer object

		// Create CartUI object
	}

	Cart(Admin currentAdmin, int [] productIds) {

	}

	goBackButtonClicked() {
		// Create a new object of type ProductList.java
		// ProductList createNewProductList = new ProductList(currentCustomer);
	}

	goBackButtonClicked() {
		// Create a new object of type ProductList.java
		// ProductList createNewProductList = new ProductList(currentAdmin);
	}

	processRemoveItemButtonClicked(Order userOrder, int productIdToRemove) {
		//Remove item from users Order
	}

	processRemoveItemButtonClicked(Order userOrder, int productIdToRemove) {
		//Remove item from users Order
	}

	processProceedToCheckoutButtonClicked(Order userOrder) {
		// Create an object of type EditOrderDetails
		// EditOrderDetails createNewEditOrderDetails = new EditOrderDetails(userOrder, currentCustomer);
		// OR
		// EditOrderDetails createNewEditOrderDetails = new EditOrderDetails(userOrder, currentAdmin);
	}
}