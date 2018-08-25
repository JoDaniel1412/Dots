import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //Variables
    ServerSocket ss;
    ArrayList<ServerConecction> connections = new ArrayList<ServerConecction>();
    boolean shouldRun = true;

    public Server() {
        //Try de action
        try {
            while(shouldRun)
                ss = new ServerSocket(1234);
                Socket s = new ss.accept();
                ServerConecction sc = new ServerConecction(s, this);
                connections.add(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
