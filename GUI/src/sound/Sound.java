package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sound extends Thread{

    private Clip clip;
    private static Thread audio;

    private Sound(String fileName) {
        //El try primero crea un file el cual ya sabe que tiene que ser una ruta String y los catch son todos los posibles casos de error. Tiene que ser wav
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                // Esta vara carga el archivo como un clip de memoria
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Sound: El archivo deseado no fue encontrado " + fileName);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: URL corrupto: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: El tipo de archivo es invalido o no soportado: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: error de entrada o salida en el sonido: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Linea no valida: " + e);
        }

        // Metodo para reproducir normal, pra reproducir en loop y para pausar la musica
    }

    /**
     * Reproduces a sound file
     * @param file direction of the file in resources/sounds/..
     */
    public static void play(String file){
        audio = new Sound(file);
        audio.start();
    }

    @Override
    public void run() {
        while (true){
            clip.loop(0);
        }
    }
}