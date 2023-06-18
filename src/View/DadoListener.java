package View;

import Controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DadoListener implements ActionListener {
	Component c;
	MainPanel dicePanel = new MainPanel();	
	Image imagem;
	int diceValue = 0;
	Controller controller = Controller.getController();
	
	public DadoListener (Component x) {
		c=x;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Dado jogado");
		//Selecionar o valor do dado
		
		try {
			imagem = ImageIO.read(new File("src/Dado1.png"));
		}
		catch(IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(2);
		}
		
		diceValue = (int) controller.get(1);
		System.out.println(diceValue);
	}

}
