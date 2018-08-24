import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sSettings {

    // Settings
    static private int width = 500;
    static private int height = 500;

    public static Scene run() {

        // Tittle
        Label lTittle = new Label("Settings");

        // Buttons
        Button bReturn = new Button("Return");

        bReturn.setOnAction(e -> Main.setScene(sMenu.run()));

        // Layouts
        VBox vbLayout = new VBox();
        vbLayout.getChildren().addAll(bReturn);
        vbLayout.setAlignment(Pos.CENTER);

        HBox hbLayout = new HBox();
        hbLayout.getChildren().addAll(lTittle);
        hbLayout.setAlignment(Pos.CENTER);

        BorderPane bpLayout = new BorderPane();
        bpLayout.setCenter(vbLayout);
        bpLayout.setTop(hbLayout);

        return new Scene(bpLayout, width, height);
    }

    // Getters and Setters
    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        sSettings.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        sSettings.height = height;
    }

}
