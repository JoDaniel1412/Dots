import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Variables
    ServerSocket ss;
    Socket s;
    DataInputStream dIn;
    DataOutputStream dOut;
    public Server(){
        //Try de action
        try{
            ss = new ServerSocket(1234);
            s = ss.accept();
            dIn = new DataInputStream(s.getInputStream());
            dOut = new DataOutputStream(s.getOutputStream());
            //In error case
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //Method created in order to stay looking for servers
    public void listeningForData() throws IOException {
        while(true) {
            try {
                //If the port is not bussy do the connection
                while (dIn.available() == 0) {
                    //How much time it takes to search for the server between intervals
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //UTF code reader
                String dataIn = dIn.readUTF();

                //Send the message after read the client
                dOut.writeUTF(dataIn);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        //Close everything in order to keep the code elegant and clean
        try{
            dIn.close();
            dOut.close();
            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
