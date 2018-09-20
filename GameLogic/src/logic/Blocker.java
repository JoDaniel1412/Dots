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

    public static void BlockUpDiagonals(Node node1, Node node2){
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

    public static void blockUpLeftDiagonals(Node node1, Node node2){
        node1.setTop_leftState(true);
        node1.getTop().setBottom_leftState(true);
        node2.setTop_rightState(true);
        node2.getTop().setBottom_rightState(true);
    }

    public static void blockDownLeftDiagonals(Node node1, Node node2){
        node1.setBottom_leftState(true);
        node1.getBottom().setTop_leftState(true);
        node2.setBottom_rightState(true);
        node2.getBottom().setTop_rightState(true);
    }

    public static void blockSquareTriangleUpCrescent(Node node1, Node node2){
        node1.setTop_leftState(true);
        node2.getTop().setBottom_rightState(true);
        Blocker.BlockZone(3, node1.getTop(), node1.getBottom(), node2.getBottom(), node2);
    }

    public static void blockSquareTriangleUpDecrescent(Node node1, Node node2){
        node1.getTop().setTop_leftState(true);
        node2.setTop_rightState(true);
        BlockZone(3, node1, node1.getBottom(), node2.getBottom(), node2.getTop());
    }

    public static void blockSquareTriangleDownCresent(Node node1, Node node2){
        node1.getBottom().setTop_leftState(true);
        node2.setBottom_rightState(true);
        BlockZone(3, node1, node1.getTop(), node2.getTop(), node2.getBottom());
    }

    public static void blockSquareTriangleDownDecresent(Node node1, Node node2){
        node1.setBottom_leftState(true);
        node2.getBottom().setTop_rightState(true);
        BlockZone(3, node1.getTop(), node1.getBottom(), node2, node2.getTop());
    }

    public static void blockSquareTriangleRightCresent(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node2.getRight().setTop_leftState(true);
        BlockZone(3, node1.getLeft(), node2.getLeft(), node2, node1.getRight());
    }

    public static void blockSquareTriangleLeftCresent (Node node1, Node node2){
        node2.setTop_leftState(true);
        node1.getRight().setBottom_rightState(true);
        BlockZone(3, node1, node1.getRight(), node2.getRight(), node2.getLeft());
    }

    public static void blockSquareTriangleLeftDecresent (Node node1, Node node2){
        node1.setBottom_leftState(true);
        node2.getRight().setTop_rightState(true);
        BlockZone(3, node2, node2.getRight(), node1.getRight(), node1.getLeft());
    }



    public static void blockRightDiagonals(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node1.getRight().setBottom_leftState(true);
        node2.setTop_rightState(true);
        node2.getRight().setTop_leftState(true);
    }

}
