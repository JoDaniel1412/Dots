package drawings;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import lists.Board;
import lists.Node;
import logic.DotsInteraction;

/**
 * Class that handles all drawings in the sGame
 * @author José Acuña
 */
public class DrawBoard{

    public static DrawBoard draw;
    private AnchorPane paneBoard;
    private Label p1Score;
    private Label p2Score;

    public static void init(AnchorPane pane, Label p1Score, Label p2Score){
        draw = new DrawBoard();
        draw.paneBoard = pane;
        draw.p1Score = p1Score;
        draw.p2Score = p2Score;
        AnimationTimer drawer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw.check_lines();
            }
        };
        draw.draw_board();
        drawer.start();
    }

    /**
     * Class that draw a line between two Dots
     */
    public void check_lines(){
        if(Lines.line != null) {
            draw_line(Lines.line);
            draw.draw_board();
            Lines.line = null;
            set_scores();
        }
    }

    private void set_scores(){
        p1Score.setText(String.valueOf(DotsInteraction.getP1Score()));
        p2Score.setText(String.valueOf(DotsInteraction.getP2Score()));
    }

    /**
     * Class that draws the dots in the Anchor Pane
     */
    private void draw_board(){
        Board board = Board.getInstance();
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
                tmp.setDot(dot);
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


    /** Getters **/
    public AnchorPane getPaneBoard() {
        return paneBoard;
    }

    private double getPaneBoardWidth() {
        return paneBoard.getWidth();
    }

    private double getPaneBoardHeight() {
        return paneBoard.getHeight();
    }
}
