import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.Servidor;

public class sWaiting {

    @FXML
    public Label ipLabel;

    @FXML
    public Label portLabel;

    @FXML
    public void init(){
        ipLabel.setText(Servidor.ipAdress);
        portLabel.setText(String.valueOf(Servidor.portO));
    }
}
