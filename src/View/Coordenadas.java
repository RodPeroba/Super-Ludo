package View;

import java.sql.Struct;

import Model.Cor;

public class Coordenadas {


  private int posicoesInicio[][] = new int[4][4];
  private int posicoesSaida[] = new int[4];

  public Coordenadas() {
    posicoesInicio[0][0] = 0;
    posicoesInicio[1][0] = 13;
    posicoesInicio[2][0] = 26;
    posicoesInicio[3][0] = 39;

    posicoesSaida[0] = 5;
    posicoesSaida[1] = 18;
    posicoesSaida[2] = 31;
    posicoesSaida[3] = 44;
  }

  public int getPosicaoInicio(Cor cor) {
    return posicoesInicio[cor.getValor()][0];
  };

  public int getPosicaoSaida(Cor cor) {
    return posicoesSaida[cor.getValor()];
  };
}
