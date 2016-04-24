package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import BusinessLayer.CustomerClasses.Customer;
import BusinessLayer.ProductClasses.Component;
import BusinessLayer.ProductClasses.Laptop;
import BusinessLayer.ProductClasses.Product;


public class CreateLaptop {
	
	private ArrayList<Product> productsInFile;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelChosen;
	private Laptop currentLaptop= new Laptop(1234, "Boaty McBoatFace", 1, 0.0, true, false, "Windows", true, 17, 4000, 1000);
	private Customer currentCustomer;
	public int indexThroughComponentsToChoose = 0;
	private boolean chooseArrayMade = false;
	public boolean chosenArrayMade = false;
	public boolean backButtonClicked = false;
	
	

	public CreateLaptop(Customer c) throws IOException{
		currentCustomer = c;
		ArrayList<Product> productsInFile;
		DefaultListModel<String> model;
		DefaultListModel<String> modelChosen;
		int indexThroughComponentsToChoose = 0;
		boolean chooseArrayMade = false;
		boolean chosenArrayMade = false;
		boolean backButtonClicked = false;

	}
	
	public ArrayList<Product> getProductsInFile() {
		try {
			productsInFile = BusinessLayerDataControl.factoryDesignPatternSearch();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsInFile;
		
	}

	public void buyButtonClicked() {
		System.out.println("[info]  : ------ Buy button clicked (CreateLaptopUI Customer) ------");
		try {
			ProductList createNewProductList = new ProductList(currentLaptop.getComponents(), currentCustomer);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addButtonClicked(int indexOfSelectedComponents) {
		System.out.println("[info]  : ------ Add button clicked (CreateLaptopUI Customer) ------");
		chosenArrayMade = true;
		
		System.out.println(indexThroughComponentsToChoose);
		String part ="";
		switch(indexThroughComponentsToChoose) {
		case 0 : part = "Motherboard"; break;
		case 1 : part = "CPU"; break;
		case 2 : part = "GPU"; break;
		case 3 : part = "RAM"; break;
		case 4 : part = "MemoryDrives"; break;
		}
		int y =0;
		int u = 0;
		
		if (indexOfSelectedComponents == -1){
			indexOfSelectedComponents = 0;
		}
		System.out.println(indexOfSelectedComponents);
		
		while (y < getProductsInFile().size() && u <=indexOfSelectedComponents) {

			System.out.println("y"+y);
			Component someProduct = getProductsInFile().get(y);
			if(someProduct.getProductName().equals(part)) {
				u++;
			}
			y++;
		}
		currentLaptop.addProduct(productsInFile.get(y-1));
		indexThroughComponentsToChoose++;
		
	}

	public void backBtnClicked() {
		if(chosenArrayMade){
			currentLaptop.getComponents().remove(currentLaptop.getComponents().size() - 1);
			indexThroughComponentsToChoose--;
			System.out.println("BACK " +indexThroughComponentsToChoose );
			backButtonClicked = true;
		}
		
	}

	public ArrayList<Product> getListOfComponents() {
		
		return currentLaptop.getComponents();
	}
	
	public String getlabel(String part) {
		String labelPart = "";
		switch(part) {
		case "Motherboard" : labelPart = "Motherboard"; break;
		case "CPU" : labelPart = "CPU"; break;
		case "GPU" : labelPart = "GPU"; break;
		case "RAM" : labelPart = "RAM"; break;
		case "MemoryDrives" : labelPart = "Memory Drive"; break;
		case "Monitor" : labelPart = "Monitor"; break;
		case "Keyboard" : labelPart = "Keyboard"; break;
		case "Mouse" : labelPart = "Mouse"; break;
		case "Spreaker" : labelPart = "Speaker System"; break;
	}
		return labelPart;
	
	}
}
