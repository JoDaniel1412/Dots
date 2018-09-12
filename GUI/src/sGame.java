import drawings.Dots;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import lists.Node;
import javafx.scene.canvas.Canvas;

public class sGame {

    @FXML
    private AnchorPane paneBoard;

    @FXML
    public void draw_board(){
        Dots dot = new Dots(10,10, new Node());
        paneBoard.getChildren().addAll(dot.getDot());
    }
}
