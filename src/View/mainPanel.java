package View;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.*;

public class MainPanel extends JPanel{
	
	Image imagem;
	Graphics2D g2d;
	DadoDisplay dadoDisplay = new DadoDisplay();
	Controller controller = Controller.getController();
	
	public MainPanel() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setBounds(0,0, screenSize.width, screenSize.height);
		setLayout(null);
		dadoDisplay.setPreferredSize(new Dimension(200,200));
		add(dadoDisplay);
		
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g2d = (Graphics2D) g;
		try {
		
			imagem = ImageIO.read(new File ("src/TabuleiroLudo.jpg"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g2d.drawImage(imagem,0,0,660,660,null);
		
		controller.drawPeoes(g2d);
	}
	
	void drawPlayer(int posX, int posY, Color cor) {
		Ellipse2D player;
		player = new Ellipse2D.Float(posX, posY, 50, 50);
		g2d.setColor(cor);
		g2d.fill(player);
	}

}