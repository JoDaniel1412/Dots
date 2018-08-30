import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

abstract class sSettings extends ScenesFormat{

    static Scene run() {

        // Tittle
        Label lTittle = new Label("Settings");
        lTittle.setId("bold-label-50");

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
}
