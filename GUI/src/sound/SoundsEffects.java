package sound;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SoundsEffects extends Thread{

    private Clip clip1;
    private static int loops1 = 0;
    public static Thread audio;

    private SoundsEffects(String fileName) {
        //El try primero crea un File el cual ya sabe que tiene que ser una ruta String y los catch son todos los posibles casos de error. Tiene que ser wav
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                // Esta vara carga el archivo como un clip1 de memoria
                clip1 = AudioSystem.getClip();
                clip1.open(sound);
            }
            else {
                System.out.println("Sound: El archivo deseado no fue encontrado " + fileName);
            }
        }
        catch (MalformedURLException e) {
            //e.printStackTrace();
            System.out.println("Sound: URL corrupto: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            //e.printStackTrace();
            System.out.println("Sound: El tipo de archivo es invalido o no soportado: " + e);
        }
        catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Sound: error de entrada o salida en el sonido: " + e);
        }
        catch (LineUnavailableException e) {
            //e.printStackTrace();
            System.out.println("Sound: Linea no valida: " + e);
        }

        // Metodo para reproducir normal, pra reproducir en loop y para pausar la musica
    }

    /**
     * Reproduces a sound file
     * @param file direction of the file in resources/sounds/..
     */
    public static void play(String file, int loops){
        audio = new SoundsEffects(file);
        SoundsEffects.loops1 = loops;
        audio.start();
    }

    @Override
    public void run() {
        while (true){
            clip1.loop(loops1);
        }
    }
}