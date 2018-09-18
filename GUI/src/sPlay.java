import client.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    void pressed_return() throws IOException {
        Main.setScene("fxml/menu.fxml");
    }
    @FXML
    void pressed_create() throws IOException {
        Servidor.init();
        Cliente.init(Servidor.ipAdress, Servidor.portI, Servidor.portO);
        Main.setScene("fxml/game.fxml");
        Main.window.setResizable(false);
    }
    @FXML
    void pressed_search() throws IOException {
        String ip = eIpAddress.getText();
        String port1 = ePort1.getText();
        String port2 = ePort2.getText();
        System.out.println(port1);
        if (ip != null && port1 != null && port2 != null) {
            Cliente.init(ip, Integer.parseInt(port1), Integer.parseInt(port2));
            Main.setScene("fxml/game.fxml");
            Main.window.setResizable(false);
        }
    }
    @FXML
    private void pressed_bBoardSize1(){
        bBoardSize1.getStyleClass().add("button-toggle");
        bBoardSize2.getStyleClass().remove("button-toggle");
        bBoardSize3.getStyleClass().remove("button-toggle");
    }
    @FXML
    private void pressed_bBoardSize2(){
        bBoardSize1.getStyleClass().remove("button-toggle");
        bBoardSize2.getStyleClass().add("button-toggle");
        bBoardSize3.getStyleClass().remove("button-toggle");
    }
    @FXML
    private void pressed_bBoardSize3(){
        bBoardSize1.getStyleClass().remove("button-toggle");
        bBoardSize2.getStyleClass().remove("button-toggle");
        bBoardSize3.getStyleClass().add("button-toggle");
    }
    @FXML
    private void pressed_bGameTime1(){
        bGameTime1.getStyleClass().add("button-toggle");
        bGameTime2.getStyleClass().remove("button-toggle");
        bGameTime3.getStyleClass().remove("button-toggle");
    }
    @FXML
    private void pressed_bGameTime2(){
        bGameTime1.getStyleClass().remove("button-toggle");
        bGameTime2.getStyleClass().add("button-toggle");
        bGameTime3.getStyleClass().remove("button-toggle");
    }
    @FXML
    private void pressed_bGameTime3(){
        bGameTime1.getStyleClass().remove("button-toggle");
        bGameTime2.getStyleClass().remove("button-toggle");
        bGameTime3.getStyleClass().add("button-toggle");
    }
}
