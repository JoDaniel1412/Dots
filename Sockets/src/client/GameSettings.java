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

    public GameSettings(){}

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
        } catch (IOException | InterruptedException e) {
            System.out.println("Couldn't read game_settings.json");
            return false;
        }
    }

    /**
     * Gets the Game Settings in a json format
     * @return a json File
     * @throws IOException in case the mapper fail
     */
    public static File setGameSettings() throws IOException {
        int rows = Board.getInstance().getRows();
        int columns = Board.getInstance().getColumns();
        int time = Timer.getTime_limit();
        return GameSettings.map_settings(rows, columns, time);
    }

    /**
     * Makes a json file with the game settings
     * @param rows size of the Board
     * @param columns size of the Board
     * @param time game duration
     * @return a File in json format
     * @throws IOException in case the mapper fail
     */
    private static File map_settings(int rows, int columns, int time) throws IOException {
        File json = new File("Sockets/game_settings_send.json");
        mapper.writeValue(json, new GameSettings(rows, columns, time));
        return json;
    }

    /**
     * Tells the Game what to do with the message given
     * @param rows size of the Board
     * @param columns size of the Board
     * @param time game duration
     */
    private void analise(int rows, int columns, int time) throws IOException, InterruptedException {
        Board.getInstance().setBoardSize(rows, columns);
        Timer.setTime_limit(time);
        Commands.send_command("start");
    }

    /** Getters and Setters **/
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
