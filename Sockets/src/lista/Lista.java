/**package lista;

public class Lista{
    Node first = null;
    int size = 0;

    public Lista(){
        this.size = size;
    }

    public int get_size(){
        return this.size;
    }


    public void addList(ServerConecction valor){
        this.size += 1;
        if(first == null) {
            first = new Node(valor);
        }else{
            Node temp = this.first;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(valor);
        }
    }

    public ServerConecction get_index(int i){
        int cont = 0;
        Node pivot = this.first;
        while (cont < i){
            cont += 1;
            pivot = pivot.next;
        }
        return pivot.getValor();

    }
}**/