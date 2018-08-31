import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application{

    private static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        window = primaryStage;
        window.setTitle("Dots");
        window.getIcons().add(new Image("icon.png"));
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
