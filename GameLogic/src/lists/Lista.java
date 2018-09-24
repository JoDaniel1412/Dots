package lists;


import java.net.InetAddress;

public class Lista{
    Nodo first = null;
    int size = 0;

    public Lista(){
        this.size = size;
    }

    public int get_size(){
        return this.size;
    }


    public void addList(String valor){
        if(first == null) {
            this.size += 1;
            first = new Nodo(valor);
        }else{
            Nodo temp = this.first;
            if(!temp.getValor().equals(valor)) {
                this.size += 1;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Nodo(valor);
            }
        }
    }

    public String get_index(int i){
        int cont = 0;
        Nodo pivot = this.first;
        while (cont < i){
            cont += 1;
            pivot = pivot.next;
        }
        return pivot.getValor();

    }
}