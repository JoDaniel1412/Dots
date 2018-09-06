import javafx.fxml.FXML;
import java.io.IOException;

public class sMenu extends sScene {

    @Override
    void pressed_return() {
        Main.close();
    }

    @FXML
    void pressed_play() throws IOException {
        Main.setScene("scenes/play.fxml");
    }

    @FXML
    void pressed_settings() throws IOException {
        Main.setScene("scenes/settings.fxml");
    }
}
