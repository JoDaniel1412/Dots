import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class sMenu {

    // Variables
    static private int width = 500;
    static private int height = 500;

    // Methods
    public static Scene run() {

        // Tittle
        Label lTittle = new Label("Dots");

        // Buttons
        Button bPlay = new Button("Play");
        Button bSettings = new Button("Settings");
        Button bExit = new Button("Exit");

        bPlay.setOnAction(e -> Main.setScene(sPlay.run()));
        bSettings.setOnAction(e -> Main.setScene(sSettings.run()));
        bExit.setOnAction(e -> Main.close());

        // Layouts
        VBox vbLayout = new VBox();
        vbLayout.getChildren().addAll(bPlay, bSettings, bExit);
        vbLayout.setAlignment(Pos.CENTER);
        vbLayout.setSpacing(8);

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
        sMenu.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        sMenu.height = height;
    }

}
