package BusinessLayer.OrderClasses;

abstract public class ReceiptDecorator extends Receipt {

	private Receipt receipt;
	
	public ReceiptDecorator(Receipt receipt) {
		this.receipt = receipt;
	}
	
	@Override
	public String printReceipt() {
		if (receipt != null) return receipt.printReceipt(); 
		return null;
	}
}