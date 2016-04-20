package BusinessLayer;
import java.io.*;

import BusinessLayer.CustomerClasses.Customer;
import UserInterfaceLayer.CreatePCUI;


public class CreatePC {
	public CreatePC (Customer customer) throws IOException {
		@SuppressWarnings("unused")
		CreatePCUI createPCUI = new CreatePCUI(customer);

	}
}