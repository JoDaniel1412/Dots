package scenes;

import javafx.fxml.FXML;

import java.io.IOException;

public abstract class sScene {

    private static int width = 700;
    private static int height = 700;

    @FXML
    abstract void pressed_return() throws IOException;

    public static int getWidth() {
        return width;
    }

    static void setWidth(int width) {
        sScene.width = width;
    }

    public static int getHeight() {
        return height;
    }

    static void setHeight(int height) {
        sScene.height = height;
    }
}
