package server;

import lists.Lista;

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
public class Servidor {

    public static Object State;
    public static String ipAddress;
    public static int portI = 8888;
    public static int portO = 9999;
    private File message;
    private Lista cola = new Lista();
    private static ServerSocket servidorI;
    private static ServerSocket servidorO;
    private String last_ip;
    private char counter = 0;


    /**
     * Crea los puertos de entrada y salida de informacion del servidor
     * @throws IOException en case de que los puertos esten ocupados
     */
    private Servidor(File game_settings) throws IOException {
        servidorO = new ServerSocket(portO);
        servidorI = new ServerSocket(portI);
        message = game_settings;
        setIpAdress();

        // Runs a thread to read
        Thread r = new Thread(() -> {
            while (true){read();}
        });
        r.start();

        // Runs a thread to write
        Thread w = new Thread(() -> {
            while (true){
                setFirstClients();
                write();
            }
        });
        w.start();
    }

    /**
     * Clase que inicia el servidor y lo pone a escuchar y enviar
     * @throws IOException en caso de que los puertos esten ocupados
     */
    public static void init(File game_settings) throws IOException {
        new Servidor(game_settings);
    }

    /**
     * Metodo que envia la informacion a los clientes
     */
    public boolean write() {
        try {
            if (message == null){ return false; }
            Socket cliente = servidorO.accept();
            String ip = cliente.getInetAddress().toString();
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            System.out.println(ip + " try to connect");
            cola.addList(ip);

            // Adds the first to clients ips to the queue
            if(cola.get_size() == 0 || (cola.get_size() == 1 && ip.equals(cola.get_index(0)))){
                salida.println("null");
                cliente.close();
                return false;
            }

            // Send message to the others that aren't the first two or is the last one who ask for it
            if((cola.get_size() >= 2 && (!ip.equals(cola.get_index(0)) && !ip.equals(cola.get_index(1)))) || (ip.equals(last_ip))){
                salida.println("none");
                cliente.close();
                return false;
            }

            salida.println(message);
            cliente.close();

            last_ip = ip;
            count_down();
            System.out.println("Server send: " + message);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     */
    private void count_down() {
        counter++;
        if (counter == 2){
            message = null;
            counter = 0;
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

    public static void exit() throws IOException {
        servidorO.close();
        servidorI.close();
    }

    private void setIpAdress() throws UnknownHostException {
         ipAddress = Inet4Address.getLocalHost().getHostAddress();
    }

    private void setFirstClients(){
        if (cola.get_size() == 0){
            write();
            while (!write());
        }
    }
}

