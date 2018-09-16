package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que se extiende de Thread
 * @author Jesus Sandoval Morales
 * @author José Acuña
 */
public class Servidor extends Thread {
    private String message;
    private static ServerSocket servidorI;
    private static ServerSocket servidorS;
    private static Thread servidor;

    /**
     * Crea los puertos de entrada y salida de informacion del servidor
     * @throws IOException en case de que los puertos esten ocupados
     */
    private Servidor(String msg) throws IOException {
        super(msg);
        servidorI = new ServerSocket(4876);
        servidorS = new ServerSocket(4392);
    }

    /**
     * Clase que inicia el servidor y lo pone a escuchar y enviar
     * @throws IOException en caso de que los puertos esten ocupados
     */
    public static void init() throws IOException {
        servidor = new Servidor("server");
        servidor.start();
    }

    /**
     * Metodo que envia la informacion a los clientes
     */
    public void write() {
        try {
            Socket cliente = servidorI.accept();
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println(message);
            cliente.close();
            System.out.println("Server send: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lee que le envio el cliente
     */
    public void read() {
        try {
            Socket cliente = servidorS.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            message = entrada.readLine();
            cliente.close();
            System.out.println("Server receive: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            read();
            write();
        }
    }

    public static void exit() throws IOException {
        servidor.stop();
        servidorI.close();
        servidorS.close();
    }
}

