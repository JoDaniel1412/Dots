package lists;

import lists.Node;
import points.checker.MainChecker;

public class LineMaker {

    private static boolean Verifier(Node node1, Node node2){
        if (node1.getTop() == node2 && !node1.isTopState()){
            node1.setTopState(true);
            node2.setBottomState(true);
            return true;
        }
        if (node1.getBottom() == node2 && !node1.isBottomState()){
            node1.setBottomState(true);
            node2.setTopState(true);
            return true;
        }
        if (node1.getRight() == node2 && !node1.isRightState()){
            node1.setRightState(true);
            node2.setLeftState(true);
            return true;
        }
        if (node1.getLeft() == node2 && !node1.isLeftState()){
            node1.setLeftState(true);
            node2.setRightState(true);
            return true;
        }
        if (node1.getTop_left() == node2 && !node1.isTop_leftState()){
            node1.setTop_leftState(true);
            node2.setBottom_rightState(true);
            return true;
        }
        if (node1.getTop_right() == node2 && !node1.isTop_rightState()){
            node1.setTop_rightState(true);
            node2.setBottom_leftState(true);
            return true;
        }
        if (node1.getBottom_left() == node2 && !node1.isBottom_leftState()){
            node1.setBottom_leftState(true);
            node2.setTop_rightState(true);
            return true;
        }
        if (node1.getBottom_right() == node2 && !node1.isBottom_rightState()){
            node1.setBottom_rightState(true);
            node2.setTop_leftState(true);
            return true;
        }
        return false;
    }


         public static void ReceiveDots (Node node1, Node node2){
            if (Verifier(node1, node2)) {
                if (MainChecker.DotsReceiver(node1, node2)) ;
                    System.out.println("Agregue punto");
            }
        }


    }

