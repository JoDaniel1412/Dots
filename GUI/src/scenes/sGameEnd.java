package scenes;

import client.Commands;
import drawings.Dots;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class sGameEnd extends sScene {

    public static int p1Score = 0;
    public static int p2Score = 0;
    @FXML
    private Label lMessageDisplay;

    @Override
    void pressed_return() {
        MainInterface.setScene("fxml/menu.fxml");
        MainInterface.setResizable();
    }

    @FXML
    void pressed_next_game() throws IOException, InterruptedException {
        MainInterface.setScene("fxml/waiting.fxml");
        Commands.send_command("start");

    }

    public static void game_end(){
        AnimationTimer scene = new AnimationTimer() {
            @Override
            public void handle(long now) {
                MainInterface.setScene("fxml/game_end.fxml");

                stop();
            }
        };
        scene.start();
    }

    @FXML
    void setlMessageDisplay(){
        if(p1Score > p2Score){
            lMessageDisplay.setText("You Win!");
            lMessageDisplay.setTextFill(Dots.green_leaf);
        }
        else if(p2Score > p1Score){
            lMessageDisplay.setText("You Lose");
            lMessageDisplay.setTextFill(Dots.dark_red);
        }
        else {
            lMessageDisplay.setText("Draw");
        }
    }
}
