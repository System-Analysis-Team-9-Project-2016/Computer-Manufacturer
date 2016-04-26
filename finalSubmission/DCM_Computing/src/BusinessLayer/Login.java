package BusinessLayer;

import UserInterfaceLayer.*;
import DataLayer.DataControl;
import javax.swing.*;

import BusinessLayer.CustomerClasses.Admin;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Product;

import java.io.*;
import java.util.ArrayList;

// Control Class
public class Login {

	public Login(String email, String password) throws IOException {
		System.out.println("[debug] : ****** Entering Login Class ******");

		BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
	    String [] customerDetails = dataControl.checkCustomerLogIn(email, password);
	    String [] adminDetails = dataControl.checkAdminLogIn(email, password);
	   
	    if (!(customerDetails[6].equalsIgnoreCase("fail"))) {
	    	// Customer(int id, String firstName, String surname, String email, String password, String creditCardNumber)
	        Customer customer = new Customer(Integer.parseInt(customerDetails[0]),customerDetails[1],customerDetails[2],customerDetails[3],customerDetails[4], customerDetails[5], customerDetails[6]);
	        @SuppressWarnings("unused")
	        
	        ArrayList<Product> productsInFile = dataControl.factoryDesignPatternSearch();
	        
			ProductListUI frame = new ProductListUI(customer, productsInFile);
	    }
	    else if (!(adminDetails[4].equalsIgnoreCase("fail"))) {
	    	// Admin(int adminID , String firstName, String surname, String email , String password )
	        Admin admin = new Admin(Integer.parseInt(adminDetails[0]),adminDetails[1],adminDetails[2],adminDetails[3],adminDetails[4]);
	        @SuppressWarnings("unused")
			ProductListUI frame = new ProductListUI(admin);
	    }
	    else
	    	JOptionPane.showMessageDialog(null,"User not found", "Error",JOptionPane.ERROR_MESSAGE);
	    }
}