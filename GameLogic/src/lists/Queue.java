package lists;

import java.util.ArrayList;

public class Queue <T>{
    private SimpleList <T> list;

    public Queue(){
        this.list = new SimpleList<>();
    }

    public void enQueue (T element){
        this.list.addAtEnd(element);
    }
    public Node deQueue (){
        Node first = this.list.getByIndex(0);
        this.list.delete(0);
        return first;
    }
    public Node peek(){
        return this.list.getByIndex(0);
    }
}
