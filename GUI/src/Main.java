import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lists.Board;

import java.io.IOException;


public class Main extends Application{

    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setWidth(sScene.getWidth());
        window.setHeight(sScene.getHeight());
        window.setMinWidth(600);
        window.setMinHeight(700);
        window.setTitle("Dots");
        window.getIcons().add(new Image("resources/icon.png"));
        setScene("fxml/menu.fxml");
        Board.init(7, 7);
        window.show();
    }

    // Method used for switch fxml
     static void setScene(String scene_route) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(scene_route));
        Scene scene = new Scene(root);
        var width = window.getWidth();
        var height = window.getHeight();
        var fullscreen = window.isFullScreen();
        window.setScene(scene);

        // Sets the new scenes dimensions based on last one
        if (fullscreen) window.setFullScreen(true);
        else {
            window.setWidth(width);
            window.setHeight(height);
        }
    }

    static void setFullScreen(boolean value){
        window.setFullScreen(value);
    }

    // Method that ends the game
    static void close(){
        window.close();
        Platform.exit();
        //Servidor.exit();
        //Cliente.exit();
    }
}
