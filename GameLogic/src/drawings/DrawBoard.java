package drawings;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import lists.Board;
import lists.Node;

/**
 * Class that handles all drawings in the sGame
 * @author José Acuña
 */
public class DrawBoard{

    private AnchorPane paneBoard;
    public static DrawBoard draw;

    public static void init(AnchorPane pane){
        draw = new DrawBoard();
        draw.paneBoard = pane;
        draw.draw_board();
    }

    /**
     * Class that draw a line between two Dots
     */
    public void check_lines(){
        draw_line(Lines.line);
        draw_board();
    }

    /**
     * Class that draws the dots in the Anchor Pane
     */
    private void draw_board(){
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

    /**
     * Draws a line in the Anchor Pane
     * @param line a class Line shape
     */
    private void draw_line(Line line){
        paneBoard.getChildren().addAll(line);
    }

    private double getPaneBoardWidth() {
        return paneBoard.getWidth();
    }

    private double getPaneBoardHeight() {
        return paneBoard.getHeight();
    }
}