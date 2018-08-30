public class Node<T>{

    private T value = null;
    // Pointers
    Node next = null;
    Node right = null;
    Node left = null;
    Node top;
    Node bottom;
    Node top_right;
    Node top_left;
    Node bottom_right;
    Node bottom_left;


    /**
     * Sets a node to contain data
     * @param value a type variable
     */
    public Node(T value){
        this.value = value;
    }
    // Overload
    public Node(){}


    /* Setters and Getters*/
    public Node getNext() {return next;}

    public void setNext(Node next) {this.next = next;}

    public T getValue() {return value;}
}
