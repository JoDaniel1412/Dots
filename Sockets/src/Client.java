import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private DataOutputStream server_connection;


    public Client(String ip, int port) {
        try{
            Socket server_address = new Socket(ip, port);
            server_connection = new DataOutputStream(server_address.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

     public void sendMessage(String message){
         try {
             server_connection.writeUTF(message);
             server_connection.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

}
