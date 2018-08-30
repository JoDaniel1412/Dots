package lists;

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

    // @Overload
    public Node(){}


    /** Setters and Getters **/
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public Node getTop_right() {
        return top_right;
    }

    public void setTop_right(Node top_right) {
        this.top_right = top_right;
    }

    public Node getTop_left() {
        return top_left;
    }

    public void setTop_left(Node top_left) {
        this.top_left = top_left;
    }

    public Node getBottom_right() {
        return bottom_right;
    }

    public void setBottom_right(Node bottom_right) {
        this.bottom_right = bottom_right;
    }

    public Node getBottom_left() {
        return bottom_left;
    }

    public void setBottom_left(Node bottom_left) {
        this.bottom_left = bottom_left;
    }
}
