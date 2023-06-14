package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Player {
	
	private final int size = 30;
	private int posX;
	private int posY;
	private Color color;
	Graphics2D graphics;

	public Player(int x, int y,Color color, Graphics2D graphics) {
		this.posX = x;
		this.posY = y;
		this.color = color;
		this.graphics = graphics;
	}
	
	void draw() {
		Ellipse2D player = createPlayerShape();
		graphics.setColor(color);
		graphics.fill(player);
	}

	private Ellipse2D createPlayerShape() {
		return new Ellipse2D.Float(posX, posY, size, size);
	}
	
}
