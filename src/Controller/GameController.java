package Controller;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import Model.*;
import View.*;


public class GameController implements IObservable{
	
	TableManager tableManager = null;
	MainWindow mainWindow = null;
	List<IObserver> observers=new ArrayList<IObserver>();
	Tile[] tabuleiro_basico = null;
	private static GameController controller = null;
	private Dado dado = Dado.getDado();
	
	private GameController() {}

	public static GameController getController() {
		if (controller == null) {
			controller = new GameController();
		}
		return controller;
	}
	
	public void init() {
		tableManager = TableManager.getInstance();
	    mainWindow = new MainWindow();
	    mainWindow.setVisible(true);
	}

    public void saveGame() {
        System.out.print("salvando o game state no controller");
        TableManager tableManager = TableManager.getInstance();
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                tableManager.saveToFile(file.getPath());
            } catch (IOException e) {
                // handle exception
                System.out.println(e.getMessage());
            }
        }
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

	@Override
	public void notifyAll(IObserver[] o) {
		// TODO Auto-generated method stub
		
	}

}