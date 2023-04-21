import java.util.EmptyStackException;

public class MyStack<T extends Product> {
    protected Node<T> head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    //Add item to the head of stack

    /**
     *
     * @param item
     */
    public void push(T item){
        this.head = new Node<T>(item,head);
    }

    //Get first item (in the head)

    /**
     *
     * @return
     * @throws EmptyStackException
     */
    Node<T> top() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return this.head;
    }

    //Delete item (in the head)

    /**
     *
     * @return
     * @throws EmptyStackException
     */
    public Node<T> pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        Node<T> item = head;
        head = head.getNext();
        return item;
    }
}
