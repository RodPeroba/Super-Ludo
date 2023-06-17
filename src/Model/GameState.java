package Model;

import java.io.*;

public class GameState implements Serializable {
    // Campos para o estado do jogo, por exemplo:
    private Tabuleiro tabuleiro;
    private Peao[] peoes;
    // etc...

    // Métodos para salvar e carregar o estado do jogo:
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        }
    }

    public static GameState loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (GameState) in.readObject();
        }
    }
}
