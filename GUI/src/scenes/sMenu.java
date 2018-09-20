package scenes;

import client.Cliente;
import javafx.fxml.FXML;
import server.Servidor;

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
        Servidor.init();
        Cliente.init(Servidor.ipAdress, Servidor.portI, Servidor.portO);
        Cliente.setTurn(true);
        MainInterface.setScene("fxml/game.fxml");
        MainInterface.setResizable();
    }
}
