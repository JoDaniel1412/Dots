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

    public static boolean checkverticals(Node node1, Node node2){
        if (node1.getRight() == node2){
            if(checkUp(node1, node2)){
                return checkUpRight(node1, node2);
            }
            if (checkDown(node1, node2)){
                return checkDownRight(node1, node2);
            }
        }
        if (node1.getLeft() == node2){
           if (checkUp(node1, node2)){
               return checkUpLeft(node1, node2);
           }
           if (checkDown(node1, node2)){
               return checkDownLeft(node1, node2);
           }
        }
        return false;
    }


}
