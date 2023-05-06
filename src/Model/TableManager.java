package Model;

public final class TableManager {

		Tabuleiro tabuleiro;
		int casa_inicial [] = {0,12,24,32}; 
		
		Peao jogadores[];
		
		public TableManager() {
			tabuleiro = new Tabuleiro();
			for(int i = 0;i < 4;i++) {
				for(int j = 0;j < 4;j++) {
					Tile casaDoPeao = tabuleiro.getCasa(casa_inicial[i], false);
					Peao novoPeao = criaPeao(i,casaDoPeao);
					tabuleiro.adiciona_peao(novoPeao, i);
					System.out.printf("Novo peao da cor %d na casa %d adicionado \n",i , casa_inicial[i]);
					
				}
			}
			
		}
		
		Peao criaPeao(int cor,Tile tile) {
			Peao peao = new Peao(cor);
			peao.posicao = tile;
			return peao;
			
		}
		
		void movePeao(int posicao,int dado) {
			
			int novaPosicao = posicao + dado;
			if (novaPosicao < 44) {
				// movimentacao do tabuleiro basico para tabuleiro basico
				Peao peao = tabuleiro.tabuleiro_basico[posicao].peoes.get(0);
				if (tabuleiro.tabuleiro_basico[novaPosicao].isEmpty()) {
					tabuleiro.tabuleiro_basico[novaPosicao].peoes.add(peao);
					peao.posicao = tabuleiro.tabuleiro_basico[novaPosicao];
				}
				//caso nao esteja vazio mas ainda possa andar
				//else if() {}
				//else {}
				//caso nao possa se mover para a posica
			}
			
			//entrada na reta final
			//else if(){}
			
			//da reta final pra reta final
			//else {}
				
		}
		
}
