package media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {

    public static void play(String sound){
        //Media url = new Media(sound);
        Media url = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(url);
        mediaPlayer.play();
    }
}
