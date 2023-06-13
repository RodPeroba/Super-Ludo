package View;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DadoListener implements ActionListener {
	Component c;
	MainPanel dicePanel = new MainPanel();	
	Image imagem;
	public DadoListener (Component x) {
		c=x;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Dado jogado");
		//Selecionar o valor do dado
		//TODO renomear a path de acordo com o valor do dado
		try {
			imagem = ImageIO.read(new File("C:\\Users\\Rodrigo Peroba\\eclipse-workspace\\Ludo\\src\\Dado1.png"));
		}
		catch(IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(2);
		}
		//Desenhar o dado

		//TODO o dado nao aparece
	}

}
