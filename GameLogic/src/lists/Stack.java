package lists;

public class Stack <T>{
    private SimpleList<T> innerList;
    public Stack (){
        this.innerList = new SimpleList<>();
    }
    public void push (T element){
        this.innerList.addAtBeginning(element);
    }

    public Node pop(){
        Node top = this.innerList.getByIndex(0);
        this.innerList.delete(0);
        return top;
    }
    public Node peek(){
        return this.innerList.getByIndex(0);
    }
}

