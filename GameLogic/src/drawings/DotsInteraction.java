package drawings;

import client.Cliente;
import lists.Board;
import lists.DoubleArray;
import lists.Node;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;

class DotsInteraction {

    private static DoubleArray<Node> doubleArray = new DoubleArray<>();

    public static void dot_pressed(Node node) throws IOException, InterruptedException {
        doubleArray.add(node);
        if(doubleArray.getSecond() != null){
            ObjectMapper mapper = new ObjectMapper();
            File json = new File("Sockets/message.json");

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
}
