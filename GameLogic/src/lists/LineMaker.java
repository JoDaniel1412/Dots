package lists;

import PointsChecker.MainChecker;

public class LineMaker {

    public static boolean matchNode(Node node1, Node node2){
        int i = 0;
        SimpleList node1Pointers = new SimpleList();
        node1Pointers.addAtEnd(node1.getTop_left());
        node1Pointers.addAtEnd(node1.getLeft());
        node1Pointers.addAtEnd(node1.getBottom_left());
        node1Pointers.addAtEnd(node1.getBottom());
        node1Pointers.addAtEnd(node1.getBottom_right());
        node1Pointers.addAtEnd(node1.getRight());
        node1Pointers.addAtEnd(node1.getTop_right());
        node1Pointers.addAtEnd(node1.getTop());
        while (i < 8){
            if (node1Pointers.getByIndex(i).getValue() == node2){

                return true;
            }
            i++;
        }
        return false;
    }
    public static void ReceiveDots (Node node1, Node node2){
        if (matchNode(node1, node2)){

            if (MainChecker.DotsReceiver(node1, node2));
        }
    }
}
