public class MyQueue<T extends Product> {
    Node<T> head;
    Node<T> tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    //Get item in the head of queue

    /**
     *
     * @return
     * @throws Exception
     */
    public Node<T> front() throws Exception{
        if(isEmpty()) throw new Exception();
        return head;
    }

    //Delete item (in the head of queue)

    /**
     *
     * @return
     * @throws Exception
     */
    public Node<T> dequeue() throws Exception{
        if(isEmpty()) throw new Exception();
        Node<T> item = head;
        head = head.getNext();
        if(head == null) tail = null;
        return item;
    }

    //Add item (in the tail of queue)

    /**
     *
     * @param item
     */
    public void enqueue(T item){
        if(isEmpty()) {
            this.head = this.tail = new Node<>(item,null);
        }else {
            tail.setNext(new Node<>(item,null));
            this.tail = tail.getNext();
        }

    }
}
