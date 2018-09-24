package scenes;

import client.Cliente;
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
    void doOnLoad() {
        System.out.println("action");
    }

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
        Servidor.init();
        Cliente.init(Servidor.ipAdress, Servidor.portI, Servidor.portO);
        Cliente.setTurn(true);
        MainInterface.setScene("fxml/game.fxml");
        //MainInterface.setResizable();
        Timer.init();
    }
}
