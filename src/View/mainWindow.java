package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.*;


public class MainWindow extends JFrame implements IObserver{
	
	private final boolean DEBUG = true;
	
	private final int LARGURA = 1200;
	private final int ALTURA = 700;
	private final int BUTTON_HEIGHT = 40;
	private final int BUTTON_WIDTH = 120;
	
	private JPanel panel = new MainPanel();
	private ButtonGroup choseDiceValue = new ButtonGroup();

	Controller controller = Controller.getController();
	
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
	    
	    if (DEBUG) {
		    JRadioButton valor1 = new JRadioButton();
		    valor1.setBounds(in.left + 1070, in.top + 400,50,50);
		    valor1.setText("1");
		    JRadioButton valor2 = new JRadioButton();
		    valor2.setBounds(in.left + 1070, in.top + 440,50,50);
		    valor2.setText("2");
		    JRadioButton valor3 = new JRadioButton();
		    valor3.setBounds(in.left + 1070, in.top + 480,50,50);
		    valor3.setText("3");
		    JRadioButton valor4 = new JRadioButton();
		    valor4.setBounds(in.left + 1070, in.top + 520,50,50);
		    valor4.setText("4");
		    JRadioButton valor5 = new JRadioButton();
		    valor5.setBounds(in.left + 1070, in.top + 560,50,50);
		    valor5.setText("5");
		    JRadioButton valor6 = new JRadioButton();
		    valor6.setBounds(in.left + 1070, in.top + 600,50,50);
		    valor6.setText("6");
		    
		    choseDiceValue.add(valor1);
		    choseDiceValue.add(valor2);
		    choseDiceValue.add(valor3);
		    choseDiceValue.add(valor4);
		    choseDiceValue.add(valor5);
		    choseDiceValue.add(valor6);
		    
		    panel.add(valor1);
		    panel.add(valor2);
		    panel.add(valor3);
		    panel.add(valor4);
		    panel.add(valor5);
		    panel.add(valor6);
	    }
	    
	    panel.addMouseListener(controller);
	    
	}

	@Override
	public void update(IObservable o) {
		repaint();
	}
	
	public void drawPawn(PeaoDisplay pawn) {
		panel.add(pawn);
	}

	public ButtonGroup getButtonGroup() {
		return choseDiceValue;
	}

}
