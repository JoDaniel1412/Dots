package scenes;

import client.String;
import client.Commands;
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
    void doOnLoad() {

    }

    @FXML
    void pressed_create() throws IOException{
        Servidor.init();
        String.init(Servidor.ipAdress, Servidor.portI, Servidor.portO);
        String.setTurn(true);
        MainInterface.setScene("fxml/waiting.fxml");
        MainInterface.setResizable();
    }
    @FXML
    void pressed_search() throws IOException, InterruptedException {
        java.lang.String ip = eIpAddress.getText();
        java.lang.String port1 = ePort1.getText();
        java.lang.String port2 = ePort2.getText();
        if (ip != null && port1 != null && port2 != null) {
            String.init(ip, Integer.parseInt(port1), Integer.parseInt(port2));
            String.setTurn(false);
            MainInterface.setResizable();
            MainInterface.setScene("fxml/waiting.fxml");
            Commands.send_command("start");
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
