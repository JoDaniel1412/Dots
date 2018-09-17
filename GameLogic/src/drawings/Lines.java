package drawings;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import lists.SimpleList;

public class Lines extends Line {

    public static Line line;
    private static Color color1 = Color.RED;
    private static Color color2 = Color.BLUE;
    private static Color color = color1;

    public static void draw_line(double xStart, double yStart, double xFinal, double yFinal){
        Line line = new Line(xStart, yStart, xFinal, yFinal);
        line.setFill(color);
        Lines.line = line;
    }

    public void setColor1(){
        color = color1;
    }

    public void setColor2(){
        color = color2;
    }
}
