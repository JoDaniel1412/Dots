package server;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Clase que se extiende de Thread
 * @author Jesus Sandoval Morales
 * @author José Acuña
 */
public class Servidor extends Thread {
    private File message;
    private static ServerSocket servidorI;
    private static ServerSocket servidorO;
    public static String ipAdress;
    public static int portI = 8888;
    public static int portO = 9999;
    private static Thread servidor;

    /**
     * Crea los puertos de entrada y salida de informacion del servidor
     * @throws IOException en case de que los puertos esten ocupados
     */
    private Servidor(String msg) throws IOException {
        super(msg);
        servidorO = new ServerSocket(portO);
        servidorI = new ServerSocket(portI);
        setIpAdress();
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
            Socket cliente = servidorO.accept();
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
            Socket cliente = servidorI.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            message = new File(entrada.readLine());
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
        servidorO.close();
        servidorI.close();
    }

    private void setIpAdress() throws UnknownHostException {
         ipAdress = Inet4Address.getLocalHost().getHostAddress();
    }
}

