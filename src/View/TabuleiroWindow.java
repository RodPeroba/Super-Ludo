package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Controller;
import Controller.IObservable;
import Controller.IObserver;
import Model.Peao;

public class TabuleiroWindow extends JFrame implements ActionListener, IObserver{
	private Controller controller;
	private Image tabuleiro, imagemDados[];
	private ArrayList<Player> peoes = new ArrayList<Player>();
	final int NUMERO_JOGADORES = 4;
	private int jogadorDaVez, casaDaVez, dadoDaVez, saldoJogadores[], posJogadores[];
	final int ALTURA = 700;
	final int COMPRIMENTO = 1200;
	final int N_DADOS = 6;
	final int N_PINOS = 6;
	Color[] cores = {Color.RED, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.GRAY};
	Color corPadrao = new Color(51, 185, 222);
	Color corBox = new Color(223, 239, 245);
	
	String[] notificacoes = {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"};
	String[] selecaoDados = {"1", "2", "3", "4", "5", "6"};
	String[] descricaoDaVez = {""};
  String[] nomes = {"Verde", "Amarelo", "Azul", "Vermelho"};
	
	private JButton botaoLancarDado = createButton("Lançar Dados", 690, 150, 170, 30);
	private JButton botaoSalvarJogo = createButton("Salvar Partida", 950, 540, 170, 30);
	
	private JComboBox<String> dado = createCombo(selecaoDados, 710, 185);
	
	public TabuleiroWindow(
    // int[] posJogadores,
     int jogadorDaVez
    ) {
		this.controller = Controller.getController();
		this.jogadorDaVez = jogadorDaVez;
		this.saldoJogadores = saldoJogadores;
    // this.peoes = peoes;
		// this.posJogadores = posJogadores;
    try {
      tabuleiro = ImageIO.read(new File ("src/TabuleiroLudo.jpg"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    dadoDaVez = 1;
    	
		for (int i=0; i<N_PINOS; i++) {
			Player peao = new Player (50,50,Color.RED);
			peoes.add(peao);
		}
    	
		imagemDados = new Image[N_DADOS];
    	for (int i=0; i<N_DADOS; i++) {
    		try {
          imagemDados[i] = ImageIO.read(new File ("src/Dado"+ String.valueOf(i+1) +".jpg"));
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    	}
    	    	
    	setLayout(null);
    	setTitle("Super Ludo");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - COMPRIMENTO) / 2;
		int y = (screenSize.height - ALTURA) / 2;
        setBounds(x, y, COMPRIMENTO, ALTURA);
        // ImageIcon icon = new ImageIcon(Imagem.get("icon_menu"));
        // setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // getContentPane().setBackground(corPadrao);
    	
    	
    	this.add(botaoLancarDado);
    	this.add(botaoSalvarJogo);
    	this.add(dado);
	}
	
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr; 
		g.drawImage(tabuleiro, 20, 40, 620, 620, this);
		
		g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 1.6F)); 
		g.drawString("Vez do " + nomes[jogadorDaVez], 715, 60);
		
		g.setColor(cores[jogadorDaVez]);
		g.fillRect(685, 70, 190, 100);
		
		g.setColor(corBox);
		g.fillRect(920, 70, 250, 230);
		g.fillRect(920, 340, 250, 35*NUMERO_JOGADORES);
		
		g.drawImage(imagemDados[dadoDaVez-1], 695, 80, 80, 80, this);

		
		g.setColor(Color.BLACK);
	
		for (Player peao : peoes) {
			peao.paintComponent(g);
		}
	}
	
    public void abrir() {
        setVisible(true);
    }
    
    public void fechar() {
        setVisible(false);
    }
	
    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	
        // if (obj.equals(comboPropriedades)) {
        // 	String p = (String)(((JComboBox<String>)obj).getSelectedItem());
        // 	casaDaVez = controller.getPosCasa(p);
        // 	descricaoDaVez = controller.getDescricao(casaDaVez);
        // } 
        
        // else if (obj.equals(botaoLancarDado)) {
        // 	controller.rolarDados(jogadorDaVez);
        // }
        
        // else if (obj.equals(botaoSalvarJogo)) {
        // 	controller.salvarPartida();
        // }
        
        // else if (obj.equals(botaoEncerrarJogo)) {
        // 	encerraJogo(controller.reunePatrimonios());
        // }
        
        // else if (obj.equals(dado)) {
        // 	dadosDaVez[0] = Integer.parseInt((String) dado.getSelectedItem());
        // }
        
        // else if (obj.equals(comboDado2)) {
        // 	dadosDaVez[1] = Integer.parseInt((String) comboDado2.getSelectedItem());
        // }
        
        repaint();
    }
    
    public void atualiza(String evento) {
    	// switch(evento) {
    	// 	case "novoValorDados":
    	// 		dadosDaVez = controller.getDados();
    	// 		break;
    			
    	// 	case "usouSaidaLivre":
    	// 		addNotificacao(nomes[jogadorDaVez] + " utilizou a Sa�da Livre!");
    	// 		break;
    			
    	// 	case "sucessoCompra":
    	// 		addNotificacao("Compra efetuada com sucesso!");
    	// 		descricaoDaVez = controller.getDescricao(casaDaVez);
    	// 		break;
    			
    	// 	case "falhaCompra":
    	// 		addNotificacao("Compra n�o efetuada: saldo insuficiente");
    	// 		break;
    			
    	// 	case "sucessoVenda":
    	// 		addNotificacao("Venda efetuada com sucesso!");
    	// 		descricaoDaVez = controller.getDescricao(casaDaVez);
    	// 		break;
    			
    	// 	case "prisao":
    	// 		addNotificacao(nomes[jogadorDaVez] + " foi para a pris�o");
    	// 		break;
    			
    	// 	case "propriedadeComDono":
    	// 		addNotificacao("Propriedade com dono. Pague o aluguel");
    	// 		break;
    			
    	// 	case "falencia":
    	// 		addNotificacao("Jogador foi � fal�ncia");
    	// 		break;
    			
    	// 	case "fimDoJogo":
    	// 		encerraJogo(controller.reunePatrimonios());
    	// 		break;
    	// }
    	repaint();
    }
    
    public void atualiza(String evento, String s, int q1, int q2)  {
    	switch(evento) {
    		case "novoSaldoJogador":
    			for (int i=0; i<NUMERO_JOGADORES; i++) {
    				if (nomes[i].equals(s)) {
    					saldoJogadores[i] = q2;
    					break;
    				}
    			}
    			addNotificacao("Saldo de " + s + ": $" + Integer.toString(q1) + " -> $" + Integer.toString(q2));
    			break;
    		case "novaPosJogador":
    			posJogadores[jogadorDaVez] = q1;
    			break;
    	}
    	repaint();
    }
    
    public void atualiza(String evento, int n) {
    	switch(evento) {
			case "passouVez":
				jogadorDaVez = n;
				break;
				
	    	case "sorteReves":
	    		// ImageIcon icon_carta = new ImageIcon(Imagem.get("chance" + Integer.toString(n)));
	    		// JOptionPane.showMessageDialog(this, new JLabel(icon_carta, JLabel.CENTER), "Sorte ou Reves selecionado", JOptionPane.INFORMATION_MESSAGE);
	    		break;
	    	}
    }
    
    public int getValorDado() {
    	return Integer.parseInt((String) dado.getSelectedItem());
    }
    
	public void encerraJogo(int[] patrimonios) {
		String ordenado[] = new String[NUMERO_JOGADORES];
		for (int i=0; i<NUMERO_JOGADORES; i++) {
			ordenado[i] = ("$" + Integer.toString(patrimonios[i]) + "#" + nomes[i]);
		}
		Arrays.sort(ordenado, Collections.reverseOrder());
		
		String msg = "Posi��o dos jogadores:\n";
		for (int i=0; i<NUMERO_JOGADORES; i++) {
			msg += Integer.toString(i+1) + " - " + ordenado[i].split("#")[1] + ": (" + ordenado[i].split("#")[0] + ")\n";
		}
		msg += "\n";
		JOptionPane.showMessageDialog(this, msg, "PARTIDA ENCERRADA", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
    
    private void addNotificacao(String msg) {
    	for (int i=(notificacoes.length)-1; i>=1; i--) {
    		notificacoes[i] = notificacoes[i-1];
    	}
    	notificacoes[0] = "- " + msg;
    }
    
	private JButton createButton(String name, int x, int y, int comp, int alt) {
		JButton b = new JButton(name);
		b.setBounds(x, y, comp, alt);
		b.addActionListener(this);
		return b;
	}
	
	private JComboBox<String> createCombo(String[] selecao, int x, int y) {
		JComboBox<String> c = new JComboBox<>(selecao);
		c.setBounds(x, y, c.getPreferredSize().width, c.getPreferredSize().height);
		c.addActionListener(this);
		return c;
	}
	
	public int exibeCompraProp(int posCasa) {
		return JOptionPane.showConfirmDialog(this, "A proriedade est� � venda. Voc� deseja compr�-la?", "Propriedade � venda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public int exibeDonoProp(int posCasa, boolean podeCasa, boolean podeHotel) {
		String[] opcoes;
		if (podeCasa && podeHotel) {
			opcoes = new String[]{"N�o fazer nada", "Vender propriedade", "Comprar casa", "Comprar hotel"};
		}
		else if (podeCasa) {
			opcoes = new String[]{"N�o fazer nada", "Vender propriedade", "Comprar casa"};
		}
		else if (podeHotel) {
			opcoes = new String[]{"N�o fazer nada", "Vender propriedade", "Comprar hotel"};
		}
		else {  //jogador j� possui todas as casas e hoteis desse terreno, ou todas as casas e hoteis do jogo est�o sendo utilizadas
			opcoes = new String[]{"N�o fazer nada", "Vender propriedade"};
		}
		return JOptionPane.showOptionDialog(this, "Voc� � o dono dessa propriedade. Escolha o que deseja fazer com ela:", "Titular da propriedade", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public String exibeVendaForcada(String[] propriedades, String nome) {
		JComboBox<String> selecao = new JComboBox<>(propriedades);
		JOptionPane.showMessageDialog(this, selecao, nome + ": venda uma propriedade", JOptionPane.QUESTION_MESSAGE);
		return (String) selecao.getSelectedItem();
	}

  @Override
  public void update(IObservable o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }
}
