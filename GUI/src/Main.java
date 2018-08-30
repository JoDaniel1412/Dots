import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application{

    private static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Dots");
        Image icon = new Image("resources/noun_dots.png");
        window.getIcons().add(icon);
        setScene(sMenu.run());
        window.show();
    }

    // Method used for switch scenes
    static void setScene(Scene scene) {
        window.setScene(scene);
        window.getScene().getStylesheets().add("resources/Dark.css");
    }

    // Method that ends the game
    static void close(){
        window.close();
    }
}
