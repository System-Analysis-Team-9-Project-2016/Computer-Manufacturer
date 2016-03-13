import javax.swing.*;
class startLogin
{
	public static void main(String arg[])
   	{
   		try
   		{
   			Login frame=new Login();
   		}
   		catch(Exception e)
   		{
   			JOptionPane.showMessageDialog(null, e.getMessage());
   		}
   	}
}