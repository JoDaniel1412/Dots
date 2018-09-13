import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class sPlay extends sScene{

    @FXML
    private Button bBoardSize1;

    @FXML
    private Button bBoardSize2;

    @FXML
    private Button bBoardSize3;

    @FXML
    private void pressed_bBoardSize1(){

    }

    @Override
    void pressed_return() throws IOException {
        Main.setScene("scenes/menu.fxml");
    }

    @FXML
    void pressed_setGridSize(){

    }

    @FXML
    void pressed_start() throws IOException {
        Main.setScene("scenes/game.fxml");
        Main.window.setResizable(false);
    }
}
