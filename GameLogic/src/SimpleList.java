public class SimpleList<T> {
    private Node<T> first;
    private int large;

    public SimpleList(){
        this.first = null;
        this.large = 0;
    }

    public void addAtEnd(T value){
        if(this.isEmpty()){
            this.first = new Node<>(value);
            this.large += 1;
        }
        else{
            Node temporal = this.first;
            while (temporal.getNext() != null){
                temporal =  temporal.getNext();
            }
            temporal.setNext(new Node<>(value));
            this.large += 1;
        }
    }

    public boolean isEmpty(){
        Node next = this.getFirst();
        if(next == null){
            return true;
        }
        else {
            return false;
        }
    }

    public Node<T> getFirst() {
        return first;
    }

    public void showLarge() {
        System.out.println(this.getLarge());
    }

    public int getLarge() {
        return large;
    }

    public void clearOut(){
        this.first = null;
    }

    public void showList(){
        Node temporal = this.first;
        while (temporal != null){
            System.out.println(temporal.getValue());
            temporal = temporal.getNext();
        }
    }

    public void delete(int index){
        if (index < this.getLarge()){
            int i = 0;
            Node temporal = this.first;
            while (temporal.getNext() != null){
                i += 1;
                if (i == index){
                    temporal.setNext(temporal.getNext().getNext());
                    this.large -= 1;
                    break;
                }
                else{
                    temporal = temporal.getNext();
                }
            }
        }
        else{
            System.out.println("List out of index");
        }
    }
}
