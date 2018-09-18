import drawings.DrawBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class sGame{

    @FXML
    public AnchorPane paneBoard;
    @FXML
    private Label lScoreP1;
    @FXML
    private Label lScoreP2;

    @FXML
    public void draw_board(){
        DrawBoard.init(paneBoard, lScoreP1, lScoreP2);
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
}
