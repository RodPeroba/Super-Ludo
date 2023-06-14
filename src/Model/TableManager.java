package Model;

public final class TableManager {

		Tabuleiro tabuleiro;
		int casaInicial[] = {0,12,24,32}; 
		
		Peao jogadores[];
		
		public TableManager() {
			tabuleiro = new Tabuleiro();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					Tile casaDoPeao = tabuleiro.getCasa(casaInicial[i], false);
					Peao novoPeao = criaPeao(i, casaDoPeao);
					tabuleiro.adicionaPeao(novoPeao, i);
					System.out.printf("Novo peao da cor %d na casa %d adicionado \n", i, casaInicial[i]);
				}
			}
			
		}
		
		Peao criaPeao(int cor, Tile tile) {
			Peao peao = new Peao(cor);
			peao.posicao = tile;
			return peao;
			
		}
		
		void movePeao(Peao peao, int dado) {
			// Verificar se a posição do peão é válida
			if (peao.posicao == null) {
				throw new IllegalArgumentException("Posição inválida do peão");
			}

			for (int i = 0; i < dado; i++) {
				peao.posicao.peoes.remove(peao);
				if (peao.posicao.proximo.equals(tabuleiro.tabuleiroBasico[casaInicial[peao.cor]])) {
					// Entra na reta final
					peao.posicao = tabuleiro.retaFinal[0];
					tabuleiro.retaFinal[0].peoes.add(peao);
				}
				else {
					// Anda para frente
					peao.posicao = peao.posicao.proximo;
					peao.posicao.proximo.peoes.add(peao);
				}
			}
		}
}
