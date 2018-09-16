import drawings.Dots;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import lists.Board;
import lists.Node;
import javafx.scene.canvas.Canvas;

import java.awt.*;

public class sGame {

    @FXML
    private AnchorPane paneBoard;

    @FXML
    public void draw_board(){
        Board board = Board.init(4, 4);
        Node tmp;
        var rows = board.getRows();
        var columns = board.getColumns();
        double xOffset = getPaneBoardWidth() / (columns + 1);
        double yOffset = getPaneBoardHeight() / (rows + 1);
        int i = 0, j = 0;

        var yPoss = yOffset;
        while (i < rows) {
            var xPoss = xOffset;
            while (j < columns) {
                tmp = board.getIndex(i, j);
                Dots dot = new Dots(xPoss, yPoss, tmp);
                paneBoard.getChildren().addAll(dot.getDot());
                xPoss += xOffset;
                j++;
            }
            yPoss += yOffset;
            j = 0;
            i++;
        }
    }

    private double getPaneBoardWidth() {
        return paneBoard.getWidth();
    }

    private double getPaneBoardHeight() {
        return paneBoard.getHeight();
    }
}