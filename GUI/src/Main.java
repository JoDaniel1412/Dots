import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application{

    private static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setResizable(false);
        window.setTitle("Dots");
        window.getIcons().add(new Image("icon.png"));
        setScene("scenes/main.fxml");
        window.show();
    }

    // Method used for switch scenes
    static void setScene(String scene) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(scene));
        window.setScene(new Scene(root));
    }

    // Method that ends the game
    static void close(){
        window.close();
    }
}
