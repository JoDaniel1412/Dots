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
 * Facade class used to connect the GameLogic whit Sockets
 * @author José Acuña
 */
public class DotsInteraction {

    private static DoubleArray<Node> doubleArray = new DoubleArray<>();
    private static DoubleArray<Dots> dotsDoubleArray = new DoubleArray<>();
    private static ObjectMapper mapper = new ObjectMapper();
    private static File json = new File("Sockets/message_send.json");


    /**
     * Method that handles the dots pressed by the player
     * @param node the node that the player selected
     * @throws IOException in case that the Json conversion failed
     * @throws InterruptedException in case the client couldn't send the info
     */
    public static void dot_pressed(Node node, Dots dot) throws IOException, InterruptedException {
        if (doubleArray.getFirst() != node) {
            doubleArray.add(node);
            dotsDoubleArray.add(dot);
        }
        if(doubleArray.getSecond() != null) {

            if (LineMaker.Verifier(doubleArray.getFirst(), doubleArray.getSecond())) {  // Verify if nodes are consecutive

                if (MainChecker.DotsReceiver(doubleArray.getFirst(), doubleArray.getSecond())){  // Verify if point was make
                    System.out.println("POINT!");
                }

                // Search for the node index
                Board board = Board.getInstance();
                var firstNode = board.searchIndex(doubleArray.getFirst());
                var secondNode = board.searchIndex(doubleArray.getSecond());

                // Draws the line in local
                var firstDot = dotsDoubleArray.getFirst();
                var secondDot = dotsDoubleArray.getSecond();
                Lines.draw_line(firstDot.xPoss, firstDot.yPoss, secondDot.xPoss, secondDot.yPoss);
                DrawBoard.draw.check_lines();
                dotsDoubleArray.clear();

                // Makes a json and sends it to the Server
                DoubleArray<DoubleArray> nodesIndex = new DoubleArray<>(firstNode, secondNode);
                mapper.writeValue(json, nodesIndex);
                Cliente.enviarInfo(json);
                doubleArray.clear();
            }else {
                doubleArray.clear();
                dotsDoubleArray.clear();
            }
        }
    }

    /**
     * Handles the dots received by the server and draws the line
     * @param json file with the index of the nodes to link
     */
    public static void received_dots(File json) throws IOException {
        DoubleArray arrayIndex = mapper.readValue(json, DoubleArray.class);
        var first_dot = arrayIndex.getFirst().toString().replaceAll("\\D+",""); // remove non digits
        var second_dot = arrayIndex.getSecond().toString().replaceAll("\\D+",""); // remove non digits

        int first_dot_row = Integer.parseInt(String.valueOf(first_dot.charAt(0)));
        int first_dot_column = Integer.parseInt(String.valueOf(first_dot.charAt(1)));

        int second_dot_row = Integer.parseInt(String.valueOf(second_dot.charAt(0)));
        int second_dot_column = Integer.parseInt(String.valueOf(second_dot.charAt(1)));

        // search for the Dot coordinates
        Board board = Board.getInstance();
        Dots first_dot_coordinate = board.getIndex(first_dot_row, first_dot_column).getDot();
        Dots second_dot_coordinate = board.getIndex(second_dot_row, second_dot_column).getDot();

        // Draws the line in the pane
        Lines.draw_line(first_dot_coordinate.xPoss, first_dot_coordinate.yPoss, second_dot_coordinate.xPoss, second_dot_coordinate.yPoss);
    }
}
