package BusinessLayer;

import java.io.IOException;

public interface Subject {

	public void registerObserver(Observer O);
	public void notifyObservers() throws IOException;
}