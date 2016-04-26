package UserInterfaceLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class OrderSummaryUI extends JFrame {

	public OrderSummaryUI(String postOrderDetails) {
System.out.println("[debug] : ****** Starting OrderSummaryUI Class ******");

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
   		
		JLabel orderOuputLabel = new JLabel("<html>" + postOrderDetails + "</html>");
		
		JScrollPane scroller = new JScrollPane(orderOuputLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   		
   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.add(exitButton);

   		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Thank you for shopping with us"));
        gui.add(controls, BorderLayout.SOUTH);
        gui.add(scroller, BorderLayout.CENTER);

        cartUiFrame.setContentPane(gui);
        cartUiFrame.pack();
        cartUiFrame.setLocationByPlatform(true);
        cartUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cartUiFrame.setSize(400, 400);
		//cartUiFrame.setResizable(true);
		cartUiFrame.setLocationRelativeTo(null);
        cartUiFrame.setVisible(true);
	}	
}