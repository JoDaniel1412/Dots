import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.Servidor;

public class sWaiting {

    @FXML
    public Label ipLabel;

    @FXML
    public Label portLabel;

    public sWaiting(){
        ipLabel.setText(Servidor.ipAdress);
        portLabel.setText(String.valueOf(Servidor.portI));
    }
}
