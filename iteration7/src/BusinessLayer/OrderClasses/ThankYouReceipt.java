package BusinessLayer.OrderClasses;

public class ThankYouReceipt extends ReceiptDecorator {
	
	public ThankYouReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + "<br>Thank you for shopping with us!<br>Please do so again.<br><br>";
	}
}