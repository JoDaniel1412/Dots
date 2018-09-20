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

}
