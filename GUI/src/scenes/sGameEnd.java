package scenes;

import client.Cliente;
import client.Commands;
import drawings.Dots;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.Servidor;

import java.io.IOException;

public class sGameEnd extends sScene {

    public static int p1Score = 0;
    public static int p2Score = 0;
    @FXML
    private Label lMessageDisplay;

    @Override
    void pressed_return() throws IOException {
        MainInterface.setScene("fxml/menu.fxml");
        MainInterface.setResizable();
        close();
        System.out.println(Servidor.State);
    }

    @FXML
    void pressed_next_game() throws IOException, InterruptedException {
        MainInterface.setScene("fxml/waiting.fxml");
        Commands.send_command("start");

    }
    @FXML
    public void initialize() {
        setLabelMessageDisplay();
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

    private void setLabelMessageDisplay(){
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

    private void close() throws IOException{
        Cliente.exit();
        Servidor.exit();
    }
}
