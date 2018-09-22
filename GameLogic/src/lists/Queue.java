package lists;

/**
 * Lista simple con comportamiento de cola
 * @param <T>
 */

public class Queue <T>{
    private SimpleList <T> list;

    public Queue(){
        this.list = new SimpleList<>();
    }

    public void enQueue (T element){
        this.list.addAtEnd(element);
    }
    public Node deQueue (){
        if (this.list.getLarge() != 0) {
            Node first = this.list.getByIndex(0);
            this.list.delete(0);
            return first;
        }
        return null;
    }
    public Node peek(){
        return this.list.getByIndex(0);
    }
    public int GetLarge(){
        return this.list.getLarge();
    }
}
