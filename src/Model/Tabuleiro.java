package Model;

public class Tabuleiro {
    private static final int TAMANHO_TABULEIRO = 52;
    private static final int TAMANHO_RETA_FINAL = 5;

    private final Tile[] tabuleiroBasico;
    private final Tile[] retaFinal;
    
    public Tabuleiro() {
        this.tabuleiroBasico = new Tile[TAMANHO_TABULEIRO];
        this.retaFinal = new Tile[TAMANHO_RETA_FINAL];
        povoaTabuleiro();
        conectaTilesTabuleiro();
    }
    
    private void povoaTabuleiro() {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            tabuleiroBasico[index] = new Tile("saida");
            index++;
            for (int j = 1; j < 8; j++) {
                tabuleiroBasico[index] = new Tile("comum");
                index++;
            }
            tabuleiroBasico[index] = new Tile("abrigo");
            index++;
            for (int k = 0; k < 3; k++) {
                tabuleiroBasico[index] = new Tile("comum");
                index++;
            }
        }

        for (int i = 0; i < 5; i++) {
            retaFinal[i] = new Tile("retaFinal");
        }
    }

    private void conectaTilesTabuleiro() {
        for(int i = 0; i < TAMANHO_TABULEIRO - 1; i++) {
            tabuleiroBasico[i].setProximo(tabuleiroBasico[i + 1]);
        }
        tabuleiroBasico[TAMANHO_TABULEIRO - 1].setProximo(tabuleiroBasico[0]);
    }

    public void adicionaPeao(Peao peao, int posicao) {
        tabuleiroBasico[posicao].adicionaPeao(peao);
    }
    
    public Tile getCasa(int casa, boolean isRetaFinal) {
        if (isRetaFinal) {
            return retaFinal[casa];
        }
        else {
            return tabuleiroBasico[casa];
        }
    }

    public Tile[] getTabuleiroBasico() {
        return tabuleiroBasico;
    }

    public Tile[] getRetaFinal() {
        return retaFinal;
    }
}
