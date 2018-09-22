package lists;

import PointsCheckerNew.MainChecker;

/**
 * @author Fabián Ramírez
 */
public class LineMaker {

    /**
     * Verifica si los puntos se pueden conectar entre sí
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return
     */
    private static void makeTop (Node node1, Node node2){
        node1.setTopState(true);
        node2.setBottomState(true);
    }

    private static void makeBottom (Node node1, Node node2){
        node1.setBottomState(true);
        node2.setTopState(true);
    }

    private static void makeRight (Node node1, Node node2){
        node1.setRightState(true);
        node2.setLeftState(true);
    }

    private static void makeLeft (Node node1, Node node2){
        node1.setLeftState(true);
        node2.setRightState(true);
    }

    private static void makeTopLeft (Node node1, Node node2){
        node1.setTop_leftState(true);
        node2.setBottom_rightState(true);
        node1.setLineTopLeft(true);
        node2.setLineBottomRight(true);
    }


    private static boolean Verifier(Node node1, Node node2){
        if (node1.getTop() == node2 && !node1.isTopState()){
            makeTop(node1, node2);
            return true;
        }
        if (node1.getBottom() == node2 && !node1.isBottomState()){
            makeBottom(node1, node2);
            return true;
        }
        if (node1.getRight() == node2 && !node1.isRightState()){
            makeRight(node1, node2);
            return true;
        }
        if (node1.getLeft() == node2 && !node1.isLeftState()){
            makeLeft(node1, node2);
            return true;
        }
        if (node1.getTop_left() == node2 && !node1.isTop_leftState()){
            makeTopLeft(node1, node2);
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


    /**
     * Recibe los nodos provenientes del cliente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void ReceiveDots (Node node1, Node node2){
        if (Verifier(node1, node2)) {
            if (MainChecker.DotsReceiver(node1, node2)) ;
            System.out.println("Agregue punto");
        }
    }


    }

