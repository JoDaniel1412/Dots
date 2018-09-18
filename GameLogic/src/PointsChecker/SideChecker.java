package PointsChecker;

import lists.Node;

public class SideChecker {

    private static boolean CheckRight(Node node1, Node node2) {
        return node1.isRightState() && node2.isRightState();
    }
    private static boolean CheckLeft(Node node1, Node node2) {
        return node1.isLeftState() && node2.isLeftState();
    }

    private static boolean CheckRightUp(Node node1, Node node2){
        return node1.getRight().isTopState() && node2.getRight().isBottomState();
    }
    private static boolean CheckRightDown(Node node1, Node node2){
        return node1.getRight().isBottomState() && node2.getRight().isTopState();
    }
    private static boolean CheckLeftUp(Node node1, Node node2){
        return node1.getLeft().isTopState() && node2.getLeft().isBottomState();
    }
    private static boolean CheckLeftDown(Node node1, Node node2){
        return node1.getLeft().isBottomState() && node2.getLeft().isTopState();
    }

    private static boolean checkUpDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isTop_rightState() && node1.isTop_leftState()){ //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isBottom_rightState() && node2.isBottom_leftState()){  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isRightState() && node1.isTop_rightState() ) {
            result = true;
        }
        if (node2.isLeftState() && node1.isTop_leftState()) {
            result = true;
        }
        if (node1.isRightState() && node2.isBottom_rightState()) {
            result = true;
        }
        if (node1.isLeftState() && node2.isBottom_leftState()) {
            result = true;
        }
        return result;
    }

    private static boolean checkDownDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isBottom_rightState() && node1.isBottom_leftState()){ //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isTop_rightState() && node2.isTop_leftState()){  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isRightState() && node1.isBottom_rightState() ) {
            result = true;
        }
        if (node2.isLeftState() && node1.isBottom_leftState()) {
            result = true;
        }
        if (node1.isRightState() && node2.isTop_rightState()) {
            result = true;
        }
        if (node1.isLeftState() && node2.isTop_rightState()) {
            result = true;
        }
        return result;
    }


    public static boolean CheckSides(Node node1, Node node2) {
        if (node1.getTop() == node2) {
            if (SideChecker.checkUpDiagonal(node1, node2)){
                return true;
            }
            if (CheckRight(node1, node2)) {
                if (!node1.isTop_rightState() && !node2.isBottom_rightState()) {
                    return CheckRightUp(node1, node2);
                }

            }
            if (CheckLeft(node1, node2)){
                if (!node1.isTop_leftState() && !node2.isBottom_rightState()) {
                    return CheckLeftUp(node1, node2);
                } else {
                    return node2.isTop_leftState(); //Triangle point
                }
            }

        }
        if (node1.getBottom() == node2){
            if (SideChecker.checkDownDiagonal(node1, node2)){
                return true;
            }
            if (CheckRight(node1, node2)){
                if (!node1.isBottom_rightState() && !node2.isTop_rightState()) {
                    return CheckRightDown(node1, node2);
                } else {
                    return node2.isTop_rightState();
                }

            }
            if (CheckLeft(node1, node2)){
                return CheckLeftDown(node1, node2);
            }
        }
        return false;
    }
}