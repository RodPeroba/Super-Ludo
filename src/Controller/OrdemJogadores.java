package Controller;

import java.awt.Color;

public class OrdemJogadores {
	private Jogador primeiro;
	private Jogador ultimo;
	private int tamanho = 0;
	
	public OrdemJogadores() {
		primeiro = null;
		ultimo = null;
	}
	
	public void insere(Color cor) {
		Jogador jogador = new Jogador(cor);
		if (primeiro == null) {
			primeiro = jogador;
			ultimo = jogador;
			jogador.proxJogador = jogador;
		}
		else {
			ultimo.proxJogador = jogador;
			ultimo = jogador;
			jogador.proxJogador = primeiro;
		}
		tamanho++;
	}
	
	public Jogador getPrimeiro() {
		return primeiro;
	}
}