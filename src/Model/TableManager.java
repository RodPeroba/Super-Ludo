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
}
