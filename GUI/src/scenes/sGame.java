package scenes;

import drawings.DrawBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class sGame{

    @FXML
    public AnchorPane paneBoard;
    @FXML
    private Label lP1;
    @FXML
    private Label lP2;
    @FXML
    public Label lScoreP1;
    @FXML
    public Label lScoreP2;
    @FXML
    public Label lP1Turn;
    @FXML
    public Label lP2Turn;
    @FXML
    public Label lClock;

    @FXML
    public void initialize() {
        DrawBoard.init(this);
    }

    /** Getters and Setters **/
    public Label getlScoreP1() {
        return lScoreP1;
    }

    public Label getlScoreP2() {
        return lScoreP2;
    }

    public void setlScorep1(Label lScoreP1) {
        this.lScoreP1 = lScoreP1;
    }

    public void setlScorep2(Label lScoreP2) {
        this.lScoreP2 = lScoreP2;
    }

    public Label getlClock() {
        return lClock;
    }

    public void setlClock(Label lClock) {
        this.lClock = lClock;
    }
}
