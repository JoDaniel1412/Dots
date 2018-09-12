package points.checker;

import lists.Node;

public class MainChecker {
    public static boolean DotsReceiver(Node node1, Node node2){
        if ((node1.getRight() == node2) || (node1.getLeft() == node2)){
            return verticalChecker.checkverticals(node1, node1);
        }
        if ((node1.getTop() == node2) || (node1.getBottom() == node2)){
            return SideChecker.CheckSides(node1, node2);
        }

        if ((node1.getTop_left() == node2) || (node1.getTop_right() == node2)){

        }
        if ((node1.getBottom_left() == node2) || (node1.getBottom_right() == node2)){

        }
        else {
            System.out.println("Dots selected not available");
            return false;
        }
        return false;
    }
}
