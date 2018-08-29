import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    private static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Dots");
        setScene(sMenu.run());
        window.show();
    }

    // Method used for switch scenes
    public static void setScene(Scene scene) {
        window.setScene(scene);
        window.getScene().getStylesheets().add("Dark.css");
    }

    // Method that ends the game
    public static void close(){
        window.close();
    }
}
