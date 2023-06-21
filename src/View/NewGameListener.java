package View;

import Controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class NewGameListener implements ActionListener,IObserver {
	Component c;
	MainPanel dicePanel = new MainPanel();	
	Image imagem;
	int diceValue = 0;
	Controller controller = Controller.getController();
  
	
	public NewGameListener (Component x) {
		c=x;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//Selecionar o valor do dado
		
		try {
			imagem = ImageIO.read(new File("src/Dado1.png"));
		}
		catch(IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(2);
		}
		
		
	}

	@Override
	public void update(IObservable o) {

		diceValue = (int) o.get(1);
		System.out.println(diceValue);
		
	}

}
