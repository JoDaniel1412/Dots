package drawings;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import lists.SimpleList;

/**
 * Wrapper class for drawing custom lines
 * @author José Acuña
 * @since 17-09-2018
 */
public class Lines extends Line {

    public static Line line; // This will be draw in the Board
    private static double line_width = Dots.radius;
    private static Color color1 = new Color(0.76f, 0.01f, 0.01f, 1.0f);
    private static Color color2 = new Color(0f, 0.70f, 0.66f, 1.0f);
    private static Color color = color1;

    /**
     * Creates a line shape to be draw
     * @param xStart start of the line
     * @param yStart start of the line
     * @param xFinal end of the line
     * @param yFinal end of the line
     */
    public static synchronized void draw_line(double xStart, double yStart, double xFinal, double yFinal){
        Line line = new Line(xStart, yStart, xFinal, yFinal);
        line.setStrokeWidth(line_width);
        line.setStroke(color);
        Lines.line = line;
    }

    public void setColor1(){
        color = color1;
    }

    public void setColor2(){
        color = color2;
    }
}
