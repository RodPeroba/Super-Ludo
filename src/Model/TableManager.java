package Model;

import java.util.List;
import java.util.ArrayList;

public class TableManager {
    private static TableManager instance;
    private Tabuleiro tabuleiro;
    private List<Peao> peoes;

    public TableManager() {
        tabuleiro = new Tabuleiro();
        peoes = new ArrayList<>();
        criaPeoes();
    }

    public static TableManager getInstance() {
        if (instance == null) {
            instance = new TableManager();
        }
        return instance;
    }

    private void criaPeoes() {
        for (Cor cor : Cor.values()) {
            for (int i = 0; i < 4; i++) {
                Peao peao = new Peao(cor);
                peoes.add(peao);
                tabuleiro.adicionaPeao(peao, cor.getCasaDeSaida());
            }
        }
    }

    public boolean movimentaPeao(Peao peao, int casas) {
        Tile casaAtual = peao.getPosicao();

        for (int i = 0; i < casas; i++) {
            casaAtual = casaAtual.getProximo();
            if (casaAtual.isBarreira()) {
                return true;
            }

            casaAtual.adicionaPeao(peao);
        }

        if (casaAtual.getTipo().equals("comum") && casaAtual.possuiPeaoDeOutraCor(peao.getCor())) {
            casaAtual.removePeao(casaAtual.primeiroPeao());
        }
        return true;
    }
}
