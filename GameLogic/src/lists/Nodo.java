package lists;


public class Nodo {
    String valor;
    Nodo next;

    public Nodo(java.lang.String valor) {
        this.valor = valor;
        this.next = null;
    }

    public java.lang.String getValor() {
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

