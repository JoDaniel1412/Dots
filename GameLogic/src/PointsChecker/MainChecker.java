package PointsChecker;

import lists.Node;
import lists.Queue;
import lists.Stack;



public class MainChecker {

    public static boolean DotsReceiver(Node node1, Node node2) {
        Node beginning = node1;
        return mainCycle(node2, node1, beginning);



    }

    private static boolean mainCycle(Node node1, Node previous, Node beginning){
        Queue checkThis;
        checkThis = MainChecker.getActivesNodes(node1, previous);
        boolean result = false;

        int cont = 0;
        while (checkThis.GetLarge() != 0){

            Node first = (Node) checkThis.peek().getValue();
            if (MainChecker.CompareWithBeginning(beginning,checkThis)){
                System.out.println("punto");
                result = true;
                break;
            }
            if (0 < checkThis.GetLarge() && !result){
                return mainCycle(first, node1, beginning);
                }

            else{
                checkThis.deQueue();
            }
            cont ++;
        }
        return result;
    }

    private static boolean stopCicle(){
        return true;
    }

    public static Queue getActivesNodes(Node node, Node previous){
        Queue list;
        list = MainChecker.AddActivesNodes(node, previous);
        return list;
    }
    private static Queue AddActivesNodes(Node node, Node previous){
        Queue list = new Queue();
        //System.out.println(previous + "        holis");
        if (node.isTopState() && node.getTop()!= previous){
            if (node.getTop() != null) {
                System.out.println("top");
                list.enQueue(node.getTop());
            }
        }
        if (node.isTop_rightState() && node.getTop_right()!= previous){
            if (node.getTop_right() != null) {
                list.enQueue(node.getTop_right());
            }
        }
        if (node.isRightState() && node.getRight()!= previous){
            if (node.getRight() != null) {
                System.out.println("right");
                list.enQueue(node.getRight());
            }
        }
        if (node.isBottom_rightState() && node.getBottom_right()!= previous){
            if (node.getBottom_right() != null) {
                list.enQueue(node.getBottom_right());
            }
        }
        if (node.isBottomState() && node.getBottom()!= previous){
            if (node.getBottom() != null) {
                list.enQueue(node.getBottom());
            }
        }
        if (node.isLeftState() && node.getBottom_left()!= previous){
            if (node.getTop_left() != null) {
                list.enQueue(node.getBottom_left());
            }
        }
        if (node.isLeftState() && node.getLeft()!= previous){
            if (node.getLeft() != null) {
                System.out.println("Left");
                list.enQueue(node.getLeft());
            }
        }
        if (node.isTop_leftState() && node.getTop_left()!= previous){
            if (node.getTop_left() != null) {
                list.enQueue(node.getTop_left());
            }
        }
        return list;
    }

    public static Boolean CompareWithBeginning(Node Beginning, Queue list){
        int large = list.GetLarge();
        Queue List2 = list;
        //System.out.println(large);
        int cont = 0;
        boolean result = false;
        while (cont < large) {
            if (List2.deQueue().getValue() == Beginning){
                result = true;
                break;
            }

            cont ++;


        }
        return result;
    }
}

