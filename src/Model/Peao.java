package Model;

public class Peao {
    private Cor cor;
    private Tile posicao; 

    public Peao(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public Tile getPosicao() {
        return posicao;
    }

    public void setPosicao(Tile posicao) {
        this.posicao = posicao;
    }
}
