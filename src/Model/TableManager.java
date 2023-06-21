package Model;

import java.util.List;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class TableManager implements Serializable {
    private static final int NUMERO_JOGADORES = 4;
    private static TableManager instance;
    private Tabuleiro tabuleiro;
    private Peao[] peoes;
    private int jogadorDaVez;
    // private enum posInicial {VERDE(x: 0, y: 0), AMARELO, AZUL, VERMELHO};

    private TableManager() {
        tabuleiro = new Tabuleiro();
    }
    
    public static TableManager getInstance() {
        if (instance == null) {
            instance = new TableManager();
        }
        return instance;
    }
    
    
    public void iniciaPartida() {
        tabuleiro.getTabuleiroBasico();
        tabuleiro.getInicioVerde();
        tabuleiro.getInicioAmarelo();
        tabuleiro.getInicioAzul();
        tabuleiro.getInicioVermelho();
        tabuleiro.getRetaFinalVerde();
        tabuleiro.getRetaFinalAmarela();
        tabuleiro.getRetaFinalAzul();
        tabuleiro.getRetaFinalVermelha();
        Dado.getDado();
        
        peoes = new Peao[NUMERO_JOGADORES * 4];

        // for (Cor cor : Cor.values()) {
        //     peoes[i] = new Peao(cor, )
        // }

        // for (int i=0; i<NUMERO_JOGADORES * 4; i++) {
        //     peoes[i] = new Peao(COR);
        // }



        if (jogadorDaVez < 0 ) {
            this.jogadorDaVez = new Random().nextInt(4);
        }
    }

    public void criaPeoes() {
        for (int i = 0; i < 4; i++) {
            tabuleiro.getInicioVerde()[i].adicionaPeao(new Peao(Cor.VERDE, tabuleiro.getInicioVerde()[i]));
            tabuleiro.getInicioAmarelo()[i].adicionaPeao(new Peao(Cor.AMARELO, tabuleiro.getInicioAmarelo()[i]));
            tabuleiro.getInicioAzul()[i].adicionaPeao(new Peao(Cor.AZUL, tabuleiro.getInicioAzul()[i]));
            tabuleiro.getInicioVermelho()[i].adicionaPeao(new Peao(Cor.VERMELHO, tabuleiro.getInicioVermelho()[i]));
        }
    }

    public boolean validaMovimento(Peao peao, int casas) {
    Tile tileAtual = peao.getPosicao();
    Tile tileDestino = tileAtual;

    if (tileAtual.isBarreira()) {
    for (int i = 0; i < casas; i++) {
        tileDestino = tileAtual.getProximo();
        if (tileDestino.isBarreira()) {
            return false;
        }
    }
    if ((tileDestino.getTipo().equals("abrigo") || tileDestino.getTipo().equals("saida")) && tileDestino.getNumeroDePeoes() > 1) {
        return false;
    }

    } else {
        for (int i = 0; i < casas; i++) {
            tileDestino = tileAtual.getProximo();
        }
    }

    if (tileDestino == null) {
        // O movimento é inválido se o peão tentar mover-se para fora do tabuleiro.
        return false;
    }

    return true;
}


    public boolean movimentaPeao(Peao peao, int casas) {
        if (!validaMovimento(peao, casas)) {
            return false;
        }
        Tile casaAtual = peao.getPosicao();
        Tile proximaCasa = casaAtual.getProximo();

        for (int i = 0; i < casas; i++) {
            switch (peao.getCor()) {
                case VERDE:
                    if (casaAtual.getIndice() == 50) {
                        proximaCasa = tabuleiro.getInicioVerde()[0];
                    }
                    break;

                case AMARELO:
                    if (casaAtual.getIndice() == 11) {
                        proximaCasa = tabuleiro.getInicioAmarelo()[0];
                    }
                    break;

                case AZUL:
                    if (casaAtual.getIndice() == 24) {
                        proximaCasa = tabuleiro.getInicioAzul()[0];
                    }
                    break;

                case VERMELHO:
                    if (casaAtual.getIndice() == 37) {
                        proximaCasa = tabuleiro.getInicioVermelho()[0];
                    }
                    break;
            }

        
            if (proximaCasa.isBarreira()) {
                return true;
            }
            casaAtual.removePeao(peao);
            proximaCasa.adicionaPeao(peao);
            casaAtual = proximaCasa;
            proximaCasa = casaAtual.getProximo();
        }


        if (casaAtual.getTipo().equals("comum") && casaAtual.possuiPeaoDeOutraCor(peao.getCor())) {
            Peao peaoCapturado = casaAtual.primeiroPeao();
            casaAtual.removePeao(peaoCapturado);
            tabuleiro.voltaPeaoInicio(peaoCapturado);
        }
        return true;
    }

    public int[] getPosicaoJogadores() {
        int posicoes[] = new int[NUMERO_JOGADORES];
        for (int i=0; i<NUMERO_JOGADORES; i++) {
			// posicoes[i] = peoes[i];
		}
		return posicoes;
    }
    
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println(this.tabuleiro);
            out.writeObject(this.tabuleiro);
        }
    }
}
