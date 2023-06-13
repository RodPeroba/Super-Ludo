package View;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPanel extends JPanel{
	
	Image imagem;
	Graphics g2d;
	public MainPanel() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setBounds(0,0, screenSize.width, screenSize.height);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
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
	
	public void drawDice(Image dice) {
		g2d.drawImage(dice, 450, 850,200,200, null);
	}
}