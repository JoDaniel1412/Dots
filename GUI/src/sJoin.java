import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sJoin {

    // Settings
    static private int width = 500;
    static private int height = 500;

    public static Scene run(){
        //Tittle
        Label lTittle = new Label("Host Mode");

        //Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(8);

        //Host Label - constrains use (child, column, row)
        Label hostLabel = new Label("Host Ip");
        GridPane.setConstraints(hostLabel, 0, 0);

        //Host Input
        TextField hostInput = new TextField();
        hostInput.setPromptText("Example:192.145.123");
        GridPane.setConstraints(hostInput, 1, 0);

        //Password Label
        Label portLabel = new Label("Port:");
        GridPane.setConstraints(portLabel, 0, 1);

        //Port Input
        TextField portInput = new TextField();
        portInput.setPromptText("Example:25748");
        GridPane.setConstraints(portInput, 1, 1);

        //Create server
        Button ipButton = new Button("Join to the server");
        GridPane.setConstraints(ipButton, 1, 2);

        //Return button
        Button bExit = new Button("Exit");
        bExit.setOnAction(e -> Main.setScene(sPlay.run()));
        GridPane.setConstraints(ipButton, 1, 3);

        //Add everything to grid
        grid.getChildren().addAll(hostLabel, hostInput, portLabel, portInput, ipButton);

        Scene scene = new Scene(grid, 200, 200);

        // Layouts
        VBox vbLayout = new VBox();
        vbLayout.getChildren().addAll(hostLabel, hostInput,portLabel, portInput, ipButton,bExit);
        vbLayout.setAlignment(Pos.TOP_LEFT);
        vbLayout.setSpacing(8);

        HBox hbLayout = new HBox();
        hbLayout.getChildren().addAll(lTittle);
        hbLayout.setAlignment(Pos.CENTER_LEFT);
        vbLayout.setSpacing(8);

        BorderPane bpLayout = new BorderPane();
        bpLayout.setCenter(vbLayout);
        bpLayout.setTop(hbLayout);

        return new Scene(bpLayout, width, height);
    }
}
