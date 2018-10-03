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
public class Servidor extends Thread{

    public static Object State;
    public static String ipAddress;
    public static int portI = 8888;
    public static int portO = 9999;
    private static String message;
    private static String saved_settings;
    private static Lista cola = new Lista();
    private static ServerSocket servidorI;
    private static ServerSocket servidorO;
    private static String last_ip;
    private static int counter = 0;
    private static Thread in;
    private static Thread out;


    /**
     * Crea los puertos de entrada y salida de informacion del servidor
     * @throws IOException en case de que los puertos esten ocupados
     * @param game_settings host game settings
     */
    private Servidor(String game_settings) throws IOException {
        servidorO = new ServerSocket(portO);
        servidorI = new ServerSocket(portI);
        message = game_settings;
        saved_settings = game_settings;
        setIpAdress();

        // Runs a thread to read
        in = new Thread(() -> {
            while (true){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                read();}
        });
        in.start();

        // Runs a thread to write
        out = new Thread(() -> {
            while (true){
                setFirstClients();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                write();
            }
        });
        out.start();
    }

    /**
     * Clase que inicia el servidor y lo pone a escuchar y enviar
     * @throws IOException en caso de que los puertos esten ocupados
     */
    public static void init(String game_settings) throws IOException {
        new Servidor(game_settings);
    }

    /**
     * Metodo que envia la informacion a los clientes
     * @return boolean if the message has been send
     */
    public boolean write() {
        try {
            if (message == null){ return false; }
            Socket cliente = servidorO.accept();
            String ip = cliente.getInetAddress().toString();
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            System.out.println(ip + " added to the queue");
            cola.addList(ip);

            // Adds the first client ip to the queue
            if(cola.get_size() == 1){
                salida.println("null");
                cliente.close();
                return false;
            }

            // Send message to the others that aren't the first two
            if((cola.get_size() >= 2 && (!ip.equals(cola.get_index(0)) && !ip.equals(cola.get_index(1))))){
                salida.println("none");
                cliente.close();
                return false;
            }

            // Checks if the last client who received info is different to this one
            if (ip.equals(last_ip)){
                salida.println("none");
                cliente.close();
                return false;
            }

            salida.println(message);
            cliente.close();

            last_ip = ip;
            count_down();
            //System.out.println("Server send: " + message);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Metodo que lee que le envio el cliente
     */
    public void read() {
        try {
            Socket cliente = servidorI.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            message = entrada.readLine();
            cliente.close();
            counter = 0;
            //System.out.println("Server receive: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exit() throws IOException {
        if (servidorO == null){
            return;
        }
        servidorO.close();
        servidorI.close();
        in.stop();
        out.stop();
    }

    public static void reset(){
        message = saved_settings;
        cola.delete_second();
    }

    private void setIpAdress() throws UnknownHostException {
         ipAddress = Inet4Address.getLocalHost().getHostAddress();
    }

    private void count_down() {
        counter++;
        if (counter == 2){
            message = null;
            counter = 0;
        }
    }

    private void setFirstClients(){
        if (cola.get_size() == 0){
            write();
            counter = 0;
            while (!write());
            counter = 0;
        }
    }
}

