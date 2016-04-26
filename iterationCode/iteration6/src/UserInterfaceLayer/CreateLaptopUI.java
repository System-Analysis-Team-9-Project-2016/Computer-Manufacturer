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

import BusinessLayer.ProductList;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.OrderClasses.Order;
import BusinessLayer.ProductClasses.Product;
import BusinessLayer.ProductClasses.Desktop;
import BusinessLayer.ProductClasses.Component;
import DataLayer.DataControl;

@SuppressWarnings("serial")
public class CreateLaptopUI extends JPanel{
	
	private JList choices;
	private JList chosen;
	private ArrayList<Product> productsInFile;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelChosen;
	private Desktop currentDesk= new Desktop(1234, "Boaty McBoatFace", 1, 0.0, true, false, "Windows", true);
	private int q = 0;
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel m = new JPanel();
	JPanel p = new JPanel();
	JFrame CreateLaptopUiFrame = new JFrame("Create laptop modal:");
	JLabel currentLabel = new JLabel("Add a component to the list");
	private boolean chooseArrayMade = false;
	private boolean chosenArrayMade = false;
	private boolean backButtonClicked = false;

	public CreateLaptopUI(Customer currentCustomer) {
		System.out.println("[debug] : ****** Starting CreateLaptopUI Class  ******");

		// ************************************************************************************************************************
		// ************ 	Start JFrame stuff
		// ************************************************************************************************************************
		
		JFrame CreateLaptopUiFrame = new JFrame("Create laptop modal:");
		CreateLaptopUiFrame.setBackground(new Color(0,100,200));
		CreateLaptopUiFrame.setLayout(new BorderLayout(200,200));
		JLabel productsListJLabel = new JLabel("Products");
		CreateLaptopUiFrame.add(productsListJLabel, BorderLayout.NORTH);
		productsListJLabel.setFont(new Font("Dialog",Font.BOLD,20));
		model = new DefaultListModel<String>();
		modelChosen = new DefaultListModel<String>();

		
		try {
			productsInFile = DataControl.getAllProductsFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		JButton addBtn = new JButton("Add");
		JButton backBtn = new JButton("Back");
		JButton buyBtn = new JButton("Buy");
		bottomPanel.setVisible(false);
		bottomPanel.add(buyBtn);
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Buy button clicked (CreateLaptopUI Customer) ------");
				try {
					ProductList createNewProductList = new ProductList(currentDesk.getComponents(), currentCustomer);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Add button clicked (CreateLaptopUI Customer) ------");

				int indexOfSelectedComponents = choices.getSelectedIndex();
				System.out.println(indexOfSelectedComponents);
				if (indexOfSelectedComponents == -1){
					indexOfSelectedComponents = 0;
				}
				System.out.println(q);
				String part ="";
				switch(q) {
				case 0 : part = "MOT"; break;
				case 1 : part = "CPU"; break;
				case 2 : part = "GPU"; break;
				case 3 : part = "RAM"; break;
				case 4 : part = "MEM"; break;
				}
				int y =0;
				int u = 0;

				while (y < productsInFile.size() && u <=indexOfSelectedComponents) {

					System.out.println("**************");
					Component someProduct = productsInFile.get(y);
					if(someProduct.getProductName().substring(0, Math.min(someProduct.getProductName().length(), 3)).equals(part)) {
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
		populateArrayOfProducts();
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Back button clicked (CreateLaptopUI Customer) ------");
				if(chosenArrayMade){
					currentDesk.getComponents().remove(currentDesk.getComponents().size() - 1);
					if ( q >= 4) {
						m.add(addBtn);
						m.add(choices);
						currentLabel.setVisible(true);
					}
					q--;
					System.out.println("BACK " +q );
					backButtonClicked = true;
					populateArrayOfProducts();
					backButtonClicked = false;
				}
			}
		});
		
		p.add(backBtn);
		
		
		

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
		boolean endOfFileReached = false;
		while (model.isEmpty() && !endOfFileReached)
		{
			switch(q) {
			case 0 : part = "MOT"; break;
			case 1 : part = "CPU"; break;
			case 2 : part = "GPU"; break;
			case 3 : part = "RAM"; break;
			case 4 : part = "MEM"; break;
			}
			for(int i = 0; i < productsInFile.size(); i++){
				Product someProduct = productsInFile.get(i);
				if(someProduct.getProductName().equals(part)) {
					model.addElement(someProduct.getProductUIDetails());
				}
				choices = new JList(model);
			}
			if (model.isEmpty()) {
				if (backButtonClicked == true)
				{
					q--;
					bottomPanel.setVisible(false);;
					
				}
				else {
					if(q > 5) {
						endOfFileReached = true;
						m.removeAll();
						currentLabel.setVisible(false);
						bottomPanel.setVisible(true);
						
					}
					System.out.println(q);
					q++;
				}
			}

		}
		if (choices != null && !chooseArrayMade)
		{
			m.add(choices);
			chooseArrayMade = true;
		}
		String labelPart ="";
		switch(part) {
		case "MOT" : labelPart = "Motherboard"; break;
		case "CPU" : labelPart = "CPU"; break;
		case "GPU" : labelPart = "GPU"; break;
		case "RAM" : labelPart = "RAM"; break;
		case "MEM" : labelPart = "Memory Drive"; break;
		}
		currentLabel.setText("Please pick a " + labelPart + " for your Laptop" );
		
		
		int i = 0;
		ArrayList<Product> chosenComps= currentDesk.getComponents(); 
		Iterator<Product> it = chosenComps.iterator();
		while (it.hasNext()){
			i++;
			Product someComp = it.next();
			System.out.println(someComp.getProductName());
			modelChosen.addElement(someComp.getProductUIDetails());
			chosen = new JList(modelChosen);
			
		}
		
		if (chosen != null && !chosenArrayMade){
			p.add(chosen);
			chosenArrayMade = true;
		}
		topPanel.add(currentLabel);
		CreateLaptopUiFrame.add(bottomPanel, BorderLayout.SOUTH);
		CreateLaptopUiFrame.add(topPanel, BorderLayout.NORTH);
		CreateLaptopUiFrame.add(m, BorderLayout.WEST);
		CreateLaptopUiFrame.add(p, BorderLayout.EAST);
		CreateLaptopUiFrame.setSize(800, 500);
		CreateLaptopUiFrame.setVisible(true);
	}
}