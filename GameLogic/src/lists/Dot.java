package lists;

public class Dot extends Node{
    private boolean next;
    private boolean right;
    private boolean left;
    private boolean top;
    private boolean bottom;
    private boolean top_right;
    private boolean top_left;
    private boolean bottom_right;
    private boolean bottom_left;

    public Dot (){
        this.next = false;
        this.right = false;
        this.left = false;
        this.top = false;
        this.bottom = false;
        this.top_right = false;
        this.top_left = false;
        this.bottom_right = false;
        this.bottom_left = false;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean isTop_right() {
        return top_right;
    }

    public void setTop_right(boolean top_right) {
        this.top_right = top_right;
    }

    public boolean isTop_left() {
        return top_left;
    }

    public void setTop_left(boolean top_left) {
        this.top_left = top_left;
    }

    public boolean isBottom_right() {
        return bottom_right;
    }

    public void setBottom_right(boolean bottom_right) {
        this.bottom_right = bottom_right;
    }

    public boolean isBottom_left() {
        return bottom_left;
    }

    public void setBottom_left(boolean bottom_left) {
        this.bottom_left = bottom_left;
    }

}
