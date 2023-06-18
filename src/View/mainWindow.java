package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.*;


public class MainWindow extends JFrame implements IObserver{
	
	public final int LARGURA = 1200;
	public final int ALTURA = 700;
	public final int BUTTON_HEIGHT = 40;
	public final int BUTTON_WIDTH = 120;
	
	JPanel panel = new MainPanel();
	
	public MainWindow() {
		super();

		JButton newGameButton, continueButton, saveButton, diceButton;
	    setTitle("Ludo");
	    setSize(LARGURA, ALTURA);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().add(panel);
	    setResizable(false);
	    
	    //NovoJogo
	    newGameButton = new JButton("Novo Jogo");
	    panel.add(newGameButton);
	    //CarregarJogo
	    continueButton = new JButton("Carregar Jogo");
	    panel.add(continueButton);
	    //Salvar
	    saveButton = new JButton("Salvar");
			saveButton.addActionListener(new SaveListener(this));
	    panel.add(saveButton);
	    //À jogar
	    
	    //Lança Dado
	    diceButton = new JButton ("Jogar o Dado");
	    diceButton.addActionListener(new DadoListener(this));
	    panel.add(diceButton);
	    
	    Insets in = panel.getInsets();

	    newGameButton.setBounds(in.left + 870, in.top + 50, BUTTON_WIDTH, BUTTON_HEIGHT);
	    continueButton.setBounds(in.left + 870, in.top + 100, BUTTON_WIDTH, BUTTON_HEIGHT);
	    saveButton.setBounds(in.left + 870, in.top + 150, BUTTON_WIDTH, BUTTON_HEIGHT);
	    diceButton.setBounds(in.left + 870, in.top + 400, BUTTON_WIDTH, BUTTON_HEIGHT);
	    
	}

	@Override
	public void update(IObservable o) {
		// TODO Auto-generated method stub
		
	}
}
