package BusinessLayer.OrderClasses;

public class ShippingReceipt extends ReceiptDecorator {

	public ShippingReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + "<br><br>Added shipping cost of \u20ac5.00";
	}
}