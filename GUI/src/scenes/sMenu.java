package scenes;

import client.Cliente;
import client.GameSettings;
import javafx.fxml.FXML;
import logic.Timer;
import server.Servidor;

import java.io.IOException;

public class sMenu extends sScene {

    @Override
    void pressed_return() {
        MainInterface.close();
    }

    @Override
    protected void initialize() throws IOException { }

    @FXML
    void pressed_play() {
        MainInterface.setScene("fxml/play.fxml");
    }

    @FXML
    void pressed_settings() {
        MainInterface.setScene("fxml/settings.fxml");
    }

    @FXML
    void pressed_devTest() throws IOException {
        Servidor.init(GameSettings.setGameSettings());
        Cliente.init(Servidor.ipAddress, Servidor.portI, Servidor.portO);
        Cliente.setTurn(true);
        MainInterface.setScene("fxml/game.fxml");
        //MainInterface.setResizable();
        Timer.init();
    }
}
