package PointsChecker;

import lists.Node;

public class DiagonalChecker {


    public static boolean CheckUpDiagonal(Node node1, Node node2) {
        if (node1.getTop_right() == node2) {
            if (node1.isTopState() && node2.isLeftState()) {
                return true;
            }
            return node1.isRightState() && node2.isLeftState();
        }

        if (node1.getTop_left() == node2) {
            if (node1.isTopState() && node2.isRightState()){
                return true;
            }
            return node1.isLeftState() && node2.isTopState();
        }
        return false;
    }

    public static boolean CheckDownDiagonal(Node node1, Node node2){
        if (node1.getBottom_right() == node2){
            if (node1.isBottomState() && node2.isLeftState()){
                return true;
            }
            return node1.isRightState() && node2.isTopState();
        }
        if (node1.getBottom_left() == node2){
            if (node1.isBottomState() && node2.isRightState()){
                return true;
            }
            return node1.isLeftState() && node2.isTopState();
        }
        return false;
    }
}
