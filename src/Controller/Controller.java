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
	List<Peao> peoes;
	Tile[] tabuleiro_basico = null;

	private int[][] tabelaPosicao = {{360,70},{360,110},{360,150},{360,190},{360,230},
									 {400,270},{440,270},{480,270},{520,270},{560,270},{600,270},{600,310},{600,350},
									 {560,350},{520,350},{480,350},{440,350},{400,350},
									 {360,390},{360,430},{360,470},{360,510},{360,550},{360,590},{320,590},{280,590},
									 {280,550},{280,510},{280,470},{280,430},{280,390},
									 {240,350},{200,350},{160,350},{120,350},{80,350},{40,350},{40,310},{40,270},
									 {80,270},{120,270},{160,270},{200,270},{240,270},
									 {280,230},{280,190},{280,150},{280,110},{280,70},{280,30},{320,30},{360,30},
	
	};
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
	    
	    tableManager.getPeoes();
	    drawPawns();
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
	
	private void drawPawns() {
		/*
		for (Peao pawn:peoes) {
			int indice = pawn.getPosicao().getIndice();
			PeaoDisplay peao = new PeaoDisplay(tabelaPosicao[indice][0],tabelaPosicao[indice][1],Color.red);
			mainWindow.drawPawn(peao);
			mainWindow.update(this);
		}
		*/
	}

}
