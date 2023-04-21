import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class OperationToProduct {
    static Scanner sc = new Scanner(System.in);

    //* Searching and returning the index of product p in the list. If not found
    //  * return -1.

    /**
     *
     * @param p
     * @param list
     * @return
     */
    public int index(Product p, MyList<Product> list) {
        Node<Product> current = list.head;
        int index = 0;

        while (current != null && !current.getData().equals(p)) {
            current = current.getNext();
            index++;
        }
        if (current == null) {
            return -1;
        }
        return index;
    }

    //Creating and returning a product with info input from keyboard.

    /**
     *
     * @param originalOut
     * @return
     */
    public Product createProduct(PrintStream originalOut) {
        originalOut.print("Input new ID: ");
        System.out.print("Input new ID: ");
        String bcode = sc.next();
        sc.nextLine();
        System.out.println(bcode);
//        System.out.println();
        originalOut.print("Input Product's Name: ");
        System.out.print("Input Product's Name: ");
        String title = sc.next();
        sc.nextLine();
        System.out.println(title);
//        System.out.println();
        originalOut.print("Input Product's quantity: ");
        System.out.print("Input Product's quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println(quantity);
//        System.out.println();
        originalOut.print("Input Product's price: ");
        System.out.print("Input Product's price: ");
        double price = sc.nextDouble();
        System.out.println(price);
        sc.nextLine();
//        System.out.println();

        Product p = new Product(bcode, title, quantity, price);
        return p;

    }

    //Adding a product to the tail of list, info of the product input from keyboard.

    /**
     *
     * @param list
     * @param originalOut
     */
    public void addLast(MyList<Product> list, PrintStream originalOut) {
        Product p = createProduct(originalOut);
        Node<Product> current = list.head;

        boolean isExist = false;
        while (current != null) {
            if (current.getData().bcode.equals(p.bcode)) {
                isExist = true;
            }
            current = current.getNext();
        }
        if (!isExist) {
            list.insertAtTail(p);
            originalOut.println("\nSản phẩm đã được thêm vào list!\n");
            System.out.println("\nSản phẩm đã được thêm vào list!\n");
        } else {
            originalOut.println("\nID sản phẩm đã tồn tại!\n");
            System.out.println("\nID sản phẩm đã tồn tại!\n");
        }

    }

    //Adding new product to head of Linked List. The info input from keyboard.

    /**
     *
     * @param list
     * @param originalOut
     */
    public void addFirst(MyList<Product> list, PrintStream originalOut) {
        Product p = createProduct(originalOut);
        Node<Product> current = list.head;

        boolean isExist = false;
        while (current != null) {
            if (current.getData().bcode.equals(p.bcode)) {
                isExist = true;
                break;
            }
            current = current.getNext();
        }
        if (!isExist) {
            list.insertToHead(p);
            originalOut.println("Sản phẩm đã được thêm vào list!\n");
            System.out.println("Sản phẩm đã được thêm vào list!\n");
        } else {
            originalOut.println("ID sản phẩm đã tồn tại!\n");
            System.out.println("ID sản phẩm đã tồn tại!\n");
        }
    }

    //Reading all products from the file and insert them to the list at tail.

    /**
     *
     * @param fileName
     * @param list
     * @param originalOut
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list, PrintStream originalOut) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String bcode = data[0];
                String title = data[1];
                int quantity = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                Product p = new Product(bcode, title, quantity, price);
                list.insertAtTail(p);
            }

        } catch (IOException e) {
            originalOut.println("Tệp không tồn tại!");
            System.out.println("Tệp không tồn tại!");
        }
        //do smth
    }

    //Reading all products from the file and insert them to the stack.

    /**
     *
     * @param fileName
     * @param stack
     * @param originalOut
     */
    public void getAllItemsFromFileToStack(String fileName, MyStack<Product> stack, PrintStream originalOut) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String bcode = data[0];
                String title = data[1];
                int quantity = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                Product p = new Product(bcode, title, quantity, price);
                stack.push(p);
            }

        } catch (IOException e) {
            originalOut.println("Tệp không tồn tại!");
            System.out.println("Tệp không tồn tại!");
        } finally {
            try {
                scanner.close();
            } catch (NullPointerException e) {
                //do smth
            }
        }
        displayAllFromStack(stack, originalOut);
    }

    //Reading all products from the file and insert them to the queue.

    /**
     *
     * @param fileName
     * @param queue
     * @param originalOut
     */
    public void getAllItemsFromFileToQueue(String fileName, MyQueue<Product> queue, PrintStream originalOut) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String bcode = data[0];
                String title = data[1];
                int quantity = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                Product p = new Product(bcode, title, quantity, price);
                queue.enqueue(p);
            }

        } catch (IOException e) {
            originalOut.println("Tệp không tồn tại!");
            System.out.println("Tệp không tồn tại!");
        } finally {
            try {
                scanner.close();
            } catch (NullPointerException e) {
                //do smth
            }
        }
        displayAllFromQueue(queue, originalOut);
    }

    //Printing all products of the list to console screen

    /**
     *
     * @param list
     * @param originalOut
     */
    public void displayAll(MyList<Product> list, PrintStream originalOut) {
        originalOut.println("ID   |  Title     |  Quantity  |  price");
        System.out.println("ID   |  Title     |  Quantity  |  price");
        originalOut.println("---------------------------------------");
        System.out.println("---------------------------------------");
        Node<Product> current = list.head;

        while (current != null) {
            originalOut.printf(current.toString());
            System.out.printf(current.toString());
            originalOut.println();
            System.out.println();
            current = current.getNext();
        }
        originalOut.println();
        System.out.println();
//        writeAllItemsToFile("console_output.txt",list);
    }

    //Printing all products of the stack in reverse order

    /**
     *
     * @param stack
     * @param originalOut
     */
    public void displayAllFromStack(MyStack<Product> stack, PrintStream originalOut) {
        originalOut.println("ID   |  Title     |  Quantity  |  price");
        System.out.println("ID   |  Title     |  Quantity  |  price");
        originalOut.println("---------------------------------------");
        System.out.println("---------------------------------------");

        MyStack<Product> reverseStack = new MyStack<>();
        while (!stack.isEmpty()) {
            Product item = stack.pop().getData();
            reverseStack.push(item);
        }

        while (!reverseStack.isEmpty()) {
            Node<Product> current = reverseStack.pop();
            originalOut.printf(current.toString());
            System.out.printf(current.toString());
            originalOut.println();
            System.out.println();
        }

        originalOut.println();
    }

    //Printing all products of the queue in writing order

    /**
     *
     * @param queue
     * @param originalOut
     */
    public void displayAllFromQueue(MyQueue<Product> queue, PrintStream originalOut) {
        originalOut.println("ID   |  Title     |  Quantity  |  price");
        System.out.println("ID   |  Title     |  Quantity  |  price");
        originalOut.println("---------------------------------------");
        System.out.println("---------------------------------------");
        Node<Product> current = queue.head;

        while (current != null) {
            originalOut.printf(current.toString());
            System.out.printf(current.toString());
            originalOut.println();
            System.out.println();
            current = current.getNext();
        }
        originalOut.println();
    }


    //Writing all products from the list to the file

    /**
     *
     * @param fileName
     * @param list
     * @param originalOut
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list, PrintStream originalOut) {
        try (FileWriter file = new FileWriter(fileName)) {
            Node<Product> current = list.head;

            while (current != null) {
                Product p = current.getData();
                file.write(p.bcode + "," + p.title + "," + p.quantity + "," + p.price + "\n");
                current = current.getNext();
            }
            originalOut.println("Successfully write data to the file!\n");
            System.out.println("Successfully write data to the file!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            originalOut.println("NullPointerException");
            System.out.println("NullPointerException");
        }
    }

    //Searching product by ID input from keyboard.

    /**
     *
     * @param list
     * @param originalOut
     */
    public void searchByCode(MyList<Product> list, PrintStream originalOut) {
        originalOut.print("Input the ID to search: ");
        System.out.print("Input the ID to search: ");
        String bcode = sc.next();
        System.out.println(bcode);
        if (list.isEmpty()) {
            originalOut.println("Dãy không có dữ liệu!");
            System.out.println("Dãy không có dữ liệu!");
        } else {
            Node<Product> current = list.head;
            boolean exist = false;
            originalOut.print("Result: ");
            System.out.print("Result: ");
            while (current != null) {
                if (current.getData().bcode.equals(bcode)) {
                    originalOut.printf(current.toString());
                    System.out.printf(current.toString());
                    exist = true;
                    originalOut.println();
                }
                current = current.getNext();
            }
            if (!exist) {
                originalOut.println(-1);
                System.out.println(-1);
            }
            originalOut.println();
            System.out.println();
        }
    }

    //Deleting first product that has the ID input from keyboard from the list.

    /**
     *
     * @param list
     * @param originalOut
     */
    public void deleteByCode(MyList<Product> list, PrintStream originalOut) {
        originalOut.print("Input the bcode to delete: ");
        System.out.print("Input the bcode to delete: ");
        String bcode = sc.next();
        System.out.println(bcode);
        Node<Product> current = list.head;

        while (current != null) {
            if (current.getData().bcode.equals(bcode)) {
                list.deleteElement(current.getData());
                originalOut.println("\nDeleted!\n");
                System.out.println("\nDeleted!\n");
            }
            current = current.getNext();
        }
    }


    //Sorting products in linked list by ID
    public void sortByCode(MyList<Product> list, PrintStream originalOut) {
//        list.selectionSort(1);
        list.insertionSort(2);
        originalOut.println("\nSuccessfully!\n");
        System.out.println("\nSuccessfully!\n");
    }

    //Convert a decimal to a binary number (as integer)
    public int convertToBinary(int i) {
        int result;
        if (i == 0) {
            result = 0;
        } else {
            result = i % 2 + 10 * convertToBinary(i / 2);
        }
        return result;
    }

    //Deleting the product at position
    public void deleteAtPosition(MyList<Product> list, int pos, PrintStream originalOut) {
        if (list.isEmpty()) {
            return;
        }

        Node<Product> pre_pos = list.head;
        int index = 0;

        while (pre_pos != null && index < pos - 1) {
            index++;
            pre_pos = pre_pos.getNext();
        }

        if (pre_pos != null && pre_pos.equals(list.head)) {
            list.head = list.tail = null;
        }

        if (pre_pos != null && pre_pos.getNext() == null){
            originalOut.println("Index is out of list");
        }else if (pre_pos != null && pre_pos.getNext().getNext() != null) {
                pre_pos.setNext(pre_pos.getNext().getNext());
        } else if (pre_pos != null && pre_pos.getNext().getNext() == null) {
            pre_pos.setNext(null);
            list.tail = pre_pos;
        }
    }
}
