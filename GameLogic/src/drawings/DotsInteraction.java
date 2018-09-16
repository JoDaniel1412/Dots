package drawings;

import client.Cliente;
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
    private static ObjectMapper mapper = new ObjectMapper();
    private static File json = new File("Sockets/message.json");


    /**
     * Method that handles the dots pressed by the player
     * @param node the node that the player selected
     * @throws IOException in case that the Json conversion failed
     * @throws InterruptedException in case the client couldn't send the info
     */
    static void dot_pressed(Node node) throws IOException, InterruptedException {
        doubleArray.add(node);
        if(doubleArray.getSecond() != null){
            // Search for the node index
            Board board = Board.getInstance();
            var firstNode = board.searchIndex(doubleArray.getFirst());
            var secondNode = board.searchIndex(doubleArray.getSecond());

            // Makes a json and sends it to the Server
            DoubleArray<DoubleArray> nodesIndex = new DoubleArray<>(firstNode, secondNode);
            mapper.writeValue(json, nodesIndex);
            Cliente.enviarInfo(json);
            doubleArray.clear();
        }
    }

    public static void analise_dots(String json){

        System.out.println(json);

    }
}
