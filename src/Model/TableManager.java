package Model;

import java.awt.Color;

public final class TableManager {

		Tabuleiro tabuleiro;
		int casa_inicial [] = {0,12,24,32}; 
		Color[] cores = {Color.yellow,Color.red,Color.blue,Color.green};
		Peao jogadores[];
		
		public TableManager() {
			tabuleiro = new Tabuleiro();
			for(int i = 0;i < 4;i++) {
				for(int j = 0;j < 4;j++) {
					Tile casaDoPeao = tabuleiro.getCasa(casa_inicial[i], false);
					Peao novoPeao = criaPeao(cores[i],casaDoPeao);
					tabuleiro.adiciona_peao(novoPeao, i);
					System.out.printf("Novo peao da cor %d na casa %d adicionado \n",i , casa_inicial[i]);
					
				}
			}
			
		}
		
		Peao criaPeao(Color cor,Tile tile) {
			Peao peao = new Peao(cor);
			peao.posicao = tile;
			return peao;
			
		}
		/*
		void movePeao(Peao peao,int dado) {
			
			for (int i = 0;i < dado;i++) {
				peao.posicao.peoes.remove(peao);
				if (peao.posicao.proximo.equals(tabuleiro.tabuleiro_basico[casa_inicial[peao.cor]])) {
					//entra na reta final
					peao.posicao = tabuleiro.reta_final[0];
					tabuleiro.reta_final[0].peoes.add(peao);
				}
				else {
					//anda pra frente
					peao.posicao = peao.posicao.proximo;
					peao.posicao.proximo.peoes.add(peao);
				}
			}
		}
		*/
		public Tile[] getTabuleiro() {
			return tabuleiro.tabuleiro_basico;
		}
}
