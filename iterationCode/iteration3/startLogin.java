import javax.swing.*;
class startLogin
{
	public static void main(String arg[])
   	{
   		try
   		{
   			LoginUI frame=new LoginUI();
   		}
   		catch(Exception e)
   		{
   			JOptionPane.showMessageDialog(null, e.getMessage());
   		}
   	}
}