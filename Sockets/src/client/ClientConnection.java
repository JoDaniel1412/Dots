package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread {

    Socket s;
    DataInputStream dIn;
    DataOutputStream dOut;
    boolean shouldRun = true;

    public ClientConnection(Socket socket, Client client) {
        s = socket;

    }

    public void sendStringToServer(String text) {
        try {
            dOut.writeUTF(text);
            dOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
    }

    public void run() {

        try {
            dIn = new DataInputStream(s.getInputStream());
            dOut = new DataOutputStream(s.getOutputStream());
            while (shouldRun) {
                try {
                    while (dIn.available() == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                    String reply = dIn.readUTF();
                    System.out.println(reply);
                } catch (IOException e) {
                    e.printStackTrace();
                    close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
    }

    public void close() {
        try {
            dIn.close();
            dOut.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}