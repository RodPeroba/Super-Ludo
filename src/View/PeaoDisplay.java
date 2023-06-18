package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class PeaoDisplay extends JComponent {
	
	private final int size = 30;
	private int posX;
	private int posY;
	private Color cor;

	public PeaoDisplay(int x, int y,Color color) {
		posX = x;
		posY = y;
		cor = color;
		setBounds(0,0, 660, 660);
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D player;
		player = new Ellipse2D.Float(posX, posY, size, size);
		g2d.setColor(cor);
		g2d.fill(player);
		System.out.println("Peao display paintComponent foi chamado");
	}
}
