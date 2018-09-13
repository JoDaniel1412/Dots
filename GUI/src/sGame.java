import drawings.Dots;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import lists.Board;
import lists.Node;
import javafx.scene.canvas.Canvas;

public class sGame {

    @FXML
    private AnchorPane paneBoard;

    @FXML
    public void draw_board(){
        Board board = Board.init(4, 4);
        Node head = board.getBoardHead();
        Node tmp = head;
        double radius = Dots.radius;
        var rows = board.getRows();
        var columns = board.getColumns();
        double xOffset = getPaneBoardWidth() / (columns + 1);
        double yOffset = getPaneBoardHeight() / (rows + 1);
        int i = 0, j = 0;

        var yPoss = yOffset;
        while (i < rows) {
            var xPoss = xOffset;
            while (j < columns) {
                Dots dot = new Dots(xPoss, yPoss, tmp);
                paneBoard.getChildren().addAll(dot.getDot());
                //tmp = tmp.getRight();
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
