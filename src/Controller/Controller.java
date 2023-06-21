package Controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import View.*;


public class Controller {
	
	TableManager tableManager = null;
	TabuleiroWindow tabuleiroWindow = null;
	MainWindow mainWindow = null;
	HomeWindow homeWindow = null;
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
		// mainWindow = new MainWindow();
		homeWindow = new HomeWindow();
		homeWindow.setVisible(true);
		// mainWindow.setVisible(true);
		tableManager = TableManager.getInstance();
	}

	public void iniciarPartida() {
		homeWindow.setVisible(false);
		tableManager.iniciaPartida();
		setarTabuleiro();
	}
	

	public void setarTabuleiro() {
		tabuleiroWindow = new TabuleiroWindow(1);
		tabuleiroWindow.setVisible(true);

	}

}
