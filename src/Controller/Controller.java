package Controller;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import View.*;


public class Controller implements IObservable{
	
	TableManager tableManager = null;
	MainWindow mainWindow = null;
	List<IObserver> observers=new ArrayList<IObserver>();
	Tile[] tabuleiro_basico = null;
	private static Controller controller = null;
	private Dado dado = Dado.getDado();
	
	private Controller() {}

	public static Controller getController() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public void init() {
		tableManager = new TableManager();
	    mainWindow = new MainWindow();
	    mainWindow.setVisible(true);
	}
	
	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public Object get(int i) {

		if (i==1) {
			return dado.dadoValor;
		}
		
		return -1;
	}

	@Override
	public void notify(IObserver o) {
		o.update(controller);
		
	}

}
