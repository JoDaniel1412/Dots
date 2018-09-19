package drawings;

import client.Cliente;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
    public static Color p1Color = Dots.aqua_blue;
    public static Color p2Color = Dots.green_leaf;
    private AnchorPane paneBoard;
    private Label p1Score;
    private Label p2Score;
    private Label p1Turn;
    private Label p2Turn;


    public static void init(AnchorPane pane, Label p1Score, Label p2Score, Label p1Turn, Label p2Turn){
        draw = new DrawBoard();
        draw.paneBoard = pane;
        draw.p1Score = p1Score;
        draw.p2Score = p2Score;
        draw.p1Turn = p1Turn;
        draw.p2Turn = p2Turn;
        AnimationTimer drawer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw.check_lines();
                draw.set_scores();
                draw.check_turns();
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
        }
    }

    private void set_scores(){
        p1Score.setText(String.valueOf(DotsInteraction.getP1Score()));
        p2Score.setText(String.valueOf(DotsInteraction.getP2Score()));
    }

    private void check_turns(){
        if(Cliente.isTurn()){
            p1Turn.setOpacity(1.0);
            p2Turn.setOpacity(0.3);
            p1Turn.setTextFill(p1Color);
            p2Turn.setTextFill(Dots.bone_white);
        } else {
            p1Turn.setOpacity(0.3);
            p2Turn.setOpacity(1.0);
            p1Turn.setTextFill(Dots.bone_white);
            p2Turn.setTextFill(p2Color);
        }
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
