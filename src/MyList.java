public class MyList<T extends Product> {
    Node<T> head;
    Node<T> tail;

    public MyList() {

    }

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    //Checking if this list is empty
    public boolean isEmpty() {
        return (head == null);
    }

    //Returning the length of this list

    /**
     *
     * @return
     */
    public int length() {
        if (isEmpty()) return 0;

        int length = 0;
        Node<T> current = this.head;

        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;

    }

    //Insert an item to the head of this list

    /**
     *
     * @param item
     */
    public void insertToHead(T item) {
        this.head = new Node<>(item, this.head);
    }

    //Insert an item at the tail of this list

    /**
     *
     * @param item
     */
    public void insertAtTail(T item) {

        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            this.head = this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    //Insert an item after a position to this list

    /**
     *
     * @param position
     * @param item
     */
    public void insertAfterPosition(int position, T item) {
        int pos = 0;
        Node<T> current = this.head;
        while (pos < position) {
            pos++;
            current = current.getNext();
        }
        Node<T> newNode = new Node<T>(item, current.getNext());
        current.setNext(newNode);
    }

    //Insert an item after a position to this list

    /**
     *
     * @param checkNode
     * @param insertNode
     */
    public void insertBeforeNode(Node<T> checkNode, Node<T> insertNode) {
        if (isEmpty()) return;

        Node<T> prevCurrent = null;
        Node<T> current = this.head;
        while (current != null && !current.equals(checkNode)) {
            prevCurrent = current;
            current = current.getNext();
        }
        deleteElement(insertNode.getData());
        insertNode.setNext(checkNode);
        if (prevCurrent != null)
            prevCurrent.setNext(insertNode);
        else {
            this.head = insertNode;
        }
    }

    //Deleting the tail of this list

    /**
     *
     */
    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else if (length() == 1) {
            clear();
        } else {
            Node<T> current = this.head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            this.tail = current;
        }
    }

    //Searching and deleting an item from this list by comparing the ID of items

    /**
     *
     * @param item
     */
    public void deleteElement(T item) {
        Node<T> prev = null;
        Node<T> current = this.head;
        if (current != null && current.getData().bcode.equals(item.bcode)) {
            this.head = head.getNext();
            return;
        }

        while (current != null && !current.getData().bcode.equals(item.bcode)) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) return;

        if (prev != null) {
            prev.setNext(current.getNext());
            if(current.getNext() == null){
                this.tail = prev;
            }
        }

    }

    //Swaping two nodes [firstNode] and [secondNode]

    /**
     *
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {

        if (firstNode.equals(secondNode)) return;

        Node<T> prevNote1 = null;
        Node<T> currentNote1 = this.head;
        Node<T> prevNote2 = null;
        Node<T> currentNote2 = this.head;

        while (currentNote1 != null && !currentNote1.equals(firstNode)) {
            prevNote1 = currentNote1;
            currentNote1 = currentNote1.getNext();
        }

        while (currentNote2 != null && !currentNote2.equals(secondNode)) {
            prevNote2 = currentNote2;
            currentNote2 = currentNote2.getNext();
        }
        if (currentNote1 == null || currentNote2 == null)
            return;

        if (prevNote1 != null) {
            prevNote1.setNext(secondNode);
        } else {
            this.head = secondNode;
        }

        if (prevNote2 != null) {
            prevNote2.setNext(firstNode);
        } else {
            this.head = firstNode;
        }

        Node<T> temp = currentNote1.getNext();
        currentNote1.setNext(currentNote2.getNext());
        currentNote2.setNext(temp);
    }


    //Bubble Sort using Recursion

    /**
     *
     */
    void bubbleSort() {
        Node<T> current;
        if (isEmpty() || length() == 1) return;
        boolean swap = false;
        current = this.head;
        while (current != null && current.getNext() != null) {
            if (current.getData().bcode.compareTo(current.getNext().getData().bcode) > 0) {
                swap(current, current.getNext());
                swap = true;
            }
            current = current.getNext();
        }
        if (swap) bubbleSort();
    }

    //Selection Sort using Recursion

    /**
     *
     * @param i
     */
    void selectionSort(int i) {
        Node<T> current;
        Node<T> temp;
        if (isEmpty() || length() == 1) return;
        if (i == length()) return;

        current = this.head;
        temp = this.head;
        int index = 1;
        while (index < i) {
            index++;
            current = current.getNext();
            temp = temp.getNext();
        }

        String min = current.getData().bcode;
        while (current != null) {
            if (current.getData().bcode.compareTo(min) < 0) {
                min = current.getData().bcode;
            }
            current = current.getNext();
        }
        if (!min.equals(temp.getData().bcode)) {
            Node<T> toSwap = this.head;

            while (toSwap != null) {
                if (toSwap.getData().bcode.equals(min)) {
                    swap(temp, toSwap);
                }
                toSwap = toSwap.getNext();
            }
        }
        selectionSort(i + 1);
    }

    //Insertion Sort using Recursion

    /**
     *
     * @param i
     */
    void insertionSort(int i) {
        if (isEmpty() || length() == 1) return;
//        if(i == length()) return;

        Node<T> current = this.head;
        int index = 1;
        while (current != null && index < i) {
            index++;
            current = current.getNext();
        }

        if (current == null) return;
        Node<T> temp = this.head;
        index = 1;
        while (index < i) {
            if (temp.getData().bcode.compareTo(current.getData().bcode) > 0) {
                insertBeforeNode(temp, current);
                break;
            }
            index++;
            temp = temp.getNext();
        }
        insertionSort(i + 1);
    }

    //Deleting all items in the list

    /**
     *
     */
    public void clear() {
        this.head = this.tail = null;
    }

}
