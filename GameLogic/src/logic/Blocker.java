package logic;

import drawings.Figures;
import lists.Node;

public class Blocker {

    public static void BlockZone (int points, Node node1, Node node2, Node node3){
        Figures.draw_figure(node1, node2, node3);
    }

    public static void BlockZone (int points, Node node1, Node node2, Node node3, Node node4){
        Figures.draw_figure(node1, node2, node3, node4);
    }

    public static void BlockUpRightDiagonals(Node node1, Node node2){
        node1.setTop_rightState(true);
        node1.getTop().setBottom_rightState(true);
        node2.setTop_leftState(true);
        node2.getTop().setBottom_leftState(true);
    }

    public static void blockDownRightDiagonals(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node1.getBottom().setTop_rightState(true);
        node2.setBottom_leftState(true);
        node2.getBottom().setTop_leftState(true);
    }
}
