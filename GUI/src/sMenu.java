import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


abstract class sMenu extends ScenesFormat{

    // Methods
    static Scene run() {

        // Tittle
        Label lTittle = new Label("Dots");
        lTittle.setId("bold-label-150");

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
        vbLayout.setSpacing(12);

        HBox hbLayout = new HBox();
        hbLayout.getChildren().addAll(lTittle);
        hbLayout.setAlignment(Pos.CENTER);

        BorderPane bpLayout = new BorderPane();
        bpLayout.setCenter(vbLayout);
        bpLayout.setTop(hbLayout);

        return new Scene(bpLayout, width, height);
    }
}
