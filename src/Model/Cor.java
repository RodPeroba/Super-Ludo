package Model;

public enum Cor {
    AZUL(0, 0), VERMELHO(1, 13), AMARELO(2, 26), VERDE(3, 39);

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
