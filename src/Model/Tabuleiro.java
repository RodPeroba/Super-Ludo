package Model;

public class Tabuleiro {
		
		int tamanhoTabuleiro = 43;
		int tamanhoRetaFinal = 7;
		protected Tile[] tabuleiro_basico = new Tile[tamanhoTabuleiro];
		protected Tile[] reta_final = new Tile[tamanhoRetaFinal];
		
		public Tabuleiro() {
			povoa_tabuleiro();
			linkaTabuleiro();
		}
		
		private void povoa_tabuleiro() {
			for(int i = 0;i < tamanhoTabuleiro;i++) {
				tabuleiro_basico[i] = new Tile();
			}
			for (int i = 0;i < tamanhoRetaFinal;i++) {
				reta_final[i] = new Tile();
			}

		}
		private void linkaTabuleiro() { //TODO linkar o anterior
			for(int i = 0;i < tamanhoTabuleiro-1;i++) {//vai ate o penultimo
				tabuleiro_basico[i].proximo = tabuleiro_basico[i+1];
			}
			tabuleiro_basico[tamanhoTabuleiro-1].proximo = tabuleiro_basico[0];
		}
		protected void adiciona_peao(Peao peao, int posicao) {
			tabuleiro_basico[posicao].peoes.add(peao);
		}
		
		Tile getCasa(int casa, boolean retaFinal) {
			if (retaFinal) {
				return reta_final[casa];
			}
			else {
				return tabuleiro_basico[casa];
			}
		}
}
