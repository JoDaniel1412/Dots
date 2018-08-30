import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class sPlay {

    // Settings
    static private int width = 700;
    static private int height = 800;

    public static Scene run() {

        // Tittle
        Label lTittle = new Label("Play");
        lTittle.setId("bold-label-50");


        // Buttons
        Button bHost = new Button("Host Game");
        Button bJoin = new Button("Join Game");
        Button bReturn = new Button("Return");

        bReturn.setOnAction(e -> Main.setScene(sMenu.run()));
        bJoin.setOnAction(e -> Main.setScene(sJoin.run()));


        // Layouts
        VBox vbLayout = new VBox();
        vbLayout.getChildren().addAll(bHost, bJoin, bReturn);
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
        sPlay.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        sPlay.height = height;
    }
}
