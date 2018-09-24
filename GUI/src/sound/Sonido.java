package sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Sonido extends Thread {
    public static void main(String agrs[]){
            File tetris = new File("tetris.WAV");
            playSound(tetris);
    }
    static void playSound(File Sound) {
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);
        }catch(Exception e) {


        }
    }
}

