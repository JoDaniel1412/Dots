package lists;


public class Nodo {
    String valor;
    Nodo next;

    public Nodo(String valor) {
        this.valor = valor;
        this.next = null;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getNext() {
        return this.next;
    }
}

    /**public void setNext(Node next) {
        this.next = next;
    }
}**/

