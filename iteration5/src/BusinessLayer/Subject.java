package BusinessLayer.ProductClasses;

import java.io.IOException;

import BusinessLayer.Observer;

public interface Subject {
	
	public void registerObserver(Observer O);
	public void notifyObservers() throws IOException;

	
}
