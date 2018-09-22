package logic;

import drawings.Figures;
import lists.Node;

public class Blocker {
    /**
     * Dibuja la zona de que se dibujará luego de realizar un triangulo
     * @param points Cuantos puntos se realizan
     * @param node1 primer vertice del triangulo
     * @param node2 segundo vertice del triangulo
     * @param node3 tercer vertice del triangulo
     */
    public static void BlockZone (int points, Node node1, Node node2, Node node3){
        Figures.draw_figure(node1, node2, node3);
    }

    /**
     * Dibuja la zona de que se dibujará luego de realizar un cuadrado
     * @param points Cuantos puntos se realizan
     * @param node1  Primer vertice del cuadrado
     * @param node2  Segundo vertice del cuadrado
     * @param node3  Tercer vertice del cuadrado
     * @param node4  Cuarto vertice del cuadrado
     */
    public static void BlockZone (int points, Node node1, Node node2, Node node3, Node node4){
        Figures.draw_figure(node1, node2, node3, node4);
    }

    /**
     * Bloquea las lineas diagonales superiores dentro de un cuadro ya verificado como punto
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void BlockUpDiagonals(Node node1, Node node2){
        node1.setTop_rightState(true);
        node1.getTop().setBottom_rightState(true);
        node2.setTop_leftState(true);
        node2.getTop().setBottom_leftState(true);
    }

    /**
     *  Bloquea las lineas diagonales inferiores derechas dentro de un cuadro ya verificado como punto
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockDownRightDiagonals(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node1.getBottom().setTop_rightState(true);
        node2.setBottom_leftState(true);
        node2.getBottom().setTop_leftState(true);
    }

    /**
     * Bloquea las lineas diagonales superiores izquierdas dentro de un cuadro ya verificado como punto
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockUpLeftDiagonals(Node node1, Node node2){
        node1.setTop_leftState(true);
        node1.getTop().setBottom_leftState(true);
        node2.setTop_rightState(true);
        node2.getTop().setBottom_rightState(true);
    }

    /**
     *Bloquea las lineas diagonales inferiores izquierdas dentro de un cuadro ya verificado como punto
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockDownLeftDiagonals(Node node1, Node node2){
        node1.setBottom_leftState(true);
        node1.getBottom().setTop_leftState(true);
        node2.setBottom_rightState(true);
        node2.getBottom().setTop_rightState(true);
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo superior con la hipotenusa creciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleUpCrescent(Node node1, Node node2){
        node1.setTop_leftState(true);
        node2.getTop().setBottom_rightState(true);
        Blocker.BlockZone(3, node1.getTop(), node1.getBottom(), node2.getBottom(), node2);
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo superior con la hipotenusa decreciente
     * @param node1 Almacena el nodo inicial
     * @param node2
     */
    public static void blockSquareTriangleUpDecrescent(Node node1, Node node2){
        node1.getTop().setTop_leftState(true);
        node2.setTop_rightState(true);
        BlockZone(3, node1, node1.getBottom(), node2.getBottom(), node2.getTop());
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo inferior con la hipotenusa creciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleDownCresent(Node node1, Node node2){
        node1.getBottom().setTop_leftState(true);
        node2.setBottom_rightState(true);
        BlockZone(3, node1, node1.getTop(), node2.getTop(), node2.getBottom());
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo inferior con la hipotenusa decreciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleDownDecresent(Node node1, Node node2){
        node1.setBottom_leftState(true);
        node2.getBottom().setTop_rightState(true);
        BlockZone(3, node1.getTop(), node1.getBottom(), node2, node2.getTop());
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo derecho con la hipotenusa creciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleRightCresent(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node2.getRight().setTop_leftState(true);
        BlockZone(3, node1.getLeft(), node2.getLeft(), node2, node1.getRight());
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo izquierdo con la hipotenusa creciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleLeftCresent (Node node1, Node node2){
        node2.setTop_leftState(true);
        node1.getRight().setBottom_rightState(true);
        BlockZone(3, node1, node1.getRight(), node2.getRight(), node2.getLeft());
    }

    /**
     * Bloquea las lineas necesarias al realizarse un triangulo izquierdo con la hipotenusa decreciente
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */
    public static void blockSquareTriangleLeftDecresent (Node node1, Node node2){
        node1.setBottom_leftState(true);
        node2.getRight().setTop_rightState(true);
        BlockZone(3, node2, node2.getRight(), node1.getRight(), node1.getLeft());
    }

    /**
     * Bloquea las diagonales que hay dentro de un cuadro verificado a la derecha de la linea realizada
     * @param node1 Almacena el nodo inicial
     * @param node2 Almacena el nodo final
     */

    public static void blockRightDiagonals(Node node1, Node node2){
        node1.setBottom_rightState(true);
        node1.getRight().setBottom_leftState(true);
        node2.setTop_rightState(true);
        node2.getRight().setTop_leftState(true);
    }

    public static void blockLeftDiagonals(Node node1, Node node2){
        node1.setBottom_leftState(true);
        node1.getLeft().setBottom_rightState(true);
        node2.setTop_leftState(true);
        node2.getLeft().setTop_rightState(true);
    }
}
