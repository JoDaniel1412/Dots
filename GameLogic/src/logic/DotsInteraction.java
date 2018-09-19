package logic;

import PointsChecker.MainChecker;
import client.Cliente;
import drawings.Dots;
import drawings.DrawBoard;
import drawings.Lines;
import lists.Board;
import lists.DoubleArray;
import lists.Node;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Facade class used to connect the GameLogic whit Sockets and GUI
 * @author José Acuña
 */
public class DotsInteraction {

    private static DoubleArray<Node> doubleArray = new DoubleArray<>();
    private static DoubleArray<Dots> dotsDoubleArray = new DoubleArray<>();
    private static ObjectMapper mapper = new ObjectMapper();
    private static File json = new File("Sockets/message_send.json");
    private static short line_repeater = 1;
    private static int p1Score = 0;
    private static int p2Score = 0;


    /**
     * Method that handles the dots pressed by the player, verification and scores
     * @param node the node that the player selected
     * @param dot the dot coordinates to draw line
     * @throws IOException in case that the Json conversion failed
     * @throws InterruptedException in case the client couldn't send the info
     */
    public static void dot_pressed(Node node, Dots dot) throws IOException, InterruptedException {
        if (doubleArray.getFirst() != node) {
            doubleArray.add(node);
            dotsDoubleArray.add(dot);
            DrawBoard.draw.getPaneBoard().getChildren().addAll(dot.focuse());
        }
        if(doubleArray.getSecond() != null) {  // Run logic when second dot is selected

            if (LineMaker.Verifier(doubleArray.getFirst(), doubleArray.getSecond())) {  // Verify if nodes are consecutive
                if (MainChecker.DotsReceiver(doubleArray.getFirst(), doubleArray.getSecond())){  // Verify if point was make
                    p1Score++;
                }

                // Search for the node index
                Board board = Board.getInstance();
                var firstNode = board.searchIndex(doubleArray.getFirst());
                var secondNode = board.searchIndex(doubleArray.getSecond());

                // Draws the line in local
                var firstDot = dotsDoubleArray.getFirst();
                var secondDot = dotsDoubleArray.getSecond();
                Lines.color = Lines.color1;
                Lines.draw_line(firstDot.xPoss, firstDot.yPoss, secondDot.xPoss, secondDot.yPoss);
                DrawBoard.draw.check_lines();

                // Makes a json and sends it to the Server
                DoubleArray<DoubleArray> nodesIndex = new DoubleArray<>(firstNode, secondNode);
                mapper.writeValue(json, nodesIndex);
                Cliente.enviarInfo(json);
                Cliente.setTurn(false);
                line_repeater = 0;

                clear_arrays();
            }else {
                clear_arrays();
            }

        }
    }

    public static boolean  try_read(File json){
        try {
            DoubleArray arrayIndex = mapper.readValue(json, DoubleArray.class);
            received_dots(arrayIndex);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Handles the dots received by the server and draws the line
     * @param arrayIndex list whit the nodes coordinates
     * @throws IOException in case that the json couldn't be read
     */
    public static void received_dots(DoubleArray arrayIndex){

        var first_dot = arrayIndex.getFirst().toString().replaceAll("\\D+",""); // Remove non digits
        var second_dot = arrayIndex.getSecond().toString().replaceAll("\\D+",""); // Remove non digits

        int first_dot_row = Integer.parseInt(String.valueOf(first_dot.charAt(0))); // First Node Index
        int first_dot_column = Integer.parseInt(String.valueOf(first_dot.charAt(1))); // First Node Index

        int second_dot_row = Integer.parseInt(String.valueOf(second_dot.charAt(0))); // Second Node Index
        int second_dot_column = Integer.parseInt(String.valueOf(second_dot.charAt(1))); // Second Node Index

        // Search for the Dot coordinates
        Board board = Board.getInstance();
        Dots first_dot_coordinate = board.getIndex(first_dot_row, first_dot_column).getDot();
        Dots second_dot_coordinate = board.getIndex(second_dot_row, second_dot_column).getDot();

        // Gets the nodes
        Node first_node = first_dot_coordinate.getNode();
        Node second_node = second_dot_coordinate.getNode();

        if (LineMaker.Verifier(first_node, second_node)) {  // Verify if nodes are consecutive
            if (MainChecker.DotsReceiver(first_node, second_node)) {  // Verify if point was make by the other player
                p2Score++;
                System.out.println("Point2");
            }
        }
        if (line_repeater == 1) {  // Draws the line in the pane
            Lines.color = Lines.color2;
            Lines.draw_line(first_dot_coordinate.xPoss, first_dot_coordinate.yPoss, second_dot_coordinate.xPoss, second_dot_coordinate.yPoss);
            Cliente.setTurn(true);
        } else {
            line_repeater = 1;
        }
    }

    /**
     * Clears the DoubleArrays and focused circles
     */
    private static void clear_arrays(){
        var first_focused = dotsDoubleArray.getFirst().focused;
        var second_focused = dotsDoubleArray.getSecond().focused;
        if (first_focused != null && second_focused != null) {
            DrawBoard.draw.getPaneBoard().getChildren().remove(first_focused);
            DrawBoard.draw.getPaneBoard().getChildren().remove(second_focused);
        }
        doubleArray.clear();
        dotsDoubleArray.clear();
    }

    /** Getters **/
    public static int getP1Score() {
        return p1Score;
    }

    public static int getP2Score() {
        return p2Score;
    }
}
