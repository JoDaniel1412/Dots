package drawings;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lists.Node;

/**
 * @author Jose Acuna
 * @since 11-9-2018
 */
public class Dots extends Circle {

    private static Color dark_red = new Color(0.57f, 0.23333f, 0.22f, 1.0f);
    private static Color color = dark_red;
    private static Color color_hover = Color.WHITE;
    public static double radius = 20;
    private Node node;
    private Circle dot;

    public Dots(double xPoss, double yPoss, Node node){
        this.dot = draw_dot(xPoss, yPoss);
        this.node = node;
    }

    /**
     * Draws a Circle shape from JavaFX
     * @param xPoss coordinate in x to be draw
     * @param yPoss coordinate in y to be draw
     * @return a Circle
     */
    private Circle draw_dot(double xPoss, double yPoss){
        Circle c = new Circle(xPoss, yPoss, radius);
        c.setFill(color);
        c.setOnMouseClicked(e-> pressed_dot());
        c.setOnMouseEntered(e-> switch_color(c, color_hover));
        c.setOnMouseExited(e-> switch_color(c, color));
        return c;
    }

    /**
     * Makes the dot switch color if is focused or not
     * @param c the dot to recolor
     * @param color the color to set
     */
    private void switch_color(Circle c, Color color){
        c.setFill(color);
    }

    /**
     * Dots action to do
     */
    private void pressed_dot(){

    }

    /* Getters */
    public Circle getDot(){
        return dot;
    }

    public Node getNode(){
        return node;
    }
}
