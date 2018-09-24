package lista;

public class Node {
    ServerConecction valor;
    Node next;

    public Node(ServerConecction valor){
        this.valor = valor;
        this.next = null;
    }

    public ServerConecction getValor() {
        return this.valor;
    }

    public void setValor(ServerConecction valor) {
        this.valor = valor;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
