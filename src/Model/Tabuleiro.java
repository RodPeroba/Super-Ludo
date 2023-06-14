package Model;

public class Tabuleiro {

		private static final int TAMANHO_TABULEIRO = 43;
    private static final int TAMANHO_RETA_FINAL = 7;

		protected Tile[] tabuleiroBasico = new Tile[TAMANHO_TABULEIRO];
		protected Tile[] retaFinal = new Tile[TAMANHO_RETA_FINAL];
		
		public Tabuleiro() {
        povoaTabuleiro();
        conectaTilesTabuleiro();
		}
		
		private void povoaTabuleiro() {
			for(int i = 0;i < TAMANHO_TABULEIRO;i++) {
				tabuleiroBasico[i] = new Tile();
			}
			for (int i = 0;i < TAMANHO_RETA_FINAL;i++) {
				retaFinal[i] = new Tile();
			}

		}
		private void conectaTilesTabuleiro() { //TODO linkar o anterior
		 for(int i = 0; i < TAMANHO_TABULEIRO - 1; i++) {
            tabuleiroBasico[i].setProximo(tabuleiroBasico[i + 1]);
        }
        tabuleiroBasico[TAMANHO_TABULEIRO - 1].setProximo(tabuleiroBasico[0]);
		}

    public void adicionaPeao(Peao peao, int posicao) {
        tabuleiroBasico[posicao].adicionaPeao(peao);
    }
		
		Tile getCasa(int casa, boolean isRetaFinal) {
			if (isRetaFinal) {
				return retaFinal[casa];
			}
			else {
				return tabuleiroBasico[casa];
			}
		}
}
