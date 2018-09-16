package client;

import java.io.*;
import java.net.Socket;

/**
 * @author Jesus Sandoval Morales
 */
public class Cliente extends Thread {

    static String ip = "localHost";
    static int port = 8888;

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
    public static String solicitarInfo() throws IOException, InterruptedException {
        sleep(100);
        Socket conexionServer = new Socket(ip, 4876);
        BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
        String message = entradaDatos.readLine();
        conexionServer.close();
        System.out.println(message);
        return message;
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
    }
}