package UserInterfaceLayer;

import BusinessLayer.*;
import DataLayer.DataControl;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class ProductListUI extends JFrame {
/*
	public ProductListUI(Customer customer) throws IOException {
		System.out.println("[debug] : ****** Entering ProductListUI Class as Customer ******");
		
		// Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount)
		Product product1 = new Product(1, "CPU", 30, 99.99, true, false);
		Product product2 = new Product(2, "Graphics Card", 40, 79.99, true, false);
		Product product3 = new Product(3, "RAM", 25, 54.95, true, false);
		
		// Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts)
		ArrayList<Product> orderProducts = new ArrayList<Product>(); 
		orderProducts.add(product1);
		orderProducts.add(product2);
		orderProducts.add(product3);
		Order order1 = new Order(10, 1, "Conor Duggan", 123, orderProducts);
		
		//EditOrderDetailsUI editDetails1 = new EditOrderDetailsUI(order1, customer);
		//CartUI createNewCartUI = new CartUI(order1, customer);
		
		
		
		JFrame ProductListUiFrame = new JFrame("Product List");
		
		JLabel orderCreatedLabel = new JLabel();
		orderCreatedLabel.setText("An order has been temporarily created for you");
   		
		JButton checkoutButton = new JButton("Check Out");
		checkoutButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Check Out button clicked (ProductListUI Customer) ------");

		    	ProductListUiFrame.setVisible(false);
		    	ProductListUiFrame.dispose();
		        EditOrderDetailsUI editDetails1 = new EditOrderDetailsUI(order1, customer);
		    }
		});
   		
   		JButton quitButton = new JButton("Quit");
   		quitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Quit button clicked (ProductListUI Customer) ------");
		    	ProductListUiFrame.setVisible(false);
		    	ProductListUiFrame.dispose();
		    	System.exit(0);
		    }
		});

   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.setBorder(new TitledBorder("You are logged in as a Customer user"));
   		controls.add(orderCreatedLabel);
   		controls.add(checkoutButton);
      	controls.add(quitButton);
      	
      	ProductListUiFrame.setContentPane(controls);
      	ProductListUiFrame.pack();
      	ProductListUiFrame.setLocationByPlatform(true);
      	ProductListUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	ProductListUiFrame.setSize(800, 600);
      	ProductListUiFrame.setResizable(false);
      	ProductListUiFrame.setLocationRelativeTo(null);
      	ProductListUiFrame.setVisible(true);
	}*/
	
// ************************************************************************************************************************
// ************ 	Admin ProductListUI
// ************************************************************************************************************************

	
	public ProductListUI(Admin admin) throws IOException {
		System.out.println("[debug] : ****** Entering ProductListUI Class as Admin ******");
		/*
		// Product(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount)
		Product product1 = new Product(1, "CPU", 30, 99.99, true, false);
		Product product2 = new Product(2, "Graphics Card", 40, 79.99, true, false);
		Product product3 = new Product(3, "RAM", 25, 54.95, true, false);
		
		// Order(int orderId, int customerId, String customerName, int shippingId, ArrayList<Product> orderProducts)
		ArrayList<Product> orderProducts = new ArrayList<Product>(); 
		orderProducts.add(product1);
		orderProducts.add(product2);
		orderProducts.add(product3);
		Order order1 = new Order(10, 1, "Conor Duggan", 123, orderProducts);
		
		 
		Admin a = new Admin(5 , "Darren", "Stack" , "dstack@ul.ie" , "stack");
		*/
		JFrame ProductListUiFrame = new JFrame("Product List");
		
		JButton addNewProductButton = new JButton("Add New Product");
		addNewProductButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Add New Product button clicked (ProductListUI Admin) ------");

		    	ProductListUiFrame.setVisible(false);
		    	ProductListUiFrame.dispose();
		        try {
		        	AddNewProductUI add = new AddNewProductUI(admin);
		    		add.display();
				} 
		        catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
   		
   		JButton quitButton = new JButton("Quit");
   		quitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Quit button clicked (ProductListUI Admin) ------");
		    	ProductListUiFrame.setVisible(false);
		    	ProductListUiFrame.dispose();
		    	System.exit(0);
		    }
		});

   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.setBorder(new TitledBorder("You are logged in as an Admin user"));
   		controls.add(addNewProductButton);
      	controls.add(quitButton);
      	
      	ProductListUiFrame.setContentPane(controls);
      	ProductListUiFrame.pack();
      	ProductListUiFrame.setLocationByPlatform(true);
      	ProductListUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	ProductListUiFrame.setSize(800, 600);
      	ProductListUiFrame.setResizable(false);
      	ProductListUiFrame.setLocationRelativeTo(null);
      	ProductListUiFrame.setVisible(true);
	}
	
	
	
// ************************************************************************************************************************
// ************ 	Customer ProductListUI
// ************************************************************************************************************************

	
	private JList choices;
	private ArrayList<Product> productsInFile;
	private ArrayList<Product> productsAddedToCart;
	private DefaultListModel<String> model;
	
	public ProductListUI(Customer customer) throws IOException {
		super("Products");
		
		System.out.println("[debug] : ****** Entering ProductListUI Class as Customer ******");
		
		Container pane = getContentPane();
		pane.setBackground(new Color(0,100,200));
		pane.setLayout(new BorderLayout(5,5));
		JLabel productsListJLabel = new JLabel("Products");
		pane.add(productsListJLabel, BorderLayout.NORTH);
		productsListJLabel.setFont(new Font("Dialog",Font.BOLD,20));
		JPanel m = new JPanel();
		model = new DefaultListModel<String>();
		
		productsInFile = DataControl.getAllProductsFromFile();
		for(int i = 0; i < productsInFile.size(); i++){
			   Product someProduct = productsInFile.get(i);
			   model.addElement(someProduct.getProductUIDetails());
			   choices = new JList(model);
		}
		
		m.add(choices);
		pane.add(m, BorderLayout.WEST);
		m.setFont(new Font("Courier",Font.BOLD,14));
		
		JButton buyB = new JButton("Buy");
		buyB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Buy button clicked (ProductListUI Customer) ------");

		    	try {
					displayList();
				} 
		    	catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		m.add(buyB);
		
		JPanel p = new JPanel();
		
		JButton cartB = new JButton("Check Out");
		cartB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Check Out button clicked (ProductListUI Customer) ------");
		    	
		    	int selected = choices.getSelectedIndex();
				
				try {
					productsAddedToCart = new ArrayList<Product>(DataControl.getAllProductsFromFile());
					Product p = productsAddedToCart.get(selected);
					DefaultListModel<String> model2 = new DefaultListModel<String>();
					ArrayList<Product> boughtbought = new ArrayList<Product>();
					boughtbought.add(p);
					
					ProductList createNewProductList = new ProductList(boughtbought, customer);
				} 
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		JButton logOutB = new JButton("Log Out");
		logOutB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Log Out button clicked (ProductListUI Customer) ------");

		    	System.exit(0);
		    }
		});
		
		p.add(cartB);
		p.add(logOutB);
		add(p, BorderLayout.CENTER);
		
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void displayList() throws IOException
	{
		int selected = choices.getSelectedIndex();
		
		productsAddedToCart = new ArrayList<Product>(DataControl.getAllProductsFromFile());
		Product p = productsAddedToCart.get(selected);
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		ArrayList<Product> boughtbought = new ArrayList<Product>();
		boughtbought.add(p);
		for(int i = 0; i < boughtbought.size(); i++)
		{
			System.out.println(boughtbought.get(i).getProductDetails());
		}
	}
}
