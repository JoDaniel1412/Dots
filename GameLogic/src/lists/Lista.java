package lists;


import client.Cliente;

public class Lista{
    Nodo first = null;
    int size = 0;

    public Lista(){
        this.size = size;
    }

    public int get_size(){
        return this.size;
    }


    public void addList(Cliente valor){
        this.size += 1;
        if(first == null) {
            first = new Nodo(Cliente valor);
        }else{
            Nodo temp = this.first;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Nodo(Cliente valor);
        }
    }

    public Cliente get_index(int i){
        int cont = 0;
        Nodo pivot = this.first;
        while (cont < i){
            cont += 1;
            pivot = pivot.next;
        }
        return pivot.getValor();

    }
}