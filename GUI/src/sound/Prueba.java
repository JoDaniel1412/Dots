package sound;

public class Prueba {
    public static void main(String args[]){
        Sound sonido = new Sound("C:\\Users\\sando\\IdeaProjects\\Sonido\\src/tetris.wav");
        while(true) {
            sonido.play();
            sonido.loop();
        }
    }

}