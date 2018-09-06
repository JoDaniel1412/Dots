import javafx.fxml.FXML;
import java.io.IOException;

abstract class sScene {

    private static int width = 700;
    private static int height = 800;

    @FXML
    abstract void pressed_return() throws IOException;

    static int getWidth() {
        return width;
    }

    static void setWidth(int width) {
        sScene.width = width;
    }

    static int getHeight() {
        return height;
    }

    static void setHeight(int height) {
        sScene.height = height;
    }
}
