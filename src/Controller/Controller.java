package Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import Model.*;
import View.*;


public class Controller implements MouseListener, IObservable{
	
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
		tableManager = TableManager.getInstance();
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
			mainWindow.getButtonGroup().clearSelection();
			return dado.dadoValor;//TODO passar um valor caso precise forçar o dado
		}
		
		return -1;
	}

	@Override
	public void notify(IObserver o) {
		o.update(controller);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point location = e.getPoint();	
		//Mouse 1
		if (e.getButton() == 1) {
			//TODO somente para teste isso, retirar depois
			System.out.println(location);
			PeaoDisplay peao = new PeaoDisplay((int)location.getX(),(int)location.getY(),Color.red);
			mainWindow.drawPawn(peao);
			mainWindow.update(this);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
