import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lists.Board;
import scenes.MainInterface;
import scenes.sScene;

import java.io.IOException;


public class Main extends Application {

    public static Stage window;
    private static MainInterface mainInterface;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setWidth(sScene.getWidth());
        window.setHeight(sScene.getHeight());
        window.setMinWidth(700);
        window.setMinHeight(800);
        window.setTitle("Dots");
        window.getIcons().add(new Image("file:resources/icon.png"));
        mainInterface = new MainInterface(this);
        setScene();
        Board.init(7, 7);
        //Sound.play("resources/sounds/chill_day.wav", 1);
        window.show();

        // Event that closes the program
        window.setOnCloseRequest(event -> {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Method used for switch fxml
     public static void setScene() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(mainInterface.getScene()));
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

    public static void setFullScreen(){
        window.setFullScreen(!window.isFullScreen());
    }

    public static void setResizable(){
        window.setResizable(!window.isResizable());
    }

    // Method that ends the game
    public static void close() throws IOException{
        window.close();
        Platform.exit();
        System.exit(0);
    }
}
