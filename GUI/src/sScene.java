import javafx.fxml.FXML;
import java.io.IOException;

abstract class sScene {

    private static int width = 700;
    private static int height = 800;

    @FXML
    abstract void pressed_return() throws IOException;

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        sScene.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        sScene.height = height;
    }
}
