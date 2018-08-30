public class List8 {

    Node start = null;
    int len = 0;

    public void append(){
        len ++;
        if (start == null){
            start = new Node();
        }
        else {
            Node temp = start;

            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node();
        }
    }
}
