package scenes;

import client.Cliente;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.Servidor;

import java.io.IOException;

public class sWaiting extends sScene{

    @FXML
    public Label ipLabel;
    @FXML
    public Label portLabel1;
    @FXML
    public Label portLabel2;

    private static boolean game_started = false;

    public static void pressed_start() {
        AnimationTimer starter = new AnimationTimer() {
            @Override
            public void handle(long now) {
                MainInterface.setScene("fxml/game.fxml");
                stop();
                game_started = true;
            }
        };
        starter.start();
    }

    @FXML
    protected void initialize(){
        ipLabel.setText(Servidor.ipAddress);
        portLabel1.setText(java.lang.String.valueOf(Servidor.portI));
        portLabel2.setText(java.lang.String.valueOf(Servidor.portO));
    }

    @Override
    void pressed_return() throws IOException {
        MainInterface.setScene("fxml/play.fxml");
        MainInterface.setResizable();
        Cliente.exit();
        Servidor.exit();
    }

    public static boolean isGame_started() {
        return game_started;
    }
}
