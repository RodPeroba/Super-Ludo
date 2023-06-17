package Model;
import java.util.List;
import java.util.ArrayList;

public class Tile {
	//Objeto para compor o tabuleiro
	public List<Peao> peoes = new ArrayList<Peao>(); //Lista que contem os peoes posicionados na casa
	Tile anterior;
	Tile proximo;
	
	boolean isEmpty() {
		if (peoes.isEmpty()) {
			return true;
		}
		return false;
	}
}
