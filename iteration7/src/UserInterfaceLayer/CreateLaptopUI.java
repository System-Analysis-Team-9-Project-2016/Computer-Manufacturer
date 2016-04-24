package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.Color;
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

import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.ProductList;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Product;
import BusinessLayer.ProductClasses.Laptop;
import BusinessLayer.ProductClasses.Component;

@SuppressWarnings("serial")
public class CreatePCUI extends JPanel{
	
	private JList listOfChoices;
	private JList listOfChosenProducts;
	private ArrayList<Product> productsInFile;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelChosen;
	private Desktop currentDesk= new Laptop(1234, "Boaty McBoatFace", 1, 0.0, true, false, "Windows", String OS, true, 17, 4000, 1000);
	private int q = 0;
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel m = new JPanel();
	JPanel p = new JPanel();
	JFrame CreatePCUiFrame = new JFrame("Create PC modal:");
	JLabel currentLabel = new JLabel("Add a component to the list");
	private boolean chooseArrayMade = false;
	private boolean chosenArrayMade = false;
	private boolean backButtonClicked = false;

	public CreatePCUI(Customer currentCustomer) {
		System.out.println("[debug] : ****** Starting CreatePCUI Class  ******");

		// ************************************************************************************************************************
		// ************ 	Start JFrame stuff
		// ************************************************************************************************************************
		
		JFrame CreatePCUiFrame = new JFrame("Create PC modal:");
		CreatePCUiFrame.setBackground(new Color(0,100,200));
		CreatePCUiFrame.setLayout(new BorderLayout(200,200));
		JLabel productsListJLabel = new JLabel("Products");
		CreatePCUiFrame.add(productsListJLabel, BorderLayout.NORTH);
		productsListJLabel.setFont(new Font("Dialog",Font.BOLD,20));
		model = new DefaultListModel<String>();
		modelChosen = new DefaultListModel<String>();

		
		try {
			productsInFile = BusinessLayerDataControl.factoryDesignPatternSearch();
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
				System.out.println("[info]  : ------ Buy button clicked (CreatePCUI Customer) ------");
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
				System.out.println("[info]  : ------ Add button clicked (CreatePCUI Customer) ------");

				
				System.out.println(q);
				String part ="";
				switch(q) {
				case 0 : part = "Motherboard"; break;
				case 1 : part = "CPU"; break;
				case 2 : part = "GPU"; break;
				case 3 : part = "RAM"; break;
				case 4 : part = "MemoryDrives"; break;
				}
				int y =0;
				int u = 0;
				
				int indexOfSelectedComponents = listOfChoices.getSelectedIndex();
				if (indexOfSelectedComponents == -1){
					indexOfSelectedComponents = 0;
				}
				System.out.println(indexOfSelectedComponents);
				
				while (y < productsInFile.size() && u <=indexOfSelectedComponents) {

					System.out.println("y"+y);
					Component someProduct = productsInFile.get(y);
					if(someProduct.getProductName().equals(part)) {
						u++;
					}
					y++;
				}
				currentDesk.addProduct(productsInFile.get(y-1));
				q++;
				populateArrayOfProducts();
			}
		});
		m.add(addBtn);
		populateArrayOfProducts();
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Back button clicked (CreatePCUI Customer) ------");
				if(chosenArrayMade){
					currentDesk.getComponents().remove(currentDesk.getComponents().size() - 1);
					if ( q > 8) {
						m.add(addBtn);
						m.add(listOfChoices);
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
		if (listOfChoices != null ) {
			m.remove(listOfChoices);
			listOfChoices.removeAll();
			chooseArrayMade = false;
			
		}
		if(listOfChosenProducts != null) {
			listOfChosenProducts.removeAll();
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
			case 0 : part = "Motherboard"; break;
			case 1 : part = "CPU"; break;
			case 2 : part = "GPU"; break;
			case 3 : part = "RAM"; break;
			case 4 : part = "MemoryDrives"; break;
			case 5 : part = "Monitor"; break;
			case 6 : part = "Keyboard"; break;
			case 7 : part = "Mouse"; break;
			case 8 : part = "Speaker"; break;
			}
			for(int i = 0; i < productsInFile.size(); i++){
				Product someProduct = productsInFile.get(i);
				if(someProduct.getProductName().equals(part)) {
					model.addElement(someProduct.getProductUIDetails());
				}
				listOfChoices = new JList(model);
			}
			if (model.isEmpty()) {
				if (backButtonClicked == true)
				{
					q--;
					bottomPanel.setVisible(false);;
					
				}
				else {
					if(q > 8) {
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
		if (listOfChoices != null && !chooseArrayMade)
		{
			m.add(listOfChoices);
			chooseArrayMade = true;
		}
		String labelPart ="";
		switch(part) {
		case "Motherboard" : labelPart = "Motherboard"; break;
		case "CPU" : labelPart = "CPU"; break;
		case "GPU" : labelPart = "GPU"; break;
		case "RAM" : labelPart = "RAM"; break;
		case "MemoryDrives" : labelPart = "Memory Drive"; break;
		}
		currentLabel.setText("Please pick a " + labelPart + " for your PC" );
		
		
		int i = 0;
		ArrayList<Product> chosenComps= currentDesk.getComponents(); 
		Iterator<Product> it = chosenComps.iterator();
		while (it.hasNext()){
			i++;
			Product someComp = it.next();
			System.out.println(someComp.getProductName());
			modelChosen.addElement(someComp.getProductUIDetails());
			listOfChosenProducts = new JList(modelChosen);
			
		}
		
		if (listOfChosenProducts != null && !chosenArrayMade){
			p.add(listOfChosenProducts);
			chosenArrayMade = true;
		}
		topPanel.add(currentLabel);
		CreateLaptopUIFrame.add(bottomPanel, BorderLayout.SOUTH);
		CreateLaptopUIFrame.add(topPanel, BorderLayout.NORTH);
		CreateLaptopUIFrame.add(m, BorderLayout.WEST);
		CreateLaptopUIFrame.add(p, BorderLayout.EAST);
		CreateLaptopUiFrame.setSize(800, 500);
		CreateLaptopUiFrame.setVisible(true);
	}
}
