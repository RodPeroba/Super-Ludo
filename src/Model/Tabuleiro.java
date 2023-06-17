package Model;

public class Tabuleiro {
    private static final int TAMANHO_TABULEIRO = 52;
    private static final int TAMANHO_RETA_FINAL = 6;

    private final Tile[] tabuleiroBasico;
    private final Tile[] retaFinalVerde;
    private final Tile[] retaFinalAmarela;
    private final Tile[] retaFinalAzul;
    private final Tile[] retaFinalVermelha;

    
    public Tabuleiro() {
        this.tabuleiroBasico = new Tile[TAMANHO_TABULEIRO];
        this.retaFinalVerde = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAmarela = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAzul = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalVermelha = new Tile[TAMANHO_RETA_FINAL];
        povoaTabuleiro();
        conectaTilesTabuleiro();
    }
    
    private void povoaTabuleiro() {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            tabuleiroBasico[index] = new Tile("saida", index);
            index++;
            for (int j = 0; j < 8; j++) {
                tabuleiroBasico[index] = new Tile("comum", index);
                index++;
            }
            tabuleiroBasico[index] = new Tile("abrigo", index);
            index++;
            for (int j = 0; j < 3; j++) {
                tabuleiroBasico[index] = new Tile("comum", index);
                index++;
            }
        }

        for (int i = 0; i < 5; i++) {
            retaFinalVerde[i] = new Tile("retaFinal", i);
            retaFinalAmarela[i] = new Tile("retaFinal", i);
            retaFinalAzul[i] = new Tile("retaFinal", i);
            retaFinalVermelha[i] = new Tile("retaFinal", i);
        }
    }

    private void conectaTilesTabuleiro() {
        for(int i = 0; i < TAMANHO_TABULEIRO - 1; i++) {
            tabuleiroBasico[i].setProximo(tabuleiroBasico[i + 1]);
        }
        tabuleiroBasico[TAMANHO_TABULEIRO - 1].setProximo(tabuleiroBasico[0]);

         for(int i = 0; i < TAMANHO_RETA_FINAL - 1; i++) {
            retaFinalVerde[i].setProximo(retaFinalVerde[i + 1]);
            retaFinalAmarela[i].setProximo(retaFinalAmarela[i + 1]);
            retaFinalAzul[i].setProximo(retaFinalAzul[i + 1]);
            retaFinalVermelha[i].setProximo(retaFinalVermelha[i + 1]);
        }
    }

    public void adicionaPeao(Peao peao, int posicao) {
        tabuleiroBasico[posicao].adicionaPeao(peao);
    }
    

    public Tile[] getTabuleiroBasico() {
        return tabuleiroBasico;
    }

    public Tile[] getRetaFinalVerde() {
        return retaFinalVerde;
    }

        public Tile[] getRetaFinalAmarela() {
        return retaFinalAmarela;
    }
        public Tile[] getRetaFinalAzul() {
        return retaFinalAzul;
    }
        public Tile[] getRetaFinalVermelha() {
        return retaFinalVermelha;
    }
}
