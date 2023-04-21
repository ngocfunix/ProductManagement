import java.io.Serializable;

public class Node<T extends Product> implements Serializable {
    T data;
    Node<T> next;

    private static final long serialVersionUID = 1L;

    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
