package Controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import Model.GameState;

public class GameController {
    private GameState gameState;
    // ...
    public void saveGame() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                gameState.saveToFile(file.getPath());
            } catch (IOException e) {
                // handle exception
            }
        }
    }

    public void loadGame() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                gameState = GameState.loadFromFile(file.getPath());
            } catch (IOException | ClassNotFoundException e) {
                // handle exception
            }
        }
    }
}
