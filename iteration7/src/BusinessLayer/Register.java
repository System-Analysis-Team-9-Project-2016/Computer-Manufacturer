package BusinessLayer;

import UserInterfaceLayer.LoginUI;
import UserInterfaceLayer.RegisterUI;
import DataLayer.DataControl;
import javax.swing.*;
import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
//Control Class
public class Register
{ 
  	public Register(String firstName, String surname, String address, String email, String pass1, String pass2, String creditCardNumber) { 		
  		System.out.println("[debug] : ****** Entering Register Class ******");
  		
   		 if(pass1.compareTo(pass2) != 0) {
          JOptionPane.showMessageDialog(null,"Passwords do not match","Error",JOptionPane.ERROR_MESSAGE);
          RegisterUI createNewRegisterUI = new RegisterUI();
   		 }

        else if(!isValidEmailAddress(email)) {
          JOptionPane.showMessageDialog(null,"Not a valid email address","Error",JOptionPane.ERROR_MESSAGE);
          RegisterUI createNewRegisterUI = new RegisterUI();
   		 }

        else {
          try {
      		  BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
        	  int nextAvailableId = dataControl.checkNextAvailableId("customerList.txt");
        	  
        	  dataControl.addCustomerToTextFile(nextAvailableId, firstName, surname, address, email, pass1, creditCardNumber);
   
             JOptionPane.showMessageDialog(null, "You have successfully registered. Please log in");
             LoginUI l = new LoginUI();
          }

          catch (IOException e)
        {
            e.printStackTrace();
        }     
        }
  	} 	
 
 	public static boolean isValidEmailAddress(String email) 
 	{
   		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
   } 
}