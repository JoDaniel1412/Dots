package PointsChecker;

import lists.Node;
import logic.Blocker;

/**
 * @author Fabián Ramírez
 */
public class DiagonalChecker {
    /**
     * Bloquea las diagonales crecientes
     * @param node1 Almacena el nodo inicial
     * @param node2 Almanena el nodo final
     */
    private static void blockCresent(Node node1, Node node2){
        node1.getBottom().setTop_rightState(true);
        node2.getTop().setBottom_leftState(true);
    }

    /**
     * Bloquea las diagonales decrecientes
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    private static void blockDecresent(Node node1, Node node2){
        node2.getBottom().setTop_leftState(true);
        node1.getTop().setBottom_rightState(true);
    }
    /**
     *Método princial en caso de que se realice una diagonal hacia arriba
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    public static boolean CheckUpDiagonal(Node node1, Node node2) {
        if (node1.getTop_right() == node2) {
            if (node1.isTopState() && node2.isLeftState()) {
                blockDecresent(node1, node2);
                Blocker.BlockZone(1, node1, node2, node1.getTop());
                return true;
            }
            if (node1.isRightState() && node2.isBottomState()){
                blockDecresent(node1, node2);
                Blocker.BlockZone(1, node1, node2, node2.getBottom());
                return true;
            }
            blockDecresent(node1, node2);
            return false;
        }

        if (node1.getTop_left() == node2) {

            if (node1.isTopState() && node2.isRightState()){
                blockCresent(node2, node1);
                Blocker.BlockZone(1, node1, node2,node1.getTop());
                return true;
            }
            if(node1.isLeftState() && node2.isBottomState()){
                blockCresent(node2, node1);
                Blocker.BlockZone(1, node1, node2, node2.getBottom());
                return true;
            }
            blockCresent(node2, node1);
            return false;
        }
        return false;
    }

    /**
     * Método princial en caso de que se realice una diagonal hacia abajo
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    public static boolean CheckDownDiagonal(Node node1, Node node2){
        if (node1.getBottom_right() == node2){
            if (node1.isBottomState() && node2.isLeftState()){
                blockCresent(node1, node2);
                Blocker.BlockZone(1, node1, node2, node1.getBottom());
                return true;
            }
            if (node1.isRightState() && node2.isTopState()){
                blockCresent(node1, node2);
                Blocker.BlockZone(1, node1, node2, node2.getTop());
                return true;
            }
            blockCresent(node1, node2);
            return false;
        }
        if (node1.getBottom_left() == node2){
            if (node1.isBottomState() && node2.isRightState()){
                blockDecresent(node2, node1);
                Blocker.BlockZone(1, node1, node2, node2.getRight());
                return true;
            }
            if(node1.isLeftState() && node2.isTopState()){
                blockDecresent(node2, node1);
                Blocker.BlockZone(1, node1, node2, node2.getTop());
                return true;
            }
            blockDecresent(node2, node1);
            return true;
        }
        return false;
    }


}
