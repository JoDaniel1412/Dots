package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que se extiende de Thread
 */
public class Servidor extends Thread {
    String message;
    ServerSocket servidorI;
    ServerSocket servidorS;

    /**
     * Crea los puertos de entrada y salida de informacion del servidor
     * @throws IOException
     */
    public Servidor() throws IOException {
        this.servidorI = new ServerSocket(4876);
        this.servidorS = new ServerSocket(4392);
    }

    /**
     * Metodo que envia la informacion a los clientes
     */
    public void iniciar() {
        try {
            Socket cliente = servidorI.accept();
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println(message);
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lee que le envio el cliente
     */
    public void run() {
        try {

            Socket cliente = servidorS.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            //if (entrada.readLine() != null) {
            this.message = entrada.readLine();
            //}
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException {
        Servidor servidor = new Servidor();
        servidor.start();
        while (true) {
            servidor.run();
            servidor.iniciar();

        }
    }
}

