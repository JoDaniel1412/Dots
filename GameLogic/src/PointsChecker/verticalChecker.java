package PointsChecker;

import lists.Node;

public class verticalChecker {

    private static boolean checkUp(Node node1, Node node2){
        return node1.isTopState() && node2.isTopState();
    }
    private static boolean checkDown(Node node1, Node node2){
        return node1.isBottomState() && node2.isBottomState();
    }
    private static boolean checkUpRight(Node node1, Node node2){
        return node1.getTop().isRightState() && node2.getTop().isLeftState();
    }
    private static boolean checkUpLeft(Node node1, Node node2){
        return node1.getTop().isLeftState() && node2.getTop().isRightState();
    }
    private static boolean checkDownRight(Node node1, Node node2){
        return node1.getBottom().isRightState() && node2.getBottom().isLeftState();
    }
    private static boolean checkDownLeft(Node node1, Node node2){
        return node1.getBottom().isLeftState() && node2.getBottom().isRightState();
    }
    private static boolean checkRighDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node1.isBottom_rightState() && node1.isTop_rightState()) { //puntos dobles
            System.out.println("Doble 1");
            result = true;
        }
        if (node2.isTop_leftState() && node2.isBottom_leftState()) {  // puntos dobles
            System.out.println("Doble 2");
            result = true;
        }
        if (!node1.isBottom_rightState() && node1.isTop_rightState()) {
            result = true;
        }
        if (node1.isBottom_rightState() && !node1.isTop_rightState()) {
            result = true;
        }
        if (!node2.isTop_leftState() && node2.isBottom_leftState()) {
            result = true;
        }
        if (node2.isTop_leftState() && !node2.isBottom_leftState()) {
            result = true;
        }
        return result;
    }

    private static boolean checkLeftDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node1.isBottom_leftState() && node1.isTop_leftState()) { //puntos dobles
            System.out.println("Doble 1");
            result = true;
        }
        if (node2.isTop_rightState() && node2.isBottom_rightState()){  // puntos dobles
            System.out.println("Doble 2");
            result = true;
        }
        if (!node1.isBottom_leftState() && node1.isTop_leftState()) {
            result = true;
        }
        if (node1.isBottom_leftState() && !node1.isTop_leftState()) {
            result = true;
        }
        if (!node2.isTop_rightState() && node2.isBottom_rightState()) {
            result = true;
        }
        if (node2.isTop_rightState() && !node2.isBottom_rightState()) {
            result = true;
        }
        return result;
    }

    public static boolean checkverticals(Node node1, Node node2){
        if (node1.getRight() == node2){
            if(checkUp(node1, node2)){
                System.out.println("UP");
                if (!node1.isTop_rightState() && !node2.isTop_leftState() && !node1.getTop().isBottom_rightState() && !node2.getTop().isTop_leftState()) {
                    System.out.println("Diagonal");
                    return checkUpRight(node1, node2);
                } else {
                    return verticalChecker.checkRighDiagonal(node1, node2);
                }
            }
            if (checkDown(node1, node2)){
                if (!node1.isTop_rightState() && !node2.isBottom_leftState()) {
                    return checkDownRight(node1, node2);
                } else {
                    return verticalChecker.checkLeftDiagonal(node1, node2);
                }
            }
        }
        if (node1.getLeft() == node2){
            if (checkUp(node1, node2)){
                if (!node1.isTop_leftState() && !node2.isTop_rightState()) {
                    return checkUpLeft(node1, node2);
                } else {
                    return node2.isTop_rightState();
                }
            }
            if (checkDown(node1, node2)){
                if (!node1.isBottom_leftState() && !node2.isBottom_rightState()) {
                    return checkDownLeft(node1, node2);
                } else {
                    return node2.isBottom_rightState();
                }
            }
        }
        return false;
    }


}
