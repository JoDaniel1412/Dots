package drawings;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import lists.Node;
import logic.DotsInteraction;
import sound.Sound;

/**
 * Wrapper class for drawing figures
 * @author José Acuña
 * @since 19-09-2018
 */
public class Figures extends Polygon {

    public static Polygon figure; // This will be draw in the Board
    public static Color color1 = DrawBoard.p1Color.deriveColor(0.8, 0.8, 0.8, 1);
    public static Color color2 = DrawBoard.p2Color.deriveColor(0.8, 0.8, 0.8, 1);
    public static Color color = color1;

    /**
     * Creates a polygonal shape to be draw
     * @param node1 first pair of coordinates
     * @param node2 second pair of coordinates
     * @param node3 third pair of coordinates
     * @param node4 fort pair of coordinates
     */
    public static synchronized void draw_figure(int points, Node node1, Node node2, Node node3, Node node4){
        Dots dot1 = node1.getDot();
        Dots dot2 = node2.getDot();
        Dots dot3 = node3.getDot();
        Dots dot4 = node4.getDot();

        Polygon polygon = new Polygon();
        polygon.setFill(color);

        //Adding coordinates to the polygon
        polygon.getPoints().addAll(dot1.xPoss, dot1.yPoss,
                dot2.xPoss, dot2.yPoss,
                dot3.xPoss, dot3.yPoss,
                dot4.xPoss, dot4.yPoss);

        Figures.figure = polygon;
        DotsInteraction.point_made(points);
        play_sound(points);
    }
    public static synchronized void draw_figure(int points, Node node1, Node node2, Node node3) {
        Dots dot1 = node1.getDot();
        Dots dot2 = node2.getDot();
        Dots dot3 = node3.getDot();

        Polygon polygon = new Polygon();
        polygon.setFill(color);

        //Adding coordinates to the polygon
        polygon.getPoints().addAll(dot1.xPoss, dot1.yPoss,
                dot2.xPoss, dot2.yPoss,
                dot3.xPoss, dot3.yPoss);

        Figures.figure = polygon;
        DotsInteraction.point_made(points);
        play_sound(points);
    }



    private static void play_sound(int points){
        if (points == 1){
            Sound.play("resources/sounds/point_one.wav", 0);
        }
        if (points == 2){
            Sound.play("resources/sounds/point_two.wav", 0);
        }
        if (points == 3){
            Sound.play("resources/sounds/point_three.wav", 0);
        }
        if (points == 4){
            Sound.play("resources/sounds/point_four.wav", 0);
        }
    }

    public void setColor1(){
        color = color1;
    }

    public void setColor2(){
        color = color2;
    }
}
