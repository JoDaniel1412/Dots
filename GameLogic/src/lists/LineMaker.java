package lists;

import PointsChecker.MainChecker;

public class LineMaker {

    private static boolean Verifier(Node node1, Node node2, int player){
        if (node1.getTop() == node2 && !node1.isTopState()){
            node1.setTopState(true);
            node2.setBottomState(true);
            node1.setTopPlayer(player);
            node2.setBottomPlayer(player);
            return true;
        }
        if (node1.getBottom() == node2 && !node1.isBottomState()){
            node1.setBottomState(true);
            node2.setTopState(true);
            node1.setBottomPlayer(player);
            node2.setTopPlayer(player);
            return true;
        }
        if (node1.getRight() == node2 && !node1.isRightState()){
            node1.setRightState(true);
            node2.setLeftState(true);
            node1.setRightPlayer(player);
            node2.setLeftPlayer(player);
            return true;
        }
        if (node1.getLeft() == node2 && !node1.isLeftState()){
            node1.setLeftState(true);
            node2.setRightState(true);
            node1.setLeftPlayer(player);
            node2.setRightPlayer(player);
            return true;
        }
        if (node1.getTop_left() == node2 && !node1.isTop_leftState()){
            node1.setTop_leftState(true);
            node2.setBottom_rightState(true);
            node1.setTopLeftPlayer(player);
            node2.setBottomRightPlayer(player);
            return true;
        }
        if (node1.getTop_right() == node2 && !node1.isTop_rightState()){
            node1.setTop_rightState(true);
            node2.setBottom_leftState(true);
            node1.setTopRightPlayer(player);
            node2.setBottomLeftPlayer(player);
            return true;
        }
        if (node1.getBottom_left() == node2 && !node1.isBottom_leftState()){
            node1.setBottom_leftState(true);
            node2.setTop_rightState(true);
            node1.setBottomLeftPlayer(player);
            node2.setTopRightPlayer(player);
            return true;
        }
        if (node1.getBottom_right() == node2 && !node1.isBottom_rightState()){
            node1.setBottom_rightState(true);
            node2.setTop_leftState(true);
            node1.setBottomRightPlayer(player);
            node2.setTopRightPlayer(player);
            return true;
        }
        return false;
    }


    public static void ReceiveDots (Node node1, Node node2, int player){
        if (Verifier(node1, node2, player)) {
            if (MainChecker.DotsReceiver(node1, node2)) ;
            System.out.println("Agregue punto");
        }
    }


    }

