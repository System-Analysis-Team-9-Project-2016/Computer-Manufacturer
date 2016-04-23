package BusinessLayer.OrderClasses;

public class HeaderReceipt extends ReceiptDecorator {
	
	public HeaderReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return "<br>DCM Computing<br>Thank you for shopping with us!<br>Please do so again.<br><br>";
	}
}
