package scenes;

import client.Commands;
import drawings.Dots;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class sGameEnd extends sScene {

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

    public void game_end(int p1Score, int p2Score){
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
            lMessageDisplay.setTextFill(Dots.bone_white);
        }
    }
}
