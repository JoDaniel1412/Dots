package drawings;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import lists.SimpleList;

public class Lines extends Line {

    public static Line line;
    private static Color color1 = new Color(0.76f, 0.01f, 0.01f, 1.0f);
    private static Color color2 = new Color(0f, 0.70f, 0.66f, 1.0f);
    private static Color color = color1;

    public static void draw_line(double xStart, double yStart, double xFinal, double yFinal){
        Line line = new Line(xStart, yStart, xFinal, yFinal);
        line.setStrokeWidth(10);
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
