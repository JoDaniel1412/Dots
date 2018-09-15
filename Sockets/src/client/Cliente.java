package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Jesus Sandoval Morales
 */
public class Cliente extends Thread {


    public Cliente() {
    }

    /**
     * Clase que maneja la logica de comandos
     * @param esta
     * @return un String que verifica el comando recibido
     */
    public String getChar(String esta) {
        String noEsta = "";
        noEsta = esta.substring(0,3);
        String temp;
        if(noEsta.equals("LGC")){//Maneja la logica como tal obteniendo el comando deseado
            //temp = gameLogic();
        }else if(noEsta.equals("WIN")){//Llama a la funcion que dice quie
            //temp = youWin();
        }else if(noEsta.equals("LOS")){
            //temp = youLose;
        }
        return noEsta;
    }

    /**
     * Metodo que Solicita la informacion del servidor
     */
    public void solicitarInfo() {

        try {
            sleep(100);
            Socket conexionServer = new Socket("localHost", 4876);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            getChar(entradaDatos.readLine());
            System.out.println(entradaDatos.readLine());
            conexionServer.close();
        } catch (IOException | InterruptedException a) {
            System.out.println("Error recibiendo datos");
        }
    }

    /**
     * Metodo que envia la informacion al servidor para que este la analice
     * @param message
     */
    public void enviarInfo(String message) {
        try {
            sleep(100);
            Socket conexionServer = new Socket("localHost", 4392);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            salida.println(message);
            conexionServer.close();
        } catch (IOException a) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente c1   = new Cliente();
        while(true) {
            c1.enviarInfo("log 4 2 3 2");
            c1.solicitarInfo();
        }

    }
}