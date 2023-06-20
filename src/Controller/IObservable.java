package Controller;


public interface IObservable {
	public void addObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notify(IObserver o);
	public void notifyAll(IObserver[] o);
	public Object get(int i);
}
