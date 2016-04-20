package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import BusinessLayer.ProductClasses.Desktop;
import BusinessLayer.ProductClasses.Component;
import DataLayer.DataControl;

@SuppressWarnings("serial")
public class CreatePCUI extends JPanel{
	
	private JList choices;
	private JList chosen;
	private ArrayList<Product> productsInFile;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelChosen;
	private Desktop currentDesk= new Desktop(1234, "Boaty McBoatFace", 1, 0.0, true, false, "Windows", true);
	private int q = 0;
	JPanel m = new JPanel();
	JPanel p = new JPanel();
	JFrame CreatePCUiFrame = new JFrame("Create PC modal:");
	private boolean chooseArrayMade = false;
	private boolean chosenArrayMade = false;

	public CreatePCUI(Customer currentCustomer) {
		System.out.println("[debug] : ****** Starting CreatePCUI Class  ******");

		// ************************************************************************************************************************
		// ************ 	Start JFrame stuff
		// ************************************************************************************************************************
		
		JFrame CreatePCUiFrame = new JFrame("Create PC modal:");
		CreatePCUiFrame.setBackground(new Color(0,100,200));
		CreatePCUiFrame.setLayout(new BorderLayout(5,5));
		JLabel productsListJLabel = new JLabel("Products");
		CreatePCUiFrame.add(productsListJLabel, BorderLayout.NORTH);
		productsListJLabel.setFont(new Font("Dialog",Font.BOLD,20));
		model = new DefaultListModel<String>();
		modelChosen = new DefaultListModel<String>();

		
		try {
			productsInFile = DataControl.getAllProductsFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		populateArrayOfProducts();
		
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Add button clicked (CreatePCUI Customer) ------");
		    	
		    	int indexOfSelectedComponents = choices.getSelectedIndex();
		    	System.out.println(indexOfSelectedComponents);
		    	if (indexOfSelectedComponents == -1){
		    		indexOfSelectedComponents = 0;
		    	}
		    	String part ="";
				switch(q) {
				case 0 : part = "CPU"; break;
				case 1 : part = "RAM"; break;
				case 2 : part = "GPU"; break;
				case 3 : part = "MON"; break;
				}
				int y =0;
				int u = 0;
		    	while (y < productsInFile.size() && u <=indexOfSelectedComponents) {

		    		System.out.println("**************");
		    		Product someProduct = productsInFile.get(y);
		    		if(someProduct.getProductName().equals(part)) {
						  u++;
		    		}
		    		y++;
		    		
		    	}
		    	currentDesk.addProduct(productsInFile.get(y+u-2));
		    	q++;
		    	populateArrayOfProducts();
		    }
		});
		m.add(addBtn);
		
		

	}
	public void populateArrayOfProducts() {
		if (choices != null ) {
			choices.removeAll();
		}
		if(chosen != null) {
			chosen.removeAll();
		}
		if (modelChosen != null) {
			modelChosen.removeAllElements();
		}
		if (model != null) {
			model.removeAllElements();
		}
		String part ="";
		switch(q) {
		case 0 : part = "CPU"; break;
		case 1 : part = "RAM"; break;
		case 2 : part = "GPU"; break;
		case 3 : part = "MON"; break;
		}
		for(int i = 0; i < productsInFile.size(); i++){
			   Product someProduct = productsInFile.get(i);
			   if(someProduct.getProductName().equals(part)) {
				   model.addElement(someProduct.getProductUIDetails());
			   }
			   choices = new JList(model);
		}
		if (choices != null && !chooseArrayMade)
		{
			m.add(choices);
			chooseArrayMade = true;
		}
		int i = 0;
		ArrayList<Component> chosenComps= currentDesk.getComponents(); 
		Iterator<Component> it = chosenComps.iterator();
		System.out.println("Hi");
		while (it.hasNext()){
			System.out.println("Hello");
			i++;
			System.out.println("Here!!!!");
			Component someComp = it.next();
			System.out.println(someComp.getProductName());
			modelChosen.addElement(someComp.getProductName());
			chosen = new JList(modelChosen);
			
		}
		
		
		System.out.println("Made it to chosen");
		if (chosen != null && !chosenArrayMade){
			p.add(chosen);
			chosenArrayMade = true;
		}
		
		CreatePCUiFrame.add(m, BorderLayout.WEST);
		CreatePCUiFrame.add(p, BorderLayout.EAST);
		CreatePCUiFrame.setSize(400, 500);
		CreatePCUiFrame.setVisible(true);
	}
}