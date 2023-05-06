package Model;

public class Peao {

		protected int cor;
		protected Tile posicao;
		
		public int getCor() {
			return cor;
		}
		public void move(int n) {
			for (int i = 0;i<n;i++) {
				posicao = posicao.proximo;
			}
		}
}
