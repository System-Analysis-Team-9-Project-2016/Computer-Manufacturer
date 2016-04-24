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

import BusinessLayer.CreateLaptop;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Product;

@SuppressWarnings("serial")
public class CreateLaptopUI extends JPanel{
	
	private JList listOfChoices;
	private JList listOfChosenProducts;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelChosen;

	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel m = new JPanel();
	JPanel p = new JPanel();
	JFrame CreateLaptopUiFrame = new JFrame("Create Laptop modal:");
	JLabel currentLabel = new JLabel("Add a component to the list");
	private boolean chooseArrayMade = false;
	private boolean chosenArrayMade = false;
	private CreateLaptop viewController;

	public CreateLaptopUI(Customer currentCustomer) throws IOException {
		System.out.println("[debug] : ****** Starting CreateLaptopUI Class  ******");

		// ************************************************************************************************************************
		// ************ 	Start JFrame stuff
		// ************************************************************************************************************************
		
		JFrame CreateLaptopUiFrame = new JFrame("Create Laptop modal:");
		CreateLaptopUiFrame.setBackground(new Color(0,100,200));
		CreateLaptopUiFrame.setLayout(new BorderLayout(200,200));
		JLabel productsListJLabel = new JLabel("Products");
		CreateLaptopUiFrame.add(productsListJLabel, BorderLayout.NORTH);
		productsListJLabel.setFont(new Font("Dialog",Font.BOLD,20));
		model = new DefaultListModel<String>();
		modelChosen = new DefaultListModel<String>();
		viewController = new CreateLaptop(currentCustomer);
		
		
		
		
		JButton addBtn = new JButton("Add");
		JButton backBtn = new JButton("Back");
		JButton buyBtn = new JButton("Buy");
		bottomPanel.setVisible(false);
		bottomPanel.add(buyBtn);
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				viewController.buyButtonClicked();
			}
		});
		
		
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				viewController.addButtonClicked(listOfChoices.getSelectedIndex());
				populateArrayOfProducts();
			}
		});
		m.add(addBtn);
		populateArrayOfProducts();
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("[info]  : ------ Back button clicked (CreateLaptopUI Customer) ------");
				viewController.backBtnClicked();
				if(viewController.chosenArrayMade){
					if ( viewController.indexThroughComponentsToChoose >= 8) {
						m.add(addBtn);
						m.add(listOfChoices);
						currentLabel.setVisible(true);
					}
				}
				populateArrayOfProducts();
				viewController.backButtonClicked = false;
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
			switch(viewController.indexThroughComponentsToChoose) {
			case 0 : part = "Motherboard"; break;
			case 1 : part = "CPU"; break;
			case 2 : part = "GPU"; break;
			case 3 : part = "RAM"; break;
			case 4 : part = "MememoryDrives"; break;
			}
			for(int i = 0; i < viewController.getProductsInFile().size(); i++){
				Product someProduct = viewController.getProductsInFile().get(i);
				if(someProduct.getProductName().equals(part)) {
					model.addElement(someProduct.getProductUIDetails());
				}
				listOfChoices = new JList(model);
			}
			if (model.isEmpty()) {
				if (viewController.backButtonClicked == true)
				{
					viewController.indexThroughComponentsToChoose--;
					bottomPanel.setVisible(false);;
					
				}
				else {
					if(viewController.indexThroughComponentsToChoose > 8) {
						endOfFileReached = true;
						m.removeAll();
						currentLabel.setVisible(false);
						bottomPanel.setVisible(true);
						
					}
					System.out.println(viewController.indexThroughComponentsToChoose);
					viewController.indexThroughComponentsToChoose++;
				}
			}

		}
		if (listOfChoices != null && !chooseArrayMade)
		{
			m.add(listOfChoices);
			chooseArrayMade = true;
		}
		String labelPart = viewController.getlabel(part);
		currentLabel.setText("Please pick a " + labelPart + " for your Laptop" );
		
		
		ArrayList<Product> chosenComps= viewController.getListOfComponents(); 
		Iterator<Product> it = chosenComps.iterator();
		while (it.hasNext()){
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
		CreateLaptopUiFrame.add(bottomPanel, BorderLayout.SOUTH);
		CreateLaptopUiFrame.add(topPanel, BorderLayout.NORTH);
		CreateLaptopUiFrame.add(m, BorderLayout.WEST);
		CreateLaptopUiFrame.add(p, BorderLayout.EAST);
		CreateLaptopUiFrame.setSize(800, 500);
		CreateLaptopUiFrame.setVisible(true);
	}
}
