package BusinessLayer.OrderClasses;

public class ShippingReceipt extends ReceiptDecorator {

	public ShippingReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return "<br><br>Shipping cost total of \u20ac5.00 included.<br>";
	}
}
