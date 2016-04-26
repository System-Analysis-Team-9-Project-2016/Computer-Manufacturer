package UserInterfaceLayer;

import BusinessLayer.*;
import BusinessLayer.CustomerClasses.Admin;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.io.*;

@SuppressWarnings({ "serial" })
public class ApplyDiscountUI extends JFrame{

	private JList choices;
	private ArrayList<Product> productsInFile;
	private ArrayList<Product> productsAddedToCart;
	private DefaultListModel<String> model;

	public ApplyDiscountUI(final Admin admin) throws FileNotFoundException{
		JButton SUBMIT , REMOVE;
		JPanel panel;
		JLabel label0 , label1;
		final JTextField  text1;

		JPanel inputControls;

		JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
		JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));

		inputControls = new JPanel(new BorderLayout(5,5));
		inputControls.add(labelPanel, BorderLayout.WEST);
		inputControls.add(fieldPanel, BorderLayout.CENTER);

		final JFrame averageFrame = new JFrame("Discount Page");

		label1 = new JLabel();
		label1.setText("Please enter your discount (%)");
		text1 = new JTextField(15);

		labelPanel.add(label1);
		fieldPanel.add(text1);

		BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
		productsInFile = dataControl.factoryDesignPatternSearch();

		JPanel m = new JPanel();
		model = new DefaultListModel<String>();


		for(int i = 0; i < productsInFile.size(); i++){
			Product someProduct = productsInFile.get(i);
			model.addElement(someProduct.getProductUIDetails());
			choices = new JList(model);
		}

		SUBMIT=new JButton("Submit");

		SUBMIT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				double discount = Double.parseDouble(text1.getText());
				ApplyDiscount edit;
				try {
					Product p = productsInFile.get(choices.getSelectedIndex());
					edit = new ApplyDiscount(p);
					edit.applyDiscount(p, discount);
					averageFrame.setVisible(false);
					ProductListUI frame = new ProductListUI(admin);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		SUBMIT.setActionCommand("1");
		
		REMOVE=new JButton("Remove");

		REMOVE.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ApplyDiscount edit;
				try {
					Product p = productsInFile.get(choices.getSelectedIndex());
					edit = new ApplyDiscount(p);
					edit.removeDiscount(p);
					averageFrame.setVisible(false);
					ProductListUI frame = new ProductListUI(admin);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		SUBMIT.setActionCommand("1");

		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
		controls.add(REMOVE);


		JPanel gui = new JPanel(new BorderLayout(10,10));
		gui.setBorder(new TitledBorder("Edit Discount"));
		gui.add(inputControls, BorderLayout.CENTER);
		gui.add(controls, BorderLayout.SOUTH);



		m.add(choices);
		gui.add(m, BorderLayout.WEST);
		m.setFont(new Font("Courier",Font.BOLD,14));

		averageFrame.setContentPane(gui);
		averageFrame.pack();
		averageFrame.setLocationByPlatform(true);
		averageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		averageFrame.setVisible(true);
	}
}