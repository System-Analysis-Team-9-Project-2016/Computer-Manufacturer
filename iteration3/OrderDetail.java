public class OrderDetail {
	
	private int orderId;
	private int [] productId;
	private String [] productName;
	private double [] unitCost;
	private double totalCost;

	OrderDetail (int orderId, int [] productId, String [] productName, double [] unitCost) {
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.unitCost = unitCost;
		for ( double price : unitCost )
			this.totalCost += price;
	}

	public String getOrderDetails() {
		String returnString = "";
		
		returnString += "\nOrder ID: " + orderId + "\nProduct IDs: ";
		for ( int id : productId )
			returnString += id + ", "; 

		returnString += "\nProduct Names: ";
		for ( String name : productName )
			returnString += name + ", "; 

		returnString += "\nUnit Costs:  ";
		for ( double price : unitCost )
			returnString += price + ", "; 

		returnString += "\nTotalCost: " + totalCost;
		return returnString;
	}
}