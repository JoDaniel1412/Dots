package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Client {


    ClientConnection cc;
    public static void main(String [] args){
        new Client();
    }
    public Client(){
        try{
            Socket s = new Socket("localHost", 3333);
            cc = new ClientConnection(s, this);
            cc.start();

            listerForInput();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listerForInput() throws IOException {
        Scanner console = new Scanner(System.in);

        while(true) {
            while (!console.hasNextLine()) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String input = console.nextLine();

            if (input.toLowerCase().equals("quit")) {
                break;
            }

            cc.sendStringToServer(input);
        }
        cc.close();
    }
}