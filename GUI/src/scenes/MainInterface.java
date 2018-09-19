package scenes;

import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainInterface{

    private static Object main;
    private static Stage window;
    private static String scene = "fxml/menu.fxml";

    public MainInterface(Object main){
        MainInterface.main = main;
    }

    static void close(){
        try {
            Method close = main.getClass().getMethod("close");
            close.invoke(main, (Object[]) null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void setResizable(){
        try {
            Method setResizable = main.getClass().getMethod("setResizable");
            setResizable.invoke(main, (Object[]) null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static void setFullScreen(){
        try {
            Method setFullScreen = main.getClass().getMethod("setFullScreen");
            setFullScreen.invoke(main);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void setScene(String scene_dir){
        MainInterface.scene = scene_dir;
        try {
            Method setScene = main.getClass().getMethod("setScene");
            setScene.invoke(main, (Object[]) null);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static String getScene(){
        return MainInterface.scene;
    }
}
