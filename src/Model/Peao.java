package Model;

import java.awt.Color;

public class Peao {

		protected Color cor;
		protected Tile posicao; // Talvez tirar isso, vai dar um problema de mismatch
		
		protected Peao(Color cor) {
			this.cor = cor;
		}
		
		public Color getCor() {
			return cor;
		}

}
