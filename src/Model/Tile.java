package Model;

import java.util.List;
import java.util.ArrayList;

public class Tile {
    private List<Peao> peoes = new ArrayList<Peao>(); // Lista que contém os peões posicionados na casa
    private Tile proximo;
    private String tipo; // Tipo da casa: "comum", "saida", "inicial", "abrigo", "retaFinal"

    public Tile(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEmpty() {
        return peoes.isEmpty();
    }

    public boolean isBarreira() {
        return peoes.size() == 2;
    }

    public boolean possuiUmPeao() {
        return peoes.size() == 1;
    }

    public void adicionaPeao(Peao peao) {
        peoes.add(peao);
    }
    
    public void removePeao(Peao peao) {
        peoes.remove(peao);
    }
    
    public void setProximo(Tile proximo) {
        this.proximo = proximo;
    }

    public Tile getProximo() {
        return this.proximo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean possuiPeaoDeOutraCor(Cor cor) {
        if (peoes.get(0).getCor() == cor) {
            return true;
        } else {
            return false;
        }
    }

    public Peao primeiroPeao() {
        return peoes.get(0);
    }

}
