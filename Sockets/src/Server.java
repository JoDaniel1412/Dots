import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    // Parameters
    private int port = 6666;
    private String message;


    public Server() {
        Thread read_data = new Thread(this);
        read_data.start();
    }

    @Override
    public void run() {
        System.out.println("Server running...");
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            DataInputStream in_data = new DataInputStream(socket.getInputStream());

            message = in_data.readUTF();
            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Getters and Setters
    public int getPort() {
        return port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
