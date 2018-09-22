
package PointsChecker;

import lists.Node;
import logic.Blocker;

/**
 * @author Fabián Ramírez
 */
public class SideChecker {
    /**
     * Revisa si las lineas por derecha están hechas
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean value
     */
    private static boolean CheckRight(Node node1, Node node2) {
        return node1.isRightState() && node2.isRightState();
    }

    /**
     * Revisa si las lineas por izquierda están hechas
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean CheckLeft(Node node1, Node node2) {
        return node1.isLeftState() && node2.isLeftState();
    }

    /**
     * Revisa si la linea vertical hacia arriba a la derecha está hecha para cerrar el cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean CheckRightUp(Node node1, Node node2){
        return node1.getRight().isTopState() && node2.getRight().isBottomState();
    }

    /**
     * Revisa si la linea vertical hacia abajo a la derecha está hecha para cerrar el cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean CheckRightDown(Node node1, Node node2){
        return node1.getRight().isBottomState() && node2.getRight().isTopState();
    }

    /**
     * Revisa si la linea vertical hacia arriba a la izquierda está hecha para cerrar el cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */

    private static boolean CheckLeftUp(Node node1, Node node2){
        return node1.getLeft().isTopState() && node2.getLeft().isBottomState();
    }

    /**
     * Revisa si la linea vertical hacia abajo a la izquierda está hecha para cerrar el cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean CheckLeftDown(Node node1, Node node2){
        return node1.getLeft().isBottomState() && node2.getLeft().isTopState();
    }

    /**
     * Revisa las diagonales superiores luego de una linea horizontal
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkUpDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isTop_rightState() && node1.isTop_leftState()){ //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isBottom_rightState() && node2.isBottom_leftState()){  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isRightState() && node1.isTop_rightState() ) {
            result = true;
        }
        if (node2.isLeftState() && node1.isTop_leftState()) {
            result = true;
        }
        if (node1.isRightState() && node2.isBottom_rightState()) {
            result = true;
        }
        if (node1.isLeftState() && node2.isBottom_leftState()) {
            result = true;
        }
        return result;
    }

    /**
     * Revisa las diagonales inferiores luego de una linea horizontal
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkDownDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isBottom_rightState() && node1.isBottom_leftState()){ //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isTop_rightState() && node2.isTop_leftState()){  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isRightState() && node1.isBottom_rightState() ) {
            result = true;
        }
        if (node2.isLeftState() && node1.isBottom_leftState()) {
            result = true;
        }
        if (node1.isRightState() && node2.isTop_rightState()) {
            result = true;
        }
        if (node1.isLeftState() && node2.isTop_rightState()) {
            result = true;
        }
        return result;
    }

    /**
     * Revisa si hay diagonales superiores dentro de un posible cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean noDiagonalsUp (Node node1, Node node2){
        return (!node1.isTop_rightState() && !node1.isTop_leftState() && !node2.isBottom_leftState() && !node2.isBottom_rightState());
    }

    /**
     * Revisa si hay diagonales inferiores dentro de un posible cuadrado
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean noDiagonalsDown (Node node1, Node node2){
        return (!node1.isBottom_rightState() && !node1.isBottom_leftState() && !node2.isTop_leftState() && !node2.isTop_rightState());
    }

    /**
     * Método principal que revisa todos los casos luego de una linea vertical
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    public static boolean CheckSides(Node node1, Node node2) {
        if (node1.getTop() == node2) {
            if (CheckRight(node1, node2) && CheckLeft(node1, node2)){
                if (CheckLeftUp(node1, node2) && CheckRightUp(node1, node2) && noDiagonalsUp(node1, node2)){
                    return true;
                }
            }

            if (CheckRight(node1, node2)) {
                if (!node1.isTop_rightState() && !node2.isBottom_rightState()) {
                    if(CheckRightUp(node1, node2)){
                        Blocker.blockRightDiagonals(node2, node1);
                        if (node2.isLeftState() && node1.isTop_leftState()) {
                            Blocker.blockSquareTriangleLeftDecresent(node2, node1);
                            return true;
                        }
                        if (node1.isLeftState() && node2.isBottom_leftState()) {
                            Blocker.blockSquareTriangleLeftCresent(node2, node1);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getRight(), node1.getRight(), node1);
                        return true;
                    }
                }

            }

            if (CheckLeft(node1, node2)){
                if (!node1.isTop_leftState() && !node2.isBottom_rightState()) {
                    if(CheckLeftUp(node1, node2)){
                        Blocker.BlockZone(2, node2, node2.getLeft(), node1.getLeft(), node1);
                        if (node2.isRightState() && node1.isTop_rightState()) {
                            return true;
                        }
                        if (node1.isRightState() && node2.isBottom_rightState()) {
                            return true;
                        }
                        return true;
                    }
                }
            }
            if (SideChecker.checkUpDiagonal(node1, node2)){
                return true;
            }
        }

        if (node1.getBottom() == node2){
            if (CheckRight(node1, node2) && CheckLeft(node1, node2) && noDiagonalsDown(node1, node2)){
                if (CheckLeftDown(node1, node2) && CheckRightDown(node1, node2) && noDiagonalsDown(node1, node2)){
                    return true;
                }
            }

            if (CheckRight(node1, node2)){
                if (!node1.isBottom_rightState() && !node2.isTop_rightState()) {
                    if(CheckRightDown(node1, node2)){
                        Blocker.blockRightDiagonals(node1, node2);
                        System.out.println(node2.isLeftState());
                        System.out.println(node1.isTop_leftState());
                        if (node2.isLeftState() && node1.isBottom_leftState()) {
                            Blocker.blockSquareTriangleLeftCresent(node1, node2);
                            return true;
                        }
                        if (node1.isLeftState() && node2.isTop_leftState()) {
                            Blocker.blockSquareTriangleLeftDecresent(node1, node2);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getRight(), node1.getRight(), node1);
                        return true;
                    }
                }

            }
            if (CheckLeft(node1, node2)){
                if (!node1.isBottom_leftState() && !node2.isTop_leftState()) {
                    if(CheckLeftDown(node1, node2)){
                        Blocker.BlockZone(2, node2, node2.getLeft(), node1.getLeft(), node1);
                        if (node2.isRightState() && node1.isTop_rightState()) {

                            return true;
                        }
                        if (node1.isRightState() && node2.isBottom_rightState()) {
                            return true;
                        }
                        return true;
                    }
                }
            }
            if (SideChecker.checkDownDiagonal(node1, node2)){
                return true;
            }
        }
        return false;
    }
}