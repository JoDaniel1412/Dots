import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class sPlay {

    public static Scene run() {

        // Tittle
        Label lTittle = new Label("Play");

        // Buttons
        Button bReturn = new Button("Return");
        Button bSettings = new Button("Settings");


        // Layout
        VBox vbMenu = new VBox(50);
        vbMenu.getChildren().addAll(lTittle, bReturn,bSettings);
        return new Scene(vbMenu, 300, 400);
    }
}
