import javax.swing.*;
import java.util.*;
import java.io.*;
  
class Login
{

  Login(String email, String password)
  {
    String e = email;
    String p = password;
      BufferedReader br = null;
      try {
        br = new BufferedReader(new FileReader("Customers.txt"));
            String sCurrentLine;
            boolean found = false;

            try {
            while ((sCurrentLine = br.readLine()) != null && !found) {
              
                String[] information = sCurrentLine.split(",");
                String user = information[2];
                String pass = information[3];
                if(email.equals(user) && password.equals(pass)) {
                      Customer c = new Customer(information[0],information[1],information[2],information[3],information[4]);
                      ProductUI frame=new ProductUI(c);
                      frame.setSize(300,600);
                      frame.setVisible(false);
                      found = true;
                }
              }
                if(!found) {
                    JOptionPane.showMessageDialog(null,"User not found", "Error",JOptionPane.ERROR_MESSAGE);
                }
                                
            
          }
          catch(IOException ex)
          {
              JOptionPane.showMessageDialog(null, "Error");
          }
      }
      
      catch (FileNotFoundException qwerty) {
          JOptionPane.showMessageDialog(null, "Can't find a text file");
      }
    }
}