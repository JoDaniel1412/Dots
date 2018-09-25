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
public class Servidor extends Thread {
    public static Object State;
    private File message;
    private Lista cola = new Lista();
    private static ServerSocket servidorI;
    private static ServerSocket servidorO;
    public static String ipAddress;
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
     * @param ipAddress
     */
    public boolean write(String ipAddress) {
        try {
            Socket cliente = servidorO.accept();
            String ip = cliente.getInetAddress().toString();
            if(!ip.equals(ipAddress) && !ipAddress.equals("none")){
                return false;
            }
            if(cola.get_size() == 1 && ip.equals(cola.get_index(0))){
                return false;
            }
            cola.addList(ip);
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println(message);
            cliente.close();
            System.out.println("Server send: " + message);
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
            message = new File(entrada.readLine());
            cliente.close();
            //System.out.println("Server receive: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            setFirstClients();
            read();
            write(cola.get_index(0));
            write(cola.get_index(1));
        }
    }

    public static void exit() throws IOException {
        servidor.stop();
        servidorO.close();
        servidorI.close();
    }

    private void setIpAdress() throws UnknownHostException {
         ipAddress = Inet4Address.getLocalHost().getHostAddress();
    }

    private void setFirstClients(){
        if (cola.get_size() == 0){
            write("none");
            while (!write("none"));
        }
    }
}

