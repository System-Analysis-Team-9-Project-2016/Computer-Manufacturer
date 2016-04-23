package UserInterfaceLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BusinessLayer.AddNewGroupDiscount;
import BusinessLayer.ApplyDiscount;
import BusinessLayer.BusinessLayerDataControl;
import BusinessLayer.CustomerClasses.Admin;
import BusinessLayer.OrderClasses.GroupDiscount;
import BusinessLayer.ProductClasses.Product;
import DataLayer.DataControl;

public class AddNewGroupDiscountUI {

	private JList choices;
	private ArrayList<Product> productsInFile;
	private ArrayList<Integer> added;
	private DefaultListModel<String> model;

	AddNewGroupDiscountUI(Admin admin) throws IOException{
		JButton SUBMIT;
		JPanel panel;
		JLabel label0 , label1;
		final JLabel label2;
		final JTextField  text1;

		JPanel inputControls;

		JPanel labelPanel = new JPanel(new GridLayout(0,1,3,3));
		JPanel fieldPanel = new JPanel(new GridLayout(0,1,3,3));
		JPanel addedPanel = new JPanel(new GridLayout(0,1,3,3));

		inputControls = new JPanel(new BorderLayout(5,5));
		inputControls.add(labelPanel, BorderLayout.WEST);
		inputControls.add(fieldPanel, BorderLayout.CENTER);
		inputControls.add(addedPanel, BorderLayout.SOUTH);

		JFrame averageFrame = new JFrame("Group Discount Page");

		label1 = new JLabel();
		label1.setText("Please enter your discount");
		text1 = new JTextField(15);

		labelPanel.add(label1);
		fieldPanel.add(text1);

		label2 = new JLabel();
		label2.setText("Products in Discount = ");
		addedPanel.add(label2);

		productsInFile = BusinessLayerDataControl.factoryDesignPatternSearch();

		added = new ArrayList<Integer>();

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

				AddNewGroupDiscount a = new AddNewGroupDiscount();
				if (a.validateDiscount(added, text1.getText()))	{
					try {
						double discount = Double.parseDouble(text1.getText());
						a.newGroupDiscount(added, discount);
						averageFrame.setVisible(false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		SUBMIT.setActionCommand("1");

		JButton Add;

		Add=new JButton("Add");

		Add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int selected = choices.getSelectedIndex();
				AddNewGroupDiscount a = new AddNewGroupDiscount();
				Product p = productsInFile.get(selected);
				if(a.validateAdd(added, p.getProductId())){
					added.add(p.getProductId());
					label2.setText(label2.getText() + p.getProductName() + " ");
				}


			}
		});


		JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
		controls.add(SUBMIT);
		controls.add(Add);


		JPanel gui = new JPanel(new BorderLayout(10,10));
		gui.setBorder(new TitledBorder("Edit Group Discount"));
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