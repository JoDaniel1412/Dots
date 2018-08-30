import javafx.scene.Scene;

abstract class ScenesFormat {
    static int width = 700;
    static int height = 800;

    static Scene run() {
        return null;
    }

    static int getWidth(){return width;}
    static void setWidth(int width){ScenesFormat.width = width;}
    static int getHeight(){return height;}
    static void setHeight(int height){ScenesFormat.height = height;}
}
