package Model;

public enum Cor {
    VERDE(0, 0), AMARELO(1, 13), AZUL(2, 26), VERMELHO(3, 39);

    private final int valor;
    private final int casaDeSaida;

    Cor(int valor, int casaDeSaida) {
        this.valor = valor;
        this.casaDeSaida = casaDeSaida;
    }

    public int getValor() {
        return valor;
    }

    public int getCasaDeSaida() {
        return casaDeSaida;
    }
}
