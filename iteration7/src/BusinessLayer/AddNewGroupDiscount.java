package BusinessLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import DataLayer.DataControl;

public class AddNewGroupDiscount {
	
	public void newGroupDiscount(ArrayList<Integer> added , double discount) throws FileNotFoundException{
		BusinessLayerDataControl dataControl = new BusinessLayerDataControl();
		dataControl.writeNewDiscountToFile(added , discount);
	}
	
	public boolean validateDiscount(ArrayList<Integer> added , String discount){
		try {
			Double.parseDouble(discount);
			if(added.size() < 2)
				return false;
			else return true;
	    } 
		catch (NumberFormatException e) {
	        //error
	        return false;
	    }
	}
	
	public boolean validateAdd(ArrayList<Integer> added , int id){
		boolean found = false;
		for (int i =0;i < added.size() && !found;i++){
			if(added.get(i) == id)
				found = true;
		}
		return !found;
	}

}