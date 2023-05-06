package Model;

public class Peao {

		protected int cor;
		protected Tile posicao; // Talvez tirar isso, vai dar um problema de mismatch
		
		protected Peao(int cor) {
			this.cor = cor;
		}
		
		public int getCor() {
			return cor;
		}
		public void move(int n) {
			for (int i = 0;i<n;i++) {
				posicao = posicao.proximo;
			}
		}
}
