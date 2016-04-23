package BusinessLayer.OrderClasses;

public class BasicReceipt extends Receipt {

	@Override
	public String printReceipt() {
		return "Note: ";
	}
}