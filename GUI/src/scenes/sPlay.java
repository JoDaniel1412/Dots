package scenes;

import client.Cliente;
import client.GameSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lists.Board;
import logic.Timer;
import server.Servidor;

import java.io.IOException;

public class sPlay extends sScene {

    /* Buttons to resize the Board*/
    @FXML
    private Button bBoardSize1;
    @FXML
    private Button bBoardSize2;
    @FXML
    private Button bBoardSize3;

    /* Buttons to set the time for the game */
    @FXML
    private Button bGameTime1;
    @FXML
    private Button bGameTime2;
    @FXML
    private Button bGameTime3;

    /* Text Fields to connect to Server */
    @FXML
    private TextField eIpAddress;
    @FXML
    private TextField ePort1;
    @FXML
    private TextField ePort2;


    /* Events */
    @Override
    void pressed_return() {
        MainInterface.setScene("fxml/menu.fxml");
    }

    @Override
    protected void initialize() throws IOException {

    }

    /**
     * Creates a new game initializing the Server and Client
     * @throws IOException if Server couldn't being initiated
     */
    @FXML
    void pressed_create() throws IOException {
        // Setups the Sockets
        Servidor.init(GameSettings.setGameSettings());
        Cliente.init(Servidor.ipAddress, Servidor.portI, Servidor.portO);
        Cliente.setTurn(true);
        MainInterface.setScene("fxml/waiting.fxml");
        //zMainInterface.setResizable();
    }

    /**
     * Joins to a game initializing the client
     */
    @FXML
    void pressed_search() {
        java.lang.String ip = eIpAddress.getText();
        java.lang.String port1 = ePort1.getText();
        java.lang.String port2 = ePort2.getText();
        if (ip != null && port1 != null && port2 != null) {
            Cliente.init(ip, Integer.parseInt(port1), Integer.parseInt(port2));
            Cliente.setTurn(false);
            MainInterface.setResizable();
            MainInterface.setScene("fxml/waiting.fxml");
        }
    }

    @FXML
    private void pressed_bBoardSize1(){
        bBoardSize1.getStyleClass().add("button-toggle");
        bBoardSize2.getStyleClass().remove("button-toggle");
        bBoardSize3.getStyleClass().remove("button-toggle");
        Board.getInstance().setBoardSize(5,5);
    }
    @FXML
    private void pressed_bBoardSize2(){
        bBoardSize1.getStyleClass().remove("button-toggle");
        bBoardSize2.getStyleClass().add("button-toggle");
        bBoardSize3.getStyleClass().remove("button-toggle");
        Board.getInstance().setBoardSize(7,7);
    }
    @FXML
    private void pressed_bBoardSize3(){
        bBoardSize1.getStyleClass().remove("button-toggle");
        bBoardSize2.getStyleClass().remove("button-toggle");
        bBoardSize3.getStyleClass().add("button-toggle");
        Board.getInstance().setBoardSize(9,9);
    }
    @FXML
    private void pressed_bGameTime1(){
        bGameTime1.getStyleClass().add("button-toggle");
        bGameTime2.getStyleClass().remove("button-toggle");
        bGameTime3.getStyleClass().remove("button-toggle");
        Timer.setTime_limit(120);
    }
    @FXML
    private void pressed_bGameTime2(){
        bGameTime1.getStyleClass().remove("button-toggle");
        bGameTime2.getStyleClass().add("button-toggle");
        bGameTime3.getStyleClass().remove("button-toggle");
        Timer.setTime_limit(240);
    }
    @FXML
    private void pressed_bGameTime3(){
        bGameTime1.getStyleClass().remove("button-toggle");
        bGameTime2.getStyleClass().remove("button-toggle");
        bGameTime3.getStyleClass().add("button-toggle");
        Timer.setTime_limit(360);
    }
}
