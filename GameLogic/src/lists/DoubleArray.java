package lists;

public class DoubleArray <T>{

    private T first;
    private T second;

    public void add(T value){
        if (first == null){
            first = value;
        } else if (second == null){
            second = value;
        }
        System.out.println(value);
    }

    public void clear(){
        first = null;
        second = null;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
