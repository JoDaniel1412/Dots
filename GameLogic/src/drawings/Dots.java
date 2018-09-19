package drawings;

import client.Cliente;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lists.Node;
import logic.DotsInteraction;

import java.io.IOException;

/**
 * Wrapper class for drawing custom circles
 * @author José Acuña
 * @since 11-9-2018
 */
public class Dots extends Circle {

    static Color dark_red = new Color(0.57f, 0.23333f, 0.22f, 1.0f);
    static Color bone_white = new Color(0.826f, 0.826f, 0.826f, 1.0f);
    static Color orange_beige = new Color(0.823f, 0.673f, 0.453f, 1.0f);
    static Color green_leaf = new Color(0.536f, 0.603f, 0.36f, 1.0f);
    static Color aqua_blue = new Color(0.413f, 0.583f, 0.646f, 1.0f);
    private static Color color = dark_red;
    private static Color color_hover = Color.WHITE;
    public static double radius = 10;
    private Node node;
    private Circle dot;
    public Circle focused;
    public double xPoss;
    public double yPoss;

    public Dots(double xPoss, double yPoss, Node node){
        this.dot = draw_dot(xPoss, yPoss);
        this.node = node;
        this.xPoss = xPoss;
        this.yPoss = yPoss;
    }

    /**
     * Sets a color for the dot in pressed state
     */
    public Circle focuse(){
        focused = new Circle(xPoss, yPoss, radius+3, bone_white);
        return focused;
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
        c.setOnMouseClicked(e-> {
            try {
                pressed_dot();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });
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
    private void pressed_dot() throws IOException, InterruptedException {
        //Sound.play("file:resources/sounds/hit.wav");
        if(Cliente.isTurn()) {
            DotsInteraction.dot_pressed(node, this);
        }
    }

    /* Getters */
    public Circle getDot(){
        return dot;
    }

    public Node getNode(){
        return node;
    }
}
