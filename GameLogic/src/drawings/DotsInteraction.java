package drawings;

import client.Cliente;
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
            mapper.writeValue(json, doubleArray);
            Cliente.enviarInfo(json);
        }
    }
}
