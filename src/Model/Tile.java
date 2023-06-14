package Model;
import java.util.List;
import java.util.ArrayList;

public class Tile {
    List<Peao> peoes = new ArrayList<Peao>(); // Lista que contém os peões posicionados na casa
    private Tile anterior;
    Tile proximo;
	

    public boolean isEmpty() {
        return peoes.isEmpty();
    }

    public void adicionaPeao(Peao peao) {
        peoes.add(peao);
    }
    
    public void removePeao(Peao peao) {
        peoes.remove(peao);
    }
    
    public void setAnterior(Tile anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Tile proximo) {
        this.proximo = proximo;
    }
}
