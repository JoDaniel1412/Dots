package logic;

import lists.Node;

/**
 * @author Fabián Ramírez
 */
public class LineMaker {
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

    private static void makeTopRight(Node node1, Node node2){
       node1.setTop_rightState(true);
       node2.setBottom_leftState(true);
       node1.setLineTopRight(true);
       node2.setLineBottomLeft(true);
    }

    private static void makeBottomLeft (Node node1, Node node2) {
        node1.setBottom_leftState(true);
        node2.setTop_rightState(true);
        node1.setLineBottomLeft(true);
        node2.setLineTopRight(true);
    }

    private static void makeBottomRight(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node2.setTop_leftState(true);
        node1.setLineBottomRight(true);
        node2.setLineTopLeft(true);
    }
    /**
     *Verifica si los dos puntos que selecciona el usuario se pueden unir y realiza la conexión
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return
     */
    public static boolean Verifier(Node node1, Node node2){
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
            makeTopRight(node1, node2);
            return true;
        }
        if (node1.getBottom_left() == node2 && !node1.isBottom_leftState()){
            makeBottomLeft(node1, node2);
            return true;
        }
        if (node1.getBottom_right() == node2 && !node1.isBottom_rightState()){
            makeBottomRight(node1, node2);
            return true;
        }
        return false;
    }
}

