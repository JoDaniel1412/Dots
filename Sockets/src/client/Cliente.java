package client;

import drawings.DotsInteraction;
import java.io.*;
import java.net.Socket;

/**
 * @author Jesus Sandoval Morales
 * @author José Acuña
 */
public class Cliente extends Thread {

    private static String ip = "localHost";
    private static int port = 8888;
    private static Thread cliente;

    private Cliente(String msg) {
        super(msg);
    }

    /**
     * Inicializa el thread
     */
    public static void init(){
        cliente = new Cliente("server");
        cliente.start();
    }
    /**
     * Metodo que Solicita la informacion del servidor
     */
    public static void solicitarInfo() throws IOException, InterruptedException {
        sleep(100);
        Socket conexionServer = new Socket(ip, 4876);
        BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
        String message = entradaDatos.readLine();
        conexionServer.close();
        System.out.println("Client receive: " + message);
        DotsInteraction.analise_dots(message);
    }

    /**
     * Metodo que envia la informacion al servidor para que este la analice
     * @param message archivo Json a enviar
     */
    public static void enviarInfo(File message) throws InterruptedException, IOException {
        sleep(100);
        Socket conexionServer = new Socket(ip, 4392);
        PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
        salida.println(message);
        conexionServer.close();
        System.out.println("Client send: " + message);
    }

    /**
     * Ejecucion del thread
     */
    public void run(){
        while (true) {
            try {
                Cliente.solicitarInfo();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Finaliza el thread
     */
    public static void exit(){
        cliente.stop();
    }
}