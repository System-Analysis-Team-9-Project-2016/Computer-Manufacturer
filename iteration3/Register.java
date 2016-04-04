import javax.swing.*;
import java.util.*;
import java.io.*;

class Register
{ 
  	Register(String firstName, String surname, String email, String pass1, String pass2, String creditCard)
  	{ 		
   		 if(pass1.compareTo(pass2) != 0)
          JOptionPane.showMessageDialog(null,"Passwords do not match","Error",JOptionPane.ERROR_MESSAGE);

        else if(!isValidEmailAddress(email))
          JOptionPane.showMessageDialog(null,"Not a valid email address","Error",JOptionPane.ERROR_MESSAGE);

        else {
          try {
            Customer c = new Customer(firstName,surname,email,pass1,creditCard);

              File log = new File("Customers.txt");
              PrintWriter writer = new PrintWriter(new FileWriter(log, true));
              writer.println(c.getFirstName() + "," + c.getSurname() + "," + c.getEmail() + "," + c.getPassword() + "," + c.getCreditCardNumber());
              writer.close();
   
             System.out.print(c.getFirstName() + "\n" + c.getSurname() + "\n" + c.getEmail() + "\n" + c.getPassword() + "\n" + c.getCreditCardNumber());
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