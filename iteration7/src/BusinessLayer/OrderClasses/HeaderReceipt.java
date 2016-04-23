package BusinessLayer.OrderClasses;

public class HeaderReceipt extends ReceiptDecorator {
	
	public HeaderReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + "<br>DCM Computing<br>";
	}
}