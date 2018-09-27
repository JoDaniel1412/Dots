package scenes;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class sSettings extends sScene {
@FXML
Slider volumeSlider;
private MediaPlayer mp;
private Media me;
    @Override
    void pressed_return()  {
        MainInterface.setScene("fxml/menu.fxml");
    }

    @Override
    protected void initialize() throws IOException {
        volumeSlider.setValue(2.5);
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
