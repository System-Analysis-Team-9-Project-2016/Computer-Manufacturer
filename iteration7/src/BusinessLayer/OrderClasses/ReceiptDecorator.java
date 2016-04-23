package BusinessLayer.OrderClasses;

public class ReceiptDecorator implements Receipt {

	protected Receipt receipt;
	
	public ReceiptDecorator(Receipt receipt) {
		this.receipt = receipt;
	}
	
	@Override
	public String printReceipt() {
		return "test";
	}
}
