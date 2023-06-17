package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Player extends JComponent {
	
	private final int size = 30;
	private int posX;
	private int posY;
	private Color cor;
	Graphics2D g2d;
	
	public Player(int x, int y,Color color) {
		posX = x;
		posY = y;
		cor = color;
		setBounds(0,0, 660, 660);
	}
	
	void drawPlayer() {
		Ellipse2D player;
		player = new Ellipse2D.Float(posX, posY, size, size);
		g2d.setColor(cor);
		g2d.fill(player);
	}
	
	public void paintComponent(Graphics g) {
		
		g2d = (Graphics2D) g;
		drawPlayer();
	}
}
