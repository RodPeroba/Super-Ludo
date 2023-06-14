package Model;

public class Peao {
		protected int cor;
		protected Tile posicao; 
		
		protected Peao(int cor) {
			this.cor = cor;
		}
		
		public static Peao criarPeao(int cor) {
			return new Peao(cor);
		}

		public int getCor() {
			return cor;
		}
}
