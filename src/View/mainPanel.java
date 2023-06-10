package View;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mainPanel extends JPanel{
	
	Image imagem;
	
	public mainPanel() {
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		try {
			//TODO RESOLVER A PATH TER QUE SER COMPLETA
			imagem = ImageIO.read(new File ("C:\\Users\\Rodrigo Peroba\\eclipse-workspace\\Ludo\\src\\TabuleiroLudo.jpg"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g2d.drawImage(imagem,0,0,660,660,null);
		
	}
}