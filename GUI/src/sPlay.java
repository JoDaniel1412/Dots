import javafx.fxml.FXML;

import java.io.IOException;

public class sPlay extends sScene{

    @Override
    void pressed_return() throws IOException {
        Main.setScene("scenes/menu.fxml");
    }

    @FXML
    void pressed_setGridSize(int rows, int columns){
        System.out.printf("%d %d", rows, columns);
    }

    @FXML
    void pressed_start() throws IOException {
        Main.setScene("scene/game.fxml");
    }
}
