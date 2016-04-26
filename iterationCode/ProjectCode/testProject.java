public class testProject {
	
	public static void main(String [] args) {

/* 
-----------------------------------------------------------------------------------------------------------------------------------------
	Create new customer
	Customer(int customerId, String customerName , String customerEmail, String customerPassword, String creditCardNumber)
-----------------------------------------------------------------------------------------------------------------------------------------
*/
		Customer customer1 = new Customer(201, "Conor Duggan", "conor.duggan@ul.ie", "password", "123456789");

		// Display Customer data
		System.out.println("\nCustomer Created Info");
		System.out.println("--------------------------------");
		System.out.println("Customer ID: " + customer1.getCustomerId());
		System.out.println("Customer Name: " + customer1.getCustomerName());
		System.out.println("Customer Email: " + customer1.getCustomerEmail());
		System.out.println("Customer Password: " + customer1.getCustomerPassword());
		System.out.println("Customer Card No. : " + customer1.getCreditCardNumber());


		System.out.println("\n\n\n");


/* 
-----------------------------------------------------------------------------------------------------------------------------------------
	Create New Product
	Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount)
-----------------------------------------------------------------------------------------------------------------------------------------
*/
		Product product1 = new Product(40023, "CPU 1", 37, 99.99, true, false);

		// Display Product data
		System.out.println("\nProduct Created Info");
		System.out.println("--------------------------------");
		System.out.println("Product ID: " + product1.getProductId());
		System.out.println("Product Name: " + product1.getProductName());
		System.out.println("Product Stock: " + product1.getStock());
		System.out.println("Product Unit Cost: " + product1.getUnitCost());
		System.out.println("Product Status: " + product1.getProductStatus());


		System.out.println("\n\n\n");


/* 
-----------------------------------------------------------------------------------------------------------------------------------------
	Create New Order
	Order(int orderId, int customerId, String customerName, int shippingId, int [] productId, String [] productName, double [] unitCost)
-----------------------------------------------------------------------------------------------------------------------------------------
*/

		// Get info to create Order from Customer and Product
		int customerId = customer1.getCustomerId();
		String customerName = customer1.getCustomerName();
		int [] productId = {product1.getProductId()};
		String [] productName = {product1.getProductName()};
		double [] unitCost = {product1.getUnitCost()};

		
		Order order1 = new Order(54, customerId, customerName, 7623, productId, productName, unitCost);
		
		// Add this new Order to the ArrayList of customers orders in the Customer class.
		customer1.addToCustomersOrders(order1.getOrderId());

		// Display Product data
		System.out.println("\nOrder Created Info");
		System.out.println("--------------------------------");
		System.out.println(order1.getOrderDetails());
		System.out.println(order1.getShippingInfo());


		System.out.println("\n\n\n");


/* 
-----------------------------------------------------------------------------------------------------------------------------------------
	Add the created order to ArrayList of customerOrders in Customer class.
-----------------------------------------------------------------------------------------------------------------------------------------
*/
		System.out.println("\nCustomers Order ID list");
		System.out.println("--------------------------------");
		System.out.println(customer1.getCustomersOrders());
	}
}
