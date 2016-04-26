import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

class ProductUI extends JFrame
{
 	Product p1 = new Product(1,"CPU",5,100.00,true,false);
 	Product p2 = new Product(2,"RAM",10,50.00,true,false);
  	JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
    JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
    ArrayList<Product> pList = new ArrayList<Product>();
    
    int width = 500;
    int hight = 600;
    int quantity;
    
  	ProductUI(Customer c) 
  	{
  		pList.add(p1);
  		pList.add(p2);
  		String text, item;
  		int index;
  		String name = c.getFirstName();
  		
  		JFrame frame = new JFrame("Products");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(width,hight);
        
        String[] productNames = new String[pList.size()];
		for(int i = 0; i < productNames.length; i++) {
    		productNames[i] = pList.get(i).getProductName();
		}
		
		JComboBox<String> comboBox = new JComboBox<>(productNames);
		JTextField field1 = new JTextField(15);
		
		JPanel panel = new JPanel(new GridLayout(0, 1));
    	panel.add(comboBox);
    	panel.add(new JLabel("Enter quantity"));
    	panel.add(field1);
    	int result = JOptionPane.showConfirmDialog(null, panel, "Purchase Product",
    	JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    	
    	ArrayList<Product> list = new ArrayList<Product>();
        
        if (result == JOptionPane.OK_OPTION) {
        	text = field1.getText();
        	if(text.equals(""))
        		JOptionPane.showMessageDialog(this,"Not enough stock","Error",JOptionPane.ERROR_MESSAGE);
        	else {
        	quantity = Integer.parseInt(text);
        	Product temp;
        	index = comboBox.getSelectedIndex();
        	
        	if(quantity > pList.get(index).getStock()) {
        		JOptionPane.showMessageDialog(this,"Not enough stock","Error",JOptionPane.ERROR_MESSAGE);
        	}
        	
        	
        	else {
        		list.add(pList.get(index));
        		Product[] array = new Product[list.size()];
        		for(int j = 0;j < array.length;j++)
        			array[j] = list.get(j);
        			
        		int[] nums = new int[array.length];
        		String[] names = new String[array.length];
        		double[] prices = new double[array.length];
        		String pName = array[0].getProductName();
        		String quan = Integer.toString(quantity);
        		double total = (quantity*array[0].getUnitCost());
        		String totalString = Double.toString(total);
        		
        		for(int k = 0;k < nums.length;k++)
        		{
        			nums[k] = array[k].getProductId();
        			names[k] = array[k].getProductName();
        			prices[k] = array[k].getUnitCost();
        		}
    
        		JOptionPane.showMessageDialog(null, "Dear " + c.getFirstName() + ",\n\nYour order has been confirmed:\nProduct:\t" + array[0].getProductName() + "\nQuantity:\t" + quantity + 
        		"\n\n\n Total Price:\t\t\t" + quantity * array[0].getUnitCost());
        		ProductUI frame1 =new ProductUI(c);
   				frame1.setSize(300,600);
   				frame1.setVisible(false);
        		
        		Order o1 = new Order(1,c.getFirstName(),20, nums, names, prices);
        	}
        	}
    	} 
    	else {
        System.out.println("Cancelled");
    	}
  	}
  	
}