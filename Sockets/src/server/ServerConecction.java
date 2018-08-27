package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConecction extends Thread {

    Socket socket;
    Server server;
    DataInputStream dIn;
    DataOutputStream dOut;
    boolean shouldRun = true;

    public ServerConecction(Socket socket, Server server) {
        super("ServerConecctionThread");
        this.socket = socket;
        this.server = server;
    }

    public void sendStringToClient(String text) {
        try {
            dOut.writeUTF(text);
            dOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendStringToAllClients(String text) {
        for (int index = 0; index < server.connections.size(); index++) {
            ServerConecction sc = server.connections.get(index);
            sc.sendStringToClient(text);
        }

    }


    public void run() {
        try {
            dIn = new DataInputStream((socket.getInputStream()));
            dOut = new DataOutputStream(socket.getOutputStream());

            while (shouldRun) {
                while (dIn.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String textIn = dIn.readUTF();
                sendStringToAllClients(textIn);
            }
            dIn.close();
            dOut.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
