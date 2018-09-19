package client;

import org.codehaus.jackson.map.ObjectMapper;

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

    public Commands(String command){
        this.command = command;
    }

    /**
     * Tries to decode the json file
     * @param json file to transform in Commands object
     * @return boolean if the decode is successful
     */
    public static boolean try_read(File json) {
        try {
            Commands obj = mapper.readValue(json, Commands.class);
            obj.analise(obj.command);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    /**
     * Tells the Game what to do with the message given
     * @param command a specific string
     */
    private void analise(String command){}


    /** Getters and Setters **/
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
