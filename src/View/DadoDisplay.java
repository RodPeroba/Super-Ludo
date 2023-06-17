package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DadoDisplay extends JComponent {

	Graphics2D g2d;
	Image imagem;
	
	public DadoDisplay() {
		
		setBounds(840,450,200,200);
		
	}
	
	public void paintComponent(Graphics g) {
	
		g2d = (Graphics2D) g;
		
		try {
			//TODO RESOLVER A PATH TER QUE SER COMPLETA
			imagem = ImageIO.read(new File ("src/Dado1.png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g2d.drawImage(imagem,0,0,200,200,null);
	}
}
