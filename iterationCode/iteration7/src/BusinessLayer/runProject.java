package BusinessLayer;

import javax.swing.JOptionPane;
import UserInterfaceLayer.LoginUI;

@SuppressWarnings("unused")
public class runProject {

	public static void main(String[] args) {
		
		try {
   			LoginUI frame=new LoginUI();
   		}
   		catch(Exception e) {
   			JOptionPane.showMessageDialog(null, e.getMessage());
   		}
	}

}
