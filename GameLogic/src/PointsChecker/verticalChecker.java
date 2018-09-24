package PointsChecker;

import lists.Node;

import logic.Blocker;

/**
 * @author Fabián Ramírez
 */
public class verticalChecker {

    /**
     * Revisa las lineas superiores de cada nodo estén activas
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkUp(Node node1, Node node2) {
        return node1.isTopState() && node2.isTopState();
    }

    /**
     * Revisa las lineas inferiores de cada nodo que estén activas
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkDown(Node node1, Node node2) {
        return node1.isBottomState() && node2.isBottomState();
    }

    /**
     *  Una vez chequeadas las superiores, revisa la linea superior derecha
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkUpRight(Node node1, Node node2) {
        return node1.getTop().isRightState() && node2.getTop().isLeftState();
    }

    /**
     * Una vez chequeadas las superiores, revisa la linea superior izquierda
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkUpLeft(Node node1, Node node2) {
        return node1.getTop().isLeftState() && node2.getTop().isRightState();
    }

    /**
     * Una vez chequeadas las inferiores, revisa la linea inferior derecha
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkDownRight(Node node1, Node node2) {
        return node1.getBottom().isRightState() && node2.getBottom().isLeftState();
    }


    /**
     * Una vez chequeadas las inferiores, revisa la linea inferior izquierda
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkDownLeft(Node node1, Node node2) {
        return node1.getBottom().isLeftState() && node2.getBottom().isRightState();
    }

    /**
     * Revisa posibles triangulos por derecha
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkRightDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isTopState() && node2.isBottomState()) {

            if (node1.isLineBottomRight() && node1.isLineTopRight()) { //puntos dobles
                Blocker.blockDownRightDiagonals(node1, node2);
                Blocker.BlockUpDiagonals(node1, node2);
                Blocker.BlockZone(2, node1, node2.getTop(), node2.getBottom());
                return true;
            }
        }
        if (node1.isBottomState() && node1.isTopState()) {
            if (node2.isLineTopLeft() && node2.isLineBottomLeft()) {  // puntos dobles
                Blocker.blockUpLeftDiagonals(node2, node1);
                Blocker.blockDownLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node2, node1.getTop(), node1.getBottom());
                return true;
            }
        }
        if (node1.isBottomState() && node2.isTopState()){
            if (node1.isLineTopRight() && node2.isLineBottomLeft()){
                Blocker.BlockUpDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node1, node1.getBottom(), node2, node2.getTop());
                return true;
            }
        }
        if (node2.isBottomState() && node1.isTopState()){
            if (node1.isLineBottomRight() && node2.isLineTopLeft()){
                Blocker.BlockUpDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node2, node1);
                Blocker.BlockZone(2, node1, node2.getBottom(), node2, node1.getTop());
                return true;
            }
        }
        if (node2.isTopState() && node1.isLineTopRight()) {
            Blocker.BlockUpDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node2.getTop());
            result = true;
        }
        if (node2.isBottomState() && node1.isLineBottomRight()) {
            Blocker.blockDownRightDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node2.getBottom());
            result = true;
        }
        if (node1.isBottomState() && node2.isLineBottomLeft()) {
            Blocker.blockDownLeftDiagonals(node2, node1);
            Blocker.BlockZone(1, node2, node1, node1.getBottom());
            result = true;
        }
        if (node1.isTopState() && node2.isLineTopLeft()) {
            Blocker.blockUpLeftDiagonals(node2, node1);
            Blocker.BlockZone(1, node2, node1, node1.getTop());
            result = true;
        }
        return result;
    }

    /**
     * Revisa posibles triangulos por izquierda
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean checkLeftDiagonal(Node node1, Node node2) {
        if (node2.isTopState() && node2.isBottomState()) {
            if (node1.isLineBottomLeft() && node1.isLineTopLeft()) { //puntos dobles
                Blocker.blockUpLeftDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node1, node2.getBottom(), node2.getTop());
                return true;
            }
        }
        if (node1.isBottomState() && node1.isTopState()) {
            if (node2.isTop_rightState() && node2.isBottom_rightState()) {  // puntos dobles
                Blocker.blockUpLeftDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node2, node1.getBottom(), node1.getTop());
                return true;
            }
        }
        if (node1.isBottomState() && node2.isTopState()){
            if (node1.isLineTopLeft() && node2.isLineBottomRight()){
                Blocker.blockUpLeftDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node1, node1.getBottom(), node2, node2.getTop());
                return true;
            }
        }
        if (node1.isTopState() && node2.isBottomState()){
            if (node1.isLineBottomLeft() && node2.isLineTopRight()){
                Blocker.blockUpLeftDiagonals(node1, node2);
                Blocker.blockDownLeftDiagonals(node1, node2);
                Blocker.BlockZone(2, node1, node1.getTop(), node2, node2.getBottom());
                return true;
            }
        }
        if (node2.isTopState() && node1.isLineTopLeft()) {
            Blocker.blockUpLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node2.getTop());
            return true;
        }
        if (node2.isBottomState() && node1.isLineBottomLeft()) {
            Blocker.blockDownLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node2.getBottom());
            return true;
        }
        if (node1.isBottomState() && node2.isLineBottomRight()) {
            Blocker.blockDownLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node1, node2, node1.getBottom());
            return true;
        }
        if (node1.isTopState() && node2.isLineTopRight()) {
            Blocker.blockUpLeftDiagonals(node1, node2);
            Blocker.BlockZone(1, node2, node1, node1.getTop());
            return true;
        }
        return false;
    }

    /**
     * Verifica que no hayan diagonales dentro de un posible triangulo por derecha
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean noRightDiagonals(Node node1, Node node2) {
        return (!node1.isTop_rightState() && !node2.isTop_leftState() && !node1.isBottom_rightState() && !node2.isBottom_leftState());
    }

    /**
     * Verifica que no hayan diagonales dentro de un posible triangulo por izquierda
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    private static boolean noLeftDiagonals(Node node1, Node node2) {
        return (!node1.isTop_leftState() && !node2.isTop_rightState() && !node1.isBottom_leftState() && !node2.isBottom_rightState());
    }

    /**
     * Método principal que verifiar cualquier caso en caso de que se realice una linea horizontal
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     * @return boolean
     */
    public static boolean checkverticals(Node node1, Node node2) {
        if (node1.getRight() == node2) {
            if (checkUp(node1, node2) && checkDown(node1, node2)) {
                if (checkUpRight(node1, node2) && checkDownRight(node1, node2) && noRightDiagonals(node1, node2)) {
                    Blocker.BlockUpDiagonals(node1, node2);
                    Blocker.blockDownRightDiagonals(node1, node2);
                    Blocker.BlockZone(4, node2.getTop(), node1.getTop(), node1.getBottom(), node2.getBottom());
                    return true;
                }
            }


            if (checkUp(node1, node2)) {
                if (!node1.isLineTopRight() && !node2.isLineTopLeft()) {
                    if (checkUpRight(node1, node2)) {
                        Blocker.BlockUpDiagonals(node1, node2);
                        if (node2.isBottomState() && node1.isLineBottomRight() && !node2.isLineBottomLeft()) {
                            Blocker.blockSquareTriangleDownDecresent(node2, node1);
                            return true;
                        }
                        if (node1.isBottomState() && node2.isLineBottomLeft() && !node1.isLineBottomRight()) {
                            Blocker.blockSquareTriangleDownCresent(node2, node1);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getTop(), node1.getTop(), node1);
                        return true;
                    }
                }
            }
            if (checkDown(node1, node2)) {
                if (!node1.isLineBottomRight() && !node2.isLineBottomLeft()) {
                    if (checkDownRight(node1, node2)) {
                        Blocker.blockDownRightDiagonals(node1, node2);
                        if (node2.isTopState() && node1.isLineTopRight() && !node2.isLineTopLeft()) {
                            Blocker.blockSquareTriangleUpCrescent(node2, node1);
                            return true;
                        }
                        if (node1.isTopState() && node2.isLineTopLeft() && !node1.isLineTopRight()) {
                            Blocker.blockSquareTriangleUpDecrescent(node2, node1);
                            return true;
                        }
                        Blocker.BlockZone(2, node1, node1.getBottom(), node2.getBottom(), node2);
                        return true;
                    }
                }
            }
            if (verticalChecker.checkRightDiagonal(node1, node2)) {
                return true;
            }


        }
        if (node1.getLeft() == node2) {

            if (checkUp(node1, node2) && checkDown(node1, node2)) {
                if (checkUpLeft(node1, node2) && checkDownLeft(node1, node2) && noLeftDiagonals(node1, node2)) {
                    Blocker.BlockUpDiagonals(node2, node1);
                    Blocker.blockDownLeftDiagonals(node1, node2);
                    Blocker.BlockZone(4, node1.getTop(), node2.getTop(), node2.getBottom(), node1.getBottom());
                    return true;
                }
            }


            if (checkUp(node1, node2)) {
                if (!node1.isLineTopLeft() && !node2.isLineTopRight()) {
                    if (checkUpLeft(node1, node2)) {
                        Blocker.blockUpLeftDiagonals(node2, node1);
                        if (node2.isBottomState() && node1.isLineBottomLeft() && !node2.isLineBottomRight()) {
                            Blocker.blockDownLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node1, node1.getTop(), node2.getTop(), node2.getBottom());
                            return true;
                        }
                        if (node1.isBottomState() && node2.isLineBottomRight() && !node1.isLineBottomLeft()) {
                            Blocker.blockDownLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node1.getBottom(), node1.getTop(), node2.getTop(), node2);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getTop(), node1.getTop(), node1);
                        return true;
                    }
                }
            }
            if (checkDown(node1, node2)) {
                if (!node1.isLineBottomLeft() && !node2.isLineBottomRight()) {
                    if(checkDownLeft(node1, node2)){
                        Blocker.blockDownLeftDiagonals(node1, node2);
                        if (node2.isTopState() && node1.isLineTopLeft() && !node2.isLineTopRight()) {
                            Blocker.blockUpLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node1, node1.getBottom(), node2.getBottom(), node2.getTop());
                            return true;
                        }
                        if (node1.isTopState() && node2.isLineTopRight() && !node1.isLineTopLeft()) {
                            Blocker.blockUpLeftDiagonals(node1, node2);
                            Blocker.BlockZone(3, node2, node2.getBottom(), node1.getBottom(), node1.getTop());
                            return true;
                        }
                        Blocker.BlockZone(2, node1, node1.getBottom(), node2.getBottom(), node2);
                        return true;
                    }
                }
            }

            return verticalChecker.checkLeftDiagonal(node1, node2);

        }
        return false;
    }

}



