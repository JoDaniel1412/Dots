package scenes;

import javafx.fxml.FXML;

import java.io.IOException;

public class sSettings extends sScene {

    @Override
    void pressed_return()  {
        MainInterface.setScene("fxml/menu.fxml");
    }

    @Override
    protected void initialize() throws IOException {

    }

    @FXML
    void pressed_fullscreen(){
        MainInterface.setFullScreen();
    }

    @FXML
    void pressed_windowed(){
        MainInterface.setFullScreen();
    }
}
