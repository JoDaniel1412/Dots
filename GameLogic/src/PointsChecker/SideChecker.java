
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
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isLineTopRight() && node1.isLineTopLeft()){ //puntos dobles
                Blocker.blockRightDiagonals(node2, node1);
                Blocker.blockLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node1, node2.getLeft(), node2.getRight());
                return true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isBottom_rightState() && node2.isBottom_leftState()){  // puntos dobles
                Blocker.blockRightDiagonals(node2, node1);
                Blocker.blockLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node2, node1.getLeft(), node1.getRight());
                return true;
            }
        }

        if (node1.isLeftState() && node2.isRightState()){
            if (node1.isLineTopRight() && node2.isLineBottomLeft()){
                Blocker.blockRightDiagonals(node2, node1);
                Blocker.blockLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node1, node1.getLeft(), node2, node2.getRight());
                return true;
            }
        }

        if (node1.isRightState() && node2.isLeftState()){
            if (node1.isLineTopLeft() && node2.isLineBottomRight()){
                Blocker.blockRightDiagonals(node2, node1);
                Blocker.blockLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node1, node1.getRight(), node2, node2.getLeft());
                return true;
            }
        }

        if (node2.isRightState() && node1.isLineTopRight() ) {
            Blocker.blockRightDiagonals(node2, node1);
            Blocker.BlockZone(1, node1, node2, node2.getRight());
            return true;
        }
        if (node2.isLeftState() && node1.isLineTopLeft()) {
            Blocker.blockLeftDiagonals(node2, node1);
            Blocker.BlockZone(1, node1, node2, node2.getLeft());
            return true;
        }
        if (node1.isRightState() && node2.isLineBottomRight()) {
            Blocker.blockRightDiagonals(node2, node1);
            Blocker.BlockZone(1, node2, node1, node1.getRight());
            return true;
        }
        if (node1.isLeftState() && node2.isLineBottomLeft()) {
            Blocker.blockLeftDiagonals(node2, node1);
            Blocker.BlockZone(1, node2, node1, node1.getLeft());
            return true;
        }
        return false;
    }

    /**
     * Revisa las diagonales inferiores luego de una linea horizontal
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkDownDiagonal(Node node1, Node node2) {
        if (node2.isRightState() && node2.isLeftState()) {
            if (node1.isLineBottomRight() && node1.isLineBottomLeft()){ //puntos dobles
                Blocker.blockRightDiagonals(node1, node2);
                Blocker.blockLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node1, node2.getLeft(), node2.getRight());
                return true;
            }
        }
        if (node1.isRightState() && node1.isLeftState()) {
            if (node2.isTop_rightState() && node2.isLineTopLeft()){  // puntos dobles
                Blocker.blockRightDiagonals(node1, node2);
                Blocker.blockLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node2, node1.getLeft(), node1.getRight());
                return true;
            }
        }
        if (node2.isRightState() && node1.isLineBottomRight()) {
            Blocker.blockRightDiagonals(node1, node2);
            Blocker.BlockZone(1,node1, node2, node2.getRight());
            return true;
        }
        if (node2.isLeftState() && node1.isLineBottomLeft()) {
            Blocker.blockLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node2.getLeft());
            return true;
        }
        if (node1.isRightState() && node2.isLineTopRight()) {
            Blocker.blockRightDiagonals(node1, node2);
            Blocker.BlockZone(1, node2, node1, node1.getRight());
            return true;
        }
        if (node1.isLeftState() && node2.isLineTopLeft()) {
            Blocker.blockLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node2, node1, node1.getLeft());
            return true;
        }
        return false;
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

    private static boolean noDiagonalsRight (Node node1, Node node2){
        return (!node1.isLineBottomRight() && !node2.isLineTopRight());
    }
    private static boolean noDiagonalsLeft (Node node1, Node node2) {
        return (!node1.isLineBottomLeft() && !node2.isLineTopLeft());
    }

    private static boolean checkParallelDecrement(Node node1, Node node2){
        if (node1.isLineTopLeft() && node2.isLineTopLeft()){
            Blocker.blockLeftDiagonals(node1, node2);
            Blocker.blockLeftDiagonals(node1.getTop(), node1);
            return true;
        }
        return false;
    }
    private static boolean checkParallelCrement (Node node1, Node node2){
        if (node1.isLineBottomLeft() && node2.isLineBottomLeft()){
            Blocker.blockLeftDiagonals(node1, node2);
            Blocker.blockLeftDiagonals(node2, node2.getBottom());
            return true;
        }
        return false;
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
                if (noDiagonalsLeft(node2, node1) && noDiagonalsRight(node2, node1)) {
                    if (CheckLeftUp(node1, node2) && CheckRightUp(node1, node2)){
                        Blocker.blockRightDiagonals(node2, node1);
                        Blocker.blockLeftDiagonals(node2, node1);
                        Blocker.BlockZone(4, node1.getLeft(), node1.getRight(), node2.getRight(), node2.getLeft());
                        return true;
                    }
                }
            }

            if (node1.isLeftState() && node2.isRightState()){
                if(node1.isLineTopRight() && node2.isLineBottomLeft()){
                    Blocker.blockRightDiagonals(node1, node2);
                    Blocker.blockLeftDiagonals(node2, node1);
                    Blocker.BlockZone(2, node2, node2.getRight(), node1, node1.getLeft());
                    return true;
                }
            }

            if (node1.isRightState() && node2.isLeftState()){
                if (node1.isLineTopLeft() && node2.isLineBottomRight()){
                    Blocker.blockRightDiagonals(node2, node1);
                    Blocker.blockLeftDiagonals(node2, node1);
                    Blocker.BlockZone(3, node2, node2.getLeft(), node1, node1.getRight());
                    return true;
                }
            }
            if (node2.getLeft().isTopState() && node1.getRight().isBottomState()){
                if (SideChecker.checkParallelDecrement(node2, node1) &&
                        SideChecker.checkParallelDecrement(node1.getRight(), node1.getRight().getBottom())){
                    Blocker.BlockZone(4, node2.getTop_left(), node1.getTop_left(), node1.getBottom_right(), node2.getBottom_right());
                    return true;
                }
            }
            if (node2.getLeft().isTopState()){
                if (SideChecker.checkParallelDecrement(node2, node1)){
                    Blocker.BlockZone(2, node2, node2.getTop_left(), node1.getTop_left(), node1);
                    return true;
                }
            }
            if (node1.getRight().isBottomState()){
                if (SideChecker.checkParallelDecrement(node1.getRight(), node1.getRight().getBottom())) {
                    Blocker.BlockZone(2, node1, node1.getBottom_right(), node2.getBottom_right(), node2);
                    return true;
                }
            }

            if (node1.getLeft().isBottomState() && node2.getRight().isTopState()) {
                if (checkParallelCrement(node2.getTop_right(), node2.getRight()) && checkParallelCrement(node2, node1)){
                    Blocker.BlockZone(4, node2.getTop_right(), node2.getRight(), node1.getBottom_left(), node1.getLeft());
                    return true;
                }
            }

            if (node1.getLeft().isBottomState()){
                if (checkParallelCrement(node2, node1)){
                    Blocker.BlockZone(2, node1, node2, node2.getBottom_left(), node1.getBottom_left());
                    return true;
                }
            }
            if (node2.getRight().isTopState()){
                if (checkParallelCrement(node2.getTop_right(), node2.getRight())){
                    Blocker.BlockZone(2, node1, node2, node2.getTop_right(), node2.getRight());
                    return false;
                }
            }

            if (CheckRight(node1, node2)) {
                if (noDiagonalsRight(node1, node2)) {
                    if(CheckRightUp(node1, node2)){
                        Blocker.blockRightDiagonals(node2, node1);
                        if (node2.isLeftState() && node1.isLineTopLeft()) {
                            Blocker.blockSquareTriangleLeftDecresent(node2, node1);
                            Blocker.BlockZone(3, node1, node1.getRight(), node2.getRight(), node2.getLeft());
                            return true;
                        }
                        if (node1.isLeftState() && node2.isLineBottomLeft()) {
                            Blocker.blockSquareTriangleLeftCresent(node2, node1);
                            Blocker.BlockZone(3, node2, node2.getRight(), node1.getRight(), node1.getLeft());
                            return true;
                        }
                        if (node2.getRight().isTopState() && checkParallelCrement(node2.getTop_right(), node2.getRight())){

                        }
                        Blocker.BlockZone(2, node2, node2.getRight(), node1.getRight(), node1);
                        return true;
                    }
                }

            }

            if (CheckLeft(node1, node2)){
                if (!node1.isLineTopLeft() && !node2.isLineBottomLeft()) {
                    if(CheckLeftUp(node1, node2)){
                        Blocker.blockLeftDiagonals(node2, node1);
                        if (node2.isRightState() && node1.isLineTopRight()) {
                            Blocker.blockRightDiagonals(node2, node1);
                            Blocker.BlockZone(3, node1, node1.getLeft(), node2.getLeft(), node2.getRight());
                            return true;
                        }
                        if (node1.isRightState() && node2.isLineBottomRight()) {
                            Blocker.blockRightDiagonals(node2, node1);
                            Blocker.BlockZone(3, node2, node2.getLeft(), node1.getLeft(), node1.getRight());
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getLeft(), node1.getLeft(), node1);
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
                if (CheckLeftDown(node1, node2) && CheckRightDown(node1, node2)){
                    Blocker.blockLeftDiagonals(node1, node2);
                    Blocker.blockRightDiagonals(node1, node2);
                    Blocker.BlockZone(4, node1.getLeft(), node1.getRight(), node2.getRight(), node2.getLeft());
                    return true;
                }
            }

            if (node1.isRightState() && node2.isLeftState()){
                if (node1.isLineBottomLeft() && node2.isLineTopRight()){
                    Blocker.blockLeftDiagonals(node1, node2);
                    Blocker.blockRightDiagonals(node1, node2);
                    Blocker.BlockZone(2, node1, node1.getRight(), node2, node2.getLeft());
                    return true;
                }
            }

            if (node1.isLeftState() && node2.isRightState()){
                if (node1.isLineBottomRight() && node2.isLineTopLeft()){
                    Blocker.blockLeftDiagonals(node1, node2);
                    Blocker.blockRightDiagonals(node1, node2);
                    Blocker.BlockZone(2, node1, node1.getLeft(), node2, node2.getRight());
                    return true;
                }
            }
            if (CheckRight(node1, node2)){
                if (!node1.isBottom_rightState() && !node2.isTop_rightState()) {
                    if(CheckRightDown(node1, node2)){
                        Blocker.blockRightDiagonals(node1, node2);
                        if (node2.isLeftState() && node1.isLineBottomLeft()) {
                            Blocker.blockLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node1, node1.getRight(), node2.getRight(), node2.getLeft());
                            return true;
                        }
                        if (node1.isLeftState() && node2.isLineTopLeft()) {
                            Blocker.blockLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node2, node2.getRight(), node1.getRight(), node1.getLeft());
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
                        Blocker.blockUpLeftDiagonals(node1, node2);
                        if (node2.isRightState() && node1.isLineBottomRight()) {
                            Blocker.blockRightDiagonals(node1, node2);
                            Blocker.BlockZone(3, node1, node1.getLeft(), node2.getLeft(), node2.getRight());
                            return true;
                        }
                        if (node1.isRightState() && node2.isBottom_rightState()) {
                            Blocker.blockRightDiagonals(node1, node2);
                            Blocker.BlockZone(3, node2, node2.getLeft(), node1.getLeft(), node1.getRight());
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getLeft(), node1.getLeft(), node1);
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