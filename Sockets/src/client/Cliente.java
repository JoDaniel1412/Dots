package client;

import logic.DotsInteraction;

import java.io.*;
import java.net.Socket;

/**
 * @author Jesus Sandoval Morales
 * @author José Acuña
 */
public class Cliente extends Thread {

    private static java.lang.String ip;
    private static int portI;
    private static int portO;
    private static Thread cliente;
    private static boolean turn;

    private Cliente(java.lang.String msg) {
        super(msg);
    }

    /**
     * Inicia el thread
     * @param ip direccion del servidor
     * @param portI puerto que entra al servidor y salida del cliente
     * @param portO pueto de salida del servidor y entrada del cliente
     */
    public static void init(java.lang.String ip, int portI, int portO){
        cliente = new Cliente("client");
        ((Cliente) cliente).setIp(ip);
        ((Cliente) cliente).setPortI(portO);
        ((Cliente) cliente).setPortO(portI);
        cliente.start();
    }
    /**
     * Metodo que Solicita la informacion del servidor
     */
    public static void solicitarInfo() throws IOException, InterruptedException {
        sleep(100);
        Socket conexionServer = new Socket(ip, portI);
        BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
        File message = new File(entradaDatos.readLine());
        conexionServer.close();
        //System.out.println("Client receive: " + message);
        analise(message);
    }

    /**
     * Metodo que envia la informacion al servidor para que este la analice
     * @param message archivo Json a enviar
     */
    public static void enviarInfo(File message) throws InterruptedException, IOException {
        sleep(100);
        Socket conexionServer = new Socket(ip, portO);
        PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
        salida.println(message);
        conexionServer.close();
        //System.out.println("Client send: " + message);
    }

    /**
     * Ejecucion del thread
     */
    public void run(){
        while (true) {
            try {
                sleep(1000);
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

    private static void analise(File message){
        if (!DotsInteraction.try_read(message)){
            if(!Commands.try_read(message)){
                System.out.println("Couldn't read Json");
            }
        }
    }

    /** Getters and Setters **/
    private void setIp(java.lang.String ip){
        Cliente.ip = ip;
    }

    private void setPortI(int port){
        Cliente.portI = port;
    }

    private void setPortO(int port){
        Cliente.portO = port;
    }

    public static boolean isTurn() {
        return turn;
    }

    public static void setTurn(boolean turn) {
        Cliente.turn = turn;
    }
}