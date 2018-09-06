package lists;

public class Dot extends Node{
    private boolean nextState;
    private boolean rightState;
    private boolean leftState;
    private boolean topState;
    private boolean bottomState;
    private boolean top_rightState;
    private boolean top_leftState;
    private boolean bottom_rightState;
    private boolean bottom_leftState;

    public Dot (){
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

}
