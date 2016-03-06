public class testCreateOrder {
	
	public static void main(String [] args) {
		int [] productIds = {64, 04, 29};

		testOrder order1 = new testOrder(1, 1234, productIds, 23.99, "Castletroy, Limerick");

		System.out.println("\n\t\tOrder Details");
		System.out.println("-------------------------------------------");
		System.out.println("\nProduct Id's:\t\t" + order1.getProductIds());
		System.out.println("Total Price:\t\t" + order1.getTotalPrice());
		System.out.println("Shipping Address:\t" + order1.getShippingAddress());
		System.out.println(order1.getOrderStatus());
		System.out.println();

		order1.setCancelOrder();

		System.out.println("\n\t\tOrder Details");
		System.out.println("-------------------------------------------");
		System.out.println("\nProduct Id's:\t\t" + order1.getProductIds());
		System.out.println("Total Price:\t\t" + order1.getTotalPrice());
		System.out.println("Shipping Address:\t" + order1.getShippingAddress());
		System.out.println(order1.getOrderStatus());
		System.out.println();

		order1.setProcessOrder();

		System.out.println("\n\t\tOrder Details");
		System.out.println("-------------------------------------------");
		System.out.println("\nProduct Id's:\t\t" + order1.getProductIds());
		System.out.println("Total Price:\t\t" + order1.getTotalPrice());
		System.out.println("Shipping Address:\t" + order1.getShippingAddress());
		System.out.println(order1.getOrderStatus());
		System.out.println();
	}
}
