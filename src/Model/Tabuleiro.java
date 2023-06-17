package Model;

public class Tabuleiro {
    private static final int TAMANHO_TABULEIRO = 52;
    private static final int TAMANHO_RETA_FINAL = 6;

    private final Tile[] tabuleiroBasico;
    private final Tile[] inicioVerde;
    private final Tile[] inicioAmarelo;
    private final Tile[] inicioAzul;
    private final Tile[] inicioVermelho;
    private final Tile[] retaFinalVerde;
    private final Tile[] retaFinalAmarela;
    private final Tile[] retaFinalAzul;
    private final Tile[] retaFinalVermelha;

    
    public Tabuleiro() {
        this.tabuleiroBasico = new Tile[TAMANHO_TABULEIRO];
        this.inicioVerde = new Tile[4];
        this.inicioAmarelo = new Tile[4];
        this.inicioAzul = new Tile[4];
        this.inicioVermelho = new Tile[4];
        this.retaFinalVerde = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAmarela = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAzul = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalVermelha = new Tile[TAMANHO_RETA_FINAL];
        povoaTabuleiro();
        conectaTilesTabuleiro();
    }
    
    private void povoaTabuleiro() {
        for (int i = 0; i < 4; i++) {
            inicioVerde[i] = new Tile("inicial", i);
            inicioAmarelo[i] = new Tile("inicial", i);
            inicioAzul[i] = new Tile("inicial", i);
            inicioVermelho[i] = new Tile("inicial", i);
        }

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
        for (int i = 0; i < 3; i++) {
            inicioVerde[i].setProximo(inicioVerde[i + 1]);
            inicioAmarelo[i].setProximo(inicioAmarelo[i + 1]);
            inicioAzul[i].setProximo(inicioAzul[i + 1]);
            inicioVermelho[i].setProximo(inicioVermelho[i + 1]);
        }
        inicioVerde[3].setProximo(null);
        inicioAmarelo[3].setProximo(null);
        inicioAzul[3].setProximo(null);
        inicioVermelho[3].setProximo(null);

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

    // Remove um peão da casa inicial e o posiciona da casa de saída
    public void soltaPeao(Peao peao) {
        peao.getPosicao().removePeao(peao);
        tabuleiroBasico[peao.getCor().getCasaDeSaida()].adicionaPeao(peao);
    }

    public Tile[] getInicioVerde() {
        return inicioVerde;
    }

    public Tile[] getInicioAmarelo() {
        return inicioAmarelo;
    }

    public Tile[] getInicioAzul() {
        return inicioAzul;
    }

    public Tile[] getInicioVermelho() {
        return inicioVermelho;
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

    public void voltaPeaoInicio(Peao peao) {
        Cor cor = peao.getCor();

        switch (cor) {
            case VERDE:
                for (int i = 4; i > 0; i--) {
                    if (inicioVerde[i].isEmpty()) {
                        inicioVerde[i].adicionaPeao(peao);
                        break;
                    }
                }
                break;
            case AMARELO:
                for (int i = 4; i > 0; i--) {
                    if (inicioAmarelo[i].isEmpty()) {
                        inicioAmarelo[i].adicionaPeao(peao);
                        break;
                    }
                }
                break;
            
            case AZUL:
                for (int i = 4; i > 0; i--) {
                    if (inicioAzul[i].isEmpty()) {
                        inicioAzul[i].adicionaPeao(peao);
                        break;
                    }
                }
                break;

            case VERMELHO:
                for (int i = 4; i > 0; i--) {
                    if (inicioVermelho[i].isEmpty()) {
                        inicioVermelho[i].adicionaPeao(peao);
                        break;
                    }
                }
                break;
        }
    }
}
