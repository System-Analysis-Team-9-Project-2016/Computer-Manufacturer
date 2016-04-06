package systemAnalysis;

public interface Subject {
	public void registerObserver(Observer O);
	public void notifyObservers();

}
