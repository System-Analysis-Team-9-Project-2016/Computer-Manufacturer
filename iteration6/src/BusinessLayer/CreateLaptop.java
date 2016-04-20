package BusinessLayer;
import java.io.*;

import BusinessLayer.CustomerClasses.Customer;
import UserInterfaceLayer.CreateLaptopUI;


public class CreateLaptop {
	public CreateLaptop (Customer customer) throws IOException {
		@SuppressWarnings("unused")
		CreateLaptopUI createLaptopUI = new CreateLaptopUI(customer);

	}
}