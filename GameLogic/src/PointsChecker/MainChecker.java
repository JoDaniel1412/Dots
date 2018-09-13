package PointsChecker;

import lists.Node;
import lists.Queue;
import lists.Stack;

public class MainChecker {
    public static boolean DotsReceiver(Node node1, Node node2) {
        Node beginning = node1;








        return true;
    }



    private static Queue pointers(Node node) {
        Queue list = new Queue();
        list.enQueue(node.isTopState());
        list.enQueue(node.isTop_rightState());
        list.enQueue(node.isRightState());
        list.enQueue(node.isBottom_rightState());
        list.enQueue(node.isBottomState());
        list.enQueue(node.isBottom_leftState());
        list.enQueue(node.isLeftState());
        list.enQueue(node.isTop_leftState());
        return list;
    }
    private static Queue getActivesNodes(Node node, Node previous){
        Queue list = new Queue();
        Queue pointersState = MainChecker.pointers(node);
        int cont = 0;
        while (cont < 8){
            if((boolean) pointersState.deQueue().getValue()){
                list = AddActivesNodes(cont, list, node, previous);
            }

            cont ++;
            }
        return list;
    }
    private static Queue AddActivesNodes(int num, Queue list, Node node, Node previous){
        if (num == 0){
            if (node.getTop() != previous) {
                list.enQueue(node.getTop());
            }
        }
        if (num == 1){
            if (node.getTop_right() != previous) {
                list.enQueue(node.getTop_right());
            }
        }
        if (num == 2){
            if (node.getRight() != previous) {
                list.enQueue(node.getRight());
            }
        }
        if (num == 3){
            if (node.getBottom_right() != previous) {
                list.enQueue(node.getBottom_right());
            }
        }
        if (num == 4){
            if (node.getBottom() != previous) {
                list.enQueue(node.getBottom());
            }
        }
        if (num == 5){
            if (node.getBottom_left() != previous) {
                list.enQueue(node.getBottom_left());
            }
        }
        if (num == 6){
            if (node.getLeft() != previous) {
                list.enQueue(node.getLeft());
            }
        }
        if (num == 7){
            if (node.getTop_left()!= previous) {
                list.enQueue(node.getTop_left());
            }
        }
        return list;
    }

    private static Boolean CompareWithBeginning(Node Begining, Queue list){
        int large = list.GetLarge();
        int cont = 0;
        while (cont < large) {
            if (list.deQueue() == Begining){
                return true;
            }
            cont ++;
        }
        return false;
    }
}

