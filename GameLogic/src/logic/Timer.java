package logic;

import client.Commands;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timer extends Thread{

    private static Thread timer;
    private static int time;
    private static int time_limit = 240;

    private Timer(String msg){ super(msg);}

    /**
     * Start the Thread
     */
    public static void init(){
        timer = new Timer("clock");
        timer.start();
        time = getCurrentTime();
    }

    /**
     * Gets the deference between the time when the thread started to this moment
     * @return an integer of the time
     */
    public static int getTimeLapse(){
        return getCurrentTime() - time;
    }

    /**
     * Gets the current time in the machine
     * @return an int of the time in minutes whit seconds
     */
    private static int getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String time_formatted = sdf.format(cal.getTime()).replace(":","");
        return Integer.parseInt(time_formatted);
    }

    public void run(){
        while (true) {
            try {
                sleep(1000);
                if (getTimeLapse() >= time_limit){
                    Commands.send_command("end");
                    timer.stop();
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Finaliza el thread
     */
    public static void exit(){
        timer.stop();
    }

    /** Getters and Setters **/
    public static int getTime_limit() {
        return time_limit;
    }

    public static void setTime_limit(int time_limit) {
        Timer.time_limit = time_limit;
    }
}
