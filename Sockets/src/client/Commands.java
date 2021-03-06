package client;

import lists.Board;
import logic.DotsInteraction;
import logic.Timer;
import org.codehaus.jackson.map.ObjectMapper;
import scenes.sGameEnd;
import scenes.sWaiting;
import server.Servidor;

import java.io.IOException;

public class Commands {

    private String command;
    private static ObjectMapper mapper = new ObjectMapper();

    public Commands(){}

    private Commands(String command){
        this.command = command;
    }

    /**
     * Tries to decode the json file
     * @param json file to transform in Commands object
     * @return boolean if the decode is successful
     */
    static boolean try_read(String json) {
        try {
            Commands obj = mapper.readValue(json, Commands.class);
            System.out.println("Read commands.json");
            obj.analise(obj.command);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Sends a command to the server
     * @param message string to send
     * @throws IOException in case the mapper fail
     * @throws InterruptedException in case it couldn't send the message to the server
     */
    public static void send_command(String message) throws IOException, InterruptedException {
        String json = mapper.writeValueAsString(new Commands(message));
        Cliente.enviarInfo(json);
    }

    /**
     * Tells the Game what to do with the message given
     * @param command a specific string
     */
    private void analise(String command) throws IOException{
        if(command.equals("start")){
            sWaiting.pressed_start();
            Timer.init();
        }
        if(command.equals("end")){
            sGameEnd.p1Score = DotsInteraction.getP1Score();
            sGameEnd.p2Score = DotsInteraction.getP2Score();
            Board.getInstance().reset();
            sGameEnd.game_end();
            Servidor.reset();
        }
        if(command.equals("F6")){
            sGameEnd.p1Score = DotsInteraction.getP1Score()+999;
            Board.getInstance().reset();
            sGameEnd.game_end();
            Board.getInstance().reset();
            DotsInteraction.reset_point();
        }
    }

    /** Getters and Setters **/
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
