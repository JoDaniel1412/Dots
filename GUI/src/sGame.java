import drawings.Dots;
import drawings.DrawBoard;
import drawings.Lines;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import lists.Board;
import lists.Node;
import javafx.scene.canvas.Canvas;

import java.awt.*;

public class sGame extends Thread{

    @FXML
    public AnchorPane paneBoard;

    @FXML
    public void draw_board(){
        DrawBoard.init(paneBoard);
    }
}
