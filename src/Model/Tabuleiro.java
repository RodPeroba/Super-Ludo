package Model;

public class Tabuleiro {
		
		int tamanhoTabuleiro = 32;
		int tamanhoRetaFinal = 7;
		private Tile[] tabuleiro_basico ;
		private Tile[] reta_final_azul ;
		private Tile[] reta_final_vermelho;
		private Tile[] reta_final_amarelo;
		private Tile[] reta_final_verde;
		
		public Tabuleiro() {
			povoa_tabuleiro();
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
}
