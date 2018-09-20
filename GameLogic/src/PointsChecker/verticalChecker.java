package PointsChecker;

import lists.Node;

import logic.Blocker;

public class verticalChecker {

    private static boolean checkUp(Node node1, Node node2) {
        return node1.isTopState() && node2.isTopState();
    }

    private static boolean checkDown(Node node1, Node node2) {
        return node1.isBottomState() && node2.isBottomState();
    }

    private static boolean checkUpRight(Node node1, Node node2) {
        return node1.getTop().isRightState() && node2.getTop().isLeftState();
    }

    private static boolean checkUpLeft(Node node1, Node node2) {
        return node1.getTop().isLeftState() && node2.getTop().isRightState();
    }

    private static boolean checkDownRight(Node node1, Node node2) {
        return node1.getBottom().isRightState() && node2.getBottom().isLeftState();
    }

    private static boolean checkDownLeft(Node node1, Node node2) {
        return node1.getBottom().isLeftState() && node2.getBottom().isRightState();
    }

    private static boolean checkRightDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isTopState() && node2.isBottomState()) {
            if (node1.isBottom_rightState() && node1.isTop_rightState()) { //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isBottomState() && node1.isTopState()) {
            if (node2.isTop_leftState() && node2.isBottom_leftState()) {  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isTopState() && node1.isTop_rightState()) {
            result = true;
        }
        if (node2.isBottomState() && node1.isBottom_rightState()) {
            result = true;
        }
        if (node1.isBottomState() && node2.isBottom_leftState()) {
            result = true;
        }
        if (node1.isTopState() && node2.isTop_leftState()) {
            result = true;
        }
        return result;
    }

    private static boolean checkLeftDiagonal(Node node1, Node node2) {
        boolean result = false;
        if (node2.isTopState() && node2.isBottomState()) {
            if (node1.isBottom_leftState() && node1.isTop_leftState()) { //puntos dobles
                System.out.println("Doble 1");
                result = true;
            }
        }
        if (node1.isBottomState() && node1.isTopState()) {
            if (node2.isTop_rightState() && node2.isBottom_rightState()) {  // puntos dobles
                System.out.println("Doble 2");
                result = true;
            }
        }
        if (node2.isTopState() && node1.isTop_leftState()) {
            result = true;
        }
        if (node2.isBottomState() && node1.isBottom_leftState()) {
            result = true;
        }
        if (node1.isBottomState() && node2.isBottom_rightState()) {
            result = true;
        }
        if (node1.isTopState() && node2.isTop_rightState()) {
            result = true;
        }
        return result;
    }

    private static boolean noRightDiagonals(Node node1, Node node2) {
        return (!node1.isTop_rightState() && !node2.isTop_leftState() && !node1.isBottom_rightState() && !node2.isBottom_leftState());
    }
    private static boolean noLeftDiagonals(Node node1, Node node2) {
        return (!node1.isTop_leftState() && !node2.isTop_rightState() && !node1.isBottom_leftState() && !node2.isBottom_rightState());
    }

    public static boolean checkverticals(Node node1, Node node2) {
        if (node1.getRight() == node2) {
            if (checkUp(node1, node2) && checkDown(node1, node2)) {
                if (checkUpRight(node1, node2) && checkDownRight(node1, node2) && noRightDiagonals(node1, node2)) {
                    Blocker.BlockUpRightDiagonals(node1, node2);
                    Blocker.blockDownRightDiagonals(node1, node2);
                    Blocker.BlockZone(4, node2.getTop(), node1.getTop(), node1.getBottom(), node2.getBottom());
                    return true;
                }
            }


            if (checkUp(node1, node2)) {
                if (!node1.isTop_rightState() && !node2.isTop_leftState()) {
                    if (checkUpRight(node1, node2)) {
                        Blocker.BlockUpRightDiagonals(node1, node2);
                        if (node2.isBottomState() && node1.isBottom_rightState() && !node2.isBottom_leftState()) {
                            Blocker.blockSquareTriangleDownDecresent(node2, node1);
                            return true;
                        }
                        if (node1.isBottomState() && node2.isBottom_leftState() && !node1.isBottom_rightState()) {
                            Blocker.blockSquareTriangleDownCresent(node2, node1);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getTop(), node1.getTop(), node1);
                        return true;
                    }
                }
            }
            if (checkDown(node1, node2)) {
                if (!node1.isBottom_rightState() && !node2.isBottom_leftState()) {
                    if (checkDownRight(node1, node2)) {
                        Blocker.blockDownRightDiagonals(node1, node2);
                        if (node2.isTopState() && node1.isTop_rightState() && !node2.isTop_leftState()) {
                            Blocker.blockSquareTriangleUpCrescent(node2, node1);
                            return true;
                        }
                        if (node1.isTopState() && node2.isTop_leftState() && !node1.isTop_rightState()) {
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
            if (verticalChecker.checkLeftDiagonal(node1, node2)) {
                return true;
            }

        }
        if (node1.getLeft() == node2) {

            if (checkUp(node1, node2) && checkDown(node1, node2)) {
                if (checkUpLeft(node1, node2) && checkDownLeft(node1, node2) && noLeftDiagonals(node1, node2)) {
                    Blocker.blockUpLeftDiagonals(node1, node2);
                    Blocker.blockDownLeftDiagonals(node1, node2);
                    Blocker.BlockZone(4, node1.getTop(), node2.getTop(), node2.getBottom(), node1.getBottom());
                    return true;
                }
            }


            if (checkUp(node1, node2)) {
                if (!node1.isTop_leftState() && !node2.isTop_rightState()) {
                    if (checkUpLeft(node1, node2)) {
                        Blocker.blockUpLeftDiagonals(node1, node2);
                        if (node2.isBottomState() && node1.isBottom_leftState() && !node2.isBottom_rightState()) {
                            Blocker.blockSquareTriangleDownCresent(node1, node2);
                            return true;
                        }
                        if (node1.isBottomState() && node2.isBottom_rightState() && !node1.isBottom_leftState()) {
                            Blocker.blockSquareTriangleDownDecresent(node1, node2);
                            return true;
                        }
                        Blocker.BlockZone(2, node2, node2.getTop(), node1.getTop(), node1);
                        return true;
                    }
                }
            }
            if (checkDown(node1, node2)) {
                if (!node1.isBottom_leftState() && !node2.isBottom_rightState()) {
                    if(checkDownLeft(node1, node2)){
                        Blocker.blockDownLeftDiagonals(node1, node2);
                        if (node2.isTopState() && node1.isTop_leftState() && !node2.isTop_rightState()) {
                            Blocker.blockSquareTriangleUpDecrescent(node1, node2);
                            return true;
                        }
                        if (node1.isTopState() && node2.isTop_rightState() && !node1.isTop_leftState()) {
                            Blocker.blockSquareTriangleUpCrescent(node1, node2);
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



