import javafx.fxml.FXML;
import java.io.IOException;

abstract class sScene {

    static int width = 700;
    static int height = 800;

    @FXML
    abstract void pressed_return() throws IOException;
}
