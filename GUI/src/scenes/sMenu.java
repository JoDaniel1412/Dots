package scenes;

import javafx.fxml.FXML;

import java.io.IOException;

public class sMenu extends sScene {

    @Override
    void pressed_return() {
        MainInterface.close();
    }

    @FXML
    void pressed_play() throws IOException {
        MainInterface.setScene("fxml/play.fxml");
    }

    @FXML
    void pressed_settings() throws IOException {
        MainInterface.setScene("fxml/settings.fxml");
    }

    @FXML
    void pressed_devTest() throws IOException {
        MainInterface.setScene("fxml/game.fxml");
    }
}
