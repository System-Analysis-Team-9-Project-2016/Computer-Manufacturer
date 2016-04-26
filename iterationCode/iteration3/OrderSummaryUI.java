import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.awt.Dimension;

public class OrderSummaryUI extends JFrame {

	OrderSummaryUI(String postOrderDetails, Customer currentCustomer) {
System.out.println("[debug] : ****** Starting OrderSummaryUI Object Creation ******");

// ************************************************************************************************************************
// ************ 	Start JFrame stuff
// ************************************************************************************************************************

		JFrame cartUiFrame = new JFrame("Order Summary");

		JButton exitButton = new JButton("Exit");
   		exitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Exit button clicked (OrderSummaryUI) ------");
		    	System.exit(0);
		    }
		});
/*
   		JButton goToProductListButton = new JButton("Go to product list");
   		goToProductListButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Go to product list button clicked (OrderSummaryUI) ------");
		    	cartUiFrame.setVisible(false);
		    	cartUiFrame.dispose();
		    	//ProductList createNewProductList = new ProductList(currentCustomer);
		    }
		});
*/
		JLabel orderOuputLabel = new JLabel("<html>" + postOrderDetails + "</html>");
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(exitButton);
      	//controls.add(goToProductListButton);

   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Thank you for shopping with us"));
        gui.add(controls, BorderLayout.SOUTH);
        gui.add(orderOuputLabel, BorderLayout.CENTER);

        cartUiFrame.setContentPane(gui);
        cartUiFrame.pack();
        cartUiFrame.setLocationByPlatform(true);
        cartUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartUiFrame.setSize(400, 400);
		cartUiFrame.setResizable(false);
		cartUiFrame.setLocationRelativeTo(null);
        cartUiFrame.setVisible(true);
	}	
}
