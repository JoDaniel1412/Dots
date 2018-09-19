package scenes;

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

    @FXML
    public void init(){
        ipLabel.setText(Servidor.ipAdress);
        portLabel1.setText(String.valueOf(Servidor.portI));
        portLabel2.setText(String.valueOf(Servidor.portO));
    }
}
