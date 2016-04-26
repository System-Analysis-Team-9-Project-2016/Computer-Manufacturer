package BusinessLayer.OrderClasses;

public class BasicReceipt implements Receipt {

	@Override
	public String printReceipt() {
		return "Basic Receipt";
	}
}
