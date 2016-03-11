public class testOrderComposition {
	
	public static void main(String [] args) {

		int [] productIds = {45, 56, 132};
		String [] productNames = {"CPU", "Graphics Card", "RAM"};
		double [] unitCosts = {32.99, 78.95, 100.00};

		// int orderId, int customerId, String customerName, int shippingId, int [] productId, String [] productName, double [] unitCost
		Order order1 = new Order(1, 32, "Conor Duggan", 1231, productIds, productNames, unitCosts);
		
		System.out.println(order1.getOrderDetails());

		System.out.println(order1.getShippingInfo());
	}
}
