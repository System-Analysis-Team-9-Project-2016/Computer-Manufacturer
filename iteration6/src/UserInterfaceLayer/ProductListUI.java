package UserInterfaceLayer;

import BusinessLayer.*;
import BusinessLayer.CustomerClasses.Admin;
import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.io.*;

@SuppressWarnings({ "serial" })
public class ProductListUI extends JFrame {
	public final static ArrayList<Product> boughtbought = new ArrayList<Product>();
	
// ************************************************************************************************************************
// ************ 	Admin ProductListUI
// ************************************************************************************************************************

	
	public ProductListUI(final Admin admin) throws IOException {
		System.out.println("[debug] : ****** Entering ProductListUI Class as Admin ******");
		
		final JFrame ProductListUiFrame = new JFrame("Product List");
		
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
   		
		JButton addNewProductDiscount = new JButton("Add New Product Discount");
		addNewProductDiscount.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Add New Product Discount button clicked (ProductListUI Admin) ------");

		    	ProductListUiFrame.setVisible(false);
		    	ProductListUiFrame.dispose();
		        try {
		        	ApplyDiscountUI add = new ApplyDiscountUI(admin);
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
   		JButton addNewGroupDiscount = new JButton("Add New Group Discount");
   		addNewGroupDiscount.addActionListener(new ActionListener() {
   		    @Override
   		    public void actionPerformed(ActionEvent evt) {
   		    	System.out.println("[info]  : ------ Add New Group Discount button clicked (ProductListUI Admin) ------");

   		    	ProductListUiFrame.setVisible(false);
   		    	ProductListUiFrame.dispose();
   		        try {
   		        	AddNewGroupDiscountUI add = new AddNewGroupDiscountUI(admin);
   		    		add.display();
   				} 
   		        catch (IOException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   					}
   		    	}
   			});

   		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
   		controls.setBorder(new TitledBorder("You are logged in as an Admin user"));
   		controls.add(addNewGroupDiscount);
   		controls.add(addNewProductDiscount);
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
	
	public ProductListUI(final Customer customer) throws IOException {
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
		
		JButton createPcB = new JButton("Create Desktop");
		createPcB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Create PC button clicked (ProductListUI Customer) ------");
		    	
		    	// Create PC code called.
				try {
					CreatePC createPC = new CreatePC(customer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		m.add(createPcB);
		
		JButton createLaptopB = new JButton("Create Laptop");
		createLaptopB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Create PC button clicked (ProductListUI Customer) ------");
		    	// Create Laptop code called.
				try {
					CreateLaptop createLaptop = new CreateLaptop(customer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		m.add(createLaptopB);
		
		JButton createComment = new JButton("Add Comment");
		createComment.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Add Comment button clicked (ProductListUI Customer) ------");
				try {
					AddNewCommentUI addComment = new AddNewCommentUI(customer);
					addComment.display();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		m.add(createComment);
		
		JButton getComments = new JButton("Look at Comments");
		getComments.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Get Comments button clicked (ProductListUI Customer) ------");
				try {
					GetCommentsUI getComment = new GetCommentsUI();
					int selected = choices.getSelectedIndex();
					productsAddedToCart = new ArrayList<Product>(DataControl.getAllProductsFromFile());
					Product p = productsAddedToCart.get(selected);
					getComment.display(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		m.add(getComments);
		
		JPanel p = new JPanel();
		
		JButton cartB = new JButton("Check Out");
		cartB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println("[info]  : ------ Check Out button clicked (ProductListUI Customer) ------");
				
				try {
					ProductList createNewProductList = new ProductList(boughtbought, customer);
				} 
				catch (IOException e) {
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
	
	private void displayList() throws IOException {
		
		int selected = choices.getSelectedIndex();
		
		productsAddedToCart = new ArrayList<Product>(DataControl.getAllProductsFromFile());
		Product p = productsAddedToCart.get(selected);
		boughtbought.add(p);
		for(int i = 0; i < boughtbought.size(); i++)
			System.out.println(boughtbought.get(i).getProductDetails());
	}
}






