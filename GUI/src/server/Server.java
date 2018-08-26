package server;

import server.ServerConecction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //Variables
    ServerSocket ss;
    ArrayList<ServerConecction> connections = new ArrayList<ServerConecction>();
    boolean shouldRun = true;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        //Try de action
        try {
            ss = new ServerSocket(3333);
            while (shouldRun) {
                Socket s = ss.accept();
                ServerConecction sc = new ServerConecction(s, this);
                sc.start();
                connections.add(sc);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
