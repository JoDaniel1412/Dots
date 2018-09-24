package client;

import lists.Board;
import logic.Timer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author José Acuña
 */
public class GameSettings {

    private int rows;
    private int columns;
    private int time;
    private static ObjectMapper mapper = new ObjectMapper();

    private GameSettings(int rows, int columns, int time) {
        this.rows = rows;
        this.columns = columns;
        this.time = time;
    }

    /**
     * Tries to decode the json file
     * @param json file to transform in GameSettings object
     * @return boolean if the decode is successful
     */
    static boolean try_read(File json) {
        try {
            GameSettings obj = mapper.readValue(json, GameSettings.class);
            obj.analise(obj.rows, obj.columns, obj.time);
            return true;
        } catch (IOException e) {
            System.out.println("Couldn't read game_settings.json");
            return false;
        }
    }

    /**
     * Sends a command to the server
     * @param rows size of the Board
     * @param columns size of the Board
     * @param time game duration
     * @throws IOException in case the mapper fail
     * @throws InterruptedException in case it couldn't send the message to the server
     */
    public static void send_command(int rows, int columns, int time) throws IOException, InterruptedException {
        File json = new File("Sockets/game_settings_send.json");
        mapper.writeValue(json, new GameSettings(rows, columns, time));
        Cliente.enviarInfo(json);
    }

    /**
     * Tells the Game what to do with the message given
     * @param rows size of the Board
     * @param columns size of the Board
     * @param time game duration
     */
    private void analise(int rows, int columns, int time) throws IOException {
        Board.getInstance().setBoardSize(rows, columns);
        Timer.setTime_limit(time);
    }
}
