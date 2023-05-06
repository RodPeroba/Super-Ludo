package Model;

public class Tabuleiro {
		
		int tamanhoTabuleiro = 43;
		int tamanhoRetaFinal = 7;
		protected Tile[] tabuleiro_basico = new Tile[tamanhoTabuleiro];
		protected Tile[] reta_final_azul = new Tile[tamanhoRetaFinal];
		protected Tile[] reta_final_vermelho = new Tile[tamanhoRetaFinal];
		protected Tile[] reta_final_amarelo = new Tile[tamanhoRetaFinal];
		protected Tile[] reta_final_verde = new Tile[tamanhoRetaFinal];
		
		public Tabuleiro() {
			povoa_tabuleiro();
			linkaTabuleiro();
		}
		
		private void povoa_tabuleiro() {
			for(int i = 0;i < tamanhoTabuleiro;i++) {
				tabuleiro_basico[i] = new Tile();
			}
			for (int i = 0;i < tamanhoRetaFinal;i++) {
				reta_final_azul[i] = new Tile();
			}
			for (int i = 0;i < tamanhoRetaFinal;i++) {
				reta_final_vermelho[i] = new Tile();
			}
			for (int i = 0;i < tamanhoRetaFinal;i++) {
				reta_final_amarelo[i] = new Tile();
			}
			for (int i = 0;i < tamanhoRetaFinal;i++) {
				reta_final_verde[i] = new Tile();
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
				return reta_final_azul[casa]; //TODO Rever necessidade de reta final de varias cores
			}
			else {
				return tabuleiro_basico[casa];
			}
		}
}
