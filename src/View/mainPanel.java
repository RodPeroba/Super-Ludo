package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * O painel principal da aplicação que contém o tabuleiro e o dado.
 */
public class MainPanel extends JPanel {
	
	private Image boardImage;
	private Graphics2D graphics;

	/**
	 * Cria um novo painel principal.
	 */
	public MainPanel() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		graphics = (Graphics2D) g;
		try {
			boardImage = ImageIO.read(new File ("src/TabuleiroLudo.jpg"));
		}
		catch(IOException e){
			showErrorMessage(e);
			System.exit(1);
		}
		graphics.drawImage(boardImage, 0, 0, 660, 660, null);
	}
	
	/**
	 * Desenha o dado na tela.
	 * @param dice a imagem do dado a ser desenhada.
	 */
	public void drawDice(Image dice) {
		graphics.drawImage(dice, 450, 850, 200, 200, null);
	}

	/**
	 * Mostra uma mensagem de erro ao usuário.
	 * @param e a exceção que causou o erro.
	 */
	private void showErrorMessage(Exception e) {
		JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
