package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Controller;
import Controller.IObservable;
import Controller.IObserver;

public class DadoDisplay extends JComponent implements IObserver {

	Graphics2D g2d;
	Image imagem;
	Controller controller = Controller.getController();
	String pathDado = null;
	public DadoDisplay() {
		
		setBounds(830,450,200,200);

	}
	
	public void paintComponent(Graphics g) {
		g2d = (Graphics2D) g;
		System.out.println("Dado display paint component");
		if (pathDado != null) {
			desenhaDado();
		}
		if (controller.jogadorDaVez.cor == null) {
			g2d.setColor(Color.green);
		}
		else {
			g2d.setColor(controller.jogadorDaVez.cor);
		}
		g2d.fillRect(0, 0, 200, 200);
		
		try {
			
			imagem = ImageIO.read(new File ("src/Dado1.png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g2d.drawImage(imagem,10,10,180,180,null);
		
	}
	
	public void changeDice() {}

	@Override
	public void update(IObservable o) {
		setBackground(controller.jogadorDaVez.cor);
		int valorDado = (int) o.get(2);
		pathDado = String.format("src/Dado%d.png",valorDado);
		System.out.println(valorDado);
		desenhaDado();
		repaint();
	}
	
	public void desenhaDado() {
		
		try {
			
			imagem = ImageIO.read(new File (pathDado));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g2d.drawImage(imagem,10,10,180,180,null);
	}
}

