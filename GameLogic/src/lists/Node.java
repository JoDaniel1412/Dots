package lists;

import drawings.Dots;

public class Node<T>{

    private T value = null;
    private Dots dot;

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

    //Pointers State
    private boolean nextState;
    private boolean rightState;
    private boolean leftState;
    private boolean topState;
    private boolean bottomState;
    private boolean top_rightState;
    private boolean top_leftState;
    private boolean bottom_rightState;
    private boolean bottom_leftState;

    //Who made the line
    private int topPlayer;
    private int bottomPlayer;
    private int rightPlayer;
    private int leftPlayer;
    private int topRightPlayer;
    private int bottomRightPlayer;
    private int bottomLeftPlayer;
    private int topLeftPlayer;


    /**
     * Sets a node to contain data
     * @param value a type variable
     */
    public Node(T value){
        this.value = value;
    }

    // @Overload
    public Node(){
        this.nextState = false;
        this.rightState = false;
        this.leftState = false;
        this.topState = false;
        this.bottomState = false;
        this.top_rightState = false;
        this.top_leftState = false;
        this.bottom_rightState = false;
        this.bottom_leftState = false;
    }


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

    public boolean isNextState() {
        return nextState;
    }

    public void setNextState(boolean next) {
        this.nextState = next;
    }

    public boolean isRightState() {
        return rightState;
    }

    public void setRightState(boolean right) {
        this.rightState = right;
    }

    public boolean isLeftState() {
        return leftState;
    }

    public void setLeftState(boolean left) {
        this.leftState = left;
    }

    public boolean isTopState() {
        return topState;
    }

    public void setTopState(boolean top) {
        this.topState = top;
    }

    public boolean isBottomState() {
        return bottomState;
    }

    public void setBottomState(boolean bottom) {
        this.bottomState = bottom;
    }

    public boolean isTop_rightState() {
        return top_rightState;
    }

    public void setTop_rightState(boolean top_right) {
        this.top_rightState = top_right;
    }

    public boolean isTop_leftState() {
        return top_leftState;
    }

    public void setTop_leftState(boolean top_left) {
        this.top_leftState = top_left;
    }

    public boolean isBottom_rightState() {
        return bottom_rightState;
    }

    public void setBottom_rightState(boolean bottom_right) {
        this.bottom_rightState = bottom_right;
    }

    public boolean isBottom_leftState() {
        return bottom_leftState;
    }

    public void setBottom_leftState(boolean bottom_left) {
        this.bottom_leftState = bottom_left;
    }

    public int getTopPlayer() {
        return topPlayer;
    }

    public void setTopPlayer(int topPlayer) {
        this.topPlayer = topPlayer;
    }

    public int getBottomPlayer() {
        return bottomPlayer;
    }

    public void setBottomPlayer(int bottomPlayer) {
        this.bottomPlayer = bottomPlayer;
    }

    public int getRightPlayer() {
        return rightPlayer;
    }

    public void setRightPlayer(int rightPlayer) {
        this.rightPlayer = rightPlayer;
    }

    public int getLeftPlayer() {
        return leftPlayer;
    }

    public void setLeftPlayer(int leftPlayer) {
        this.leftPlayer = leftPlayer;
    }

    public int getTopRightPlayer() {
        return topRightPlayer;
    }

    public void setTopRightPlayer(int topRightPlayer) {
        this.topRightPlayer = topRightPlayer;
    }

    public int getBottomRightPlayer() {
        return bottomRightPlayer;
    }

    public void setBottomRightPlayer(int bottomRightPlayer) {
        this.bottomRightPlayer = bottomRightPlayer;
    }

    public int getTopLeftPlayer() {
        return topLeftPlayer;
    }

    public void setTopLeftPlayer(int topLeftPlayer) {
        this.topLeftPlayer = topLeftPlayer;
    }

    public int getBottomLeftPlayer() {
        return bottomLeftPlayer;
    }

    public void setBottomLeftPlayer(int bottomLeftPlayer) {
        this.bottomLeftPlayer = bottomLeftPlayer;
    }

    public Dots getDot(){
        return dot;
    }

    public void setDot(Dots dot){
        this.dot = dot;
    }
}
