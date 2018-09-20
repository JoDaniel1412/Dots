package scenes;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.Servidor;

public class sWaiting {

    @FXML
    public Label ipLabel;
    @FXML
    public Label portLabel1;
    @FXML
    public Label portLabel2;

    public static void pressed_start() {
        AnimationTimer starter = new AnimationTimer() {
            @Override
            public void handle(long now) {
                MainInterface.setScene("fxml/game.fxml");
                stop();
            }
        };
        starter.start();
    }

    @FXML
    public void init(){
        ipLabel.setText(Servidor.ipAdress);
        portLabel1.setText(String.valueOf(Servidor.portI));
        portLabel2.setText(String.valueOf(Servidor.portO));
    }
}
