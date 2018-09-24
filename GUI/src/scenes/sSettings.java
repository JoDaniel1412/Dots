package scenes;

import javafx.fxml.FXML;

public class sSettings extends sScene {

    @Override
    void pressed_return()  {
        MainInterface.setScene("fxml/menu.fxml");
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
