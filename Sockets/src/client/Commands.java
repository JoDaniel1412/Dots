package client;

import logic.Timer;
import org.codehaus.jackson.map.ObjectMapper;
import scenes.sWaiting;
import java.io.File;
import java.io.IOException;

public class Commands {

    /**
     * start
     * exit
     * surrender
     */
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
    static boolean try_read(File json) {
        try {
            Commands obj = mapper.readValue(json, Commands.class);
            obj.analise(obj.command);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
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
        File json = new File("Sockets/command_send.json");
        mapper.writeValue(json, new Commands(message));
        Cliente.enviarInfo(json);
    }

    /**
     * Tells the Game what to do with the message given
     * @param command a specific string
     */
    private void analise(String command) throws IOException {
        if(command.equals("start")){
            sWaiting.pressed_start();
            Timer.init();
        }
        if(command.equals("end")){
            System.out.println("Finish");
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