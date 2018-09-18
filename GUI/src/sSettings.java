import javafx.fxml.FXML;

import java.io.IOException;

public class sSettings extends sScene {

    @Override
    void pressed_return() throws IOException {
        Main.setScene("fxml/menu.fxml");
    }

    @FXML
    void pressed_fullscreen(){
        Main.setFullScreen(true);
    }

    @FXML
    void pressed_windowed(){
        Main.setFullScreen(false);
    }
}
