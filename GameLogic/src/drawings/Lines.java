package drawings;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Lines extends Line {

    private Color color1 = Color.RED;
    private Color color2 = Color.BLUE;

    public Line draw_line(double xStart, double yStart, double xFinal, double yFinal){
        Line l = new Line(xStart, yStart, xFinal, yFinal);
        l.setFill(color1);
        return l;
    }

}
