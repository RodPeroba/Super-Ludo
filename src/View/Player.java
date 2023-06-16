package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Player {
	
	private final int size = 30;
	private int posX;
	private int posY;
	private Color cor;
	Graphics2D g2d;
	
	public Player(int x, int y,Color color, Graphics2D g) {
		posX = x;
		posY = y;
		cor = color;
		g2d = g;
	}
	
	void draw() {
		Ellipse2D player;
		player = new Ellipse2D.Float(posX, posY, size, size);
		g2d.setColor(cor);
		g2d.fill(player);
	}
	
}
