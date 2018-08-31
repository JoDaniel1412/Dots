import java.io.IOException;

public class sPlay extends sScene{

    @Override
    void pressed_return() throws IOException {
        Main.setScene("scenes/main.fxml");
    }
}
