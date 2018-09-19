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
    private Label lScoreP1;
    @FXML
    private Label lScoreP2;
    @FXML
    private Label lP1Turn;
    @FXML
    private Label lP2Turn;

    @FXML
    public void draw_board(){
        //lP1.setTextFill(DrawBoard.p1Color);
        //lP2.setTextFill(DrawBoard.p2Color);
        DrawBoard.init(paneBoard, lScoreP1, lScoreP2, lP1Turn, lP2Turn);
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
