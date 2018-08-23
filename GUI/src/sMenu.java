import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class sMenu {

    public static Scene run() {

        // Tittle
        Label lTittle = new Label("Dots");

        // Buttons
        Button bPlay = new Button("Play");
        Button bSettings = new Button("Settings");

        bPlay.setOnAction(e -> Main.setScene(sPlay.run()));

        // Layout
        VBox vbMenu = new VBox(50);
        vbMenu.getChildren().addAll(lTittle, bPlay,bSettings);
        return new Scene(vbMenu, 300, 400);
    }


}
