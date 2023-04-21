import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class AS2_Main {
    static Scanner scanner = new Scanner(System.in);

    //Checking type of user's input

    /**
     *
     * @param scanner
     * @return
     */
    public static int functionValidation(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("**Invalid choice.Number only!");
            System.out.print("Choice: ");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     *
     * @param originalOut
     */
    public static void showMenu(PrintStream originalOut){
        originalOut.println("Choose one of this options: ");
        System.out.println("Choose one of this options: ");
        originalOut.println("Product list:");
        System.out.println("Product list:");
        originalOut.println("1. Load data from file and display");
        System.out.println("1. Load data from file and display");
        originalOut.println("2. Input & add to the end.");
        System.out.println("2. Input & add to the end.");
        originalOut.println("3. Display data");
        System.out.println("3. Display data");
        originalOut.println("4. Save product list to file");
        System.out.println("4. Save product list to file");
        originalOut.println("5. Search by ID");
        System.out.println("5. Search by ID");
        originalOut.println("6. Delete by ID");
        System.out.println("6. Delete by ID");
        originalOut.println("7. Sort by ID");
        System.out.println("7. Sort by ID");
        originalOut.println("8. Convert to Binary");
        System.out.println("8. Convert to Binary");
        originalOut.println("9. Load to stack and display");
        System.out.println("9. Load to stack and display");
        originalOut.println("10. Load to queue and display");
        System.out.println("10. Load to queue and display");
        originalOut.println("0. Exit\n");
        System.out.println("0. Exit\n");
        originalOut.print("Choice = ");
        System.out.print("Choice = ");

    }

    public static void main(String[] args) {
        int choice = 0;
        OperationToProduct operation = new OperationToProduct();
        MyList<Product> list = new MyList<>();
        MyStack<Product> stack = new MyStack<>();
        MyQueue<Product> queue = new MyQueue<>();
        try{
            // Save original out stream.
            PrintStream originalOut = System.out;
            //// Create a new file output stream.
            PrintStream out = new PrintStream(new FileOutputStream("console_output.txt"));
            // Redirect standard out to file.
            System.setOut(out);
        while (true){
            showMenu(originalOut);
            //Asking user to re-enter choice when the type off input is wrong
            choice = functionValidation(scanner);
            System.out.println(choice);
            //Thoát
            if(choice == 0){
                originalOut.println("Thanks and goodbye!!!");
                System.out.println("Thanks and goodbye!!!");
                break;
            }
            switch (choice){
                //Load data from file and display
                case 1:
                    operation.getAllItemsFromFile("data.txt",list,originalOut);
                    operation.displayAll(list,originalOut);
                    originalOut.println("Successfully!\n");
                    System.out.println("Successfully!\n");
                    break;
                //Input & add to the end.
                case 2:
                    operation.addLast(list,originalOut);
                    break;
                //Display data
                    case 3:
                    operation.displayAll(list,originalOut);
                    break;
                //Save product list to file.
                    case 4:
                    operation.writeAllItemsToFile("data.txt",list,originalOut);
                    break;
                //Search by ID
                    case 5:
                    operation.searchByCode(list,originalOut);
                    break;
                //Delete by ID
                    case 6:
                    operation.deleteByCode(list,originalOut);
                    break;
                //Sort by ID (Using recursion)
                    case 7:
                    operation.sortByCode(list,originalOut);
                    break;
                //Convert to Binary
                case 8:
                    System.out.print("Quantity of first product = ");
                    originalOut.print("Quantity of first product = ");
                    int quantity = list.head.getData().quantity;
                    originalOut.print(quantity);
                    System.out.print(quantity);
                    originalOut.println(" => (" + operation.convertToBinary(quantity) +")");
                    System.out.println(" => (" + operation.convertToBinary(quantity) +")");
                    System.out.println();
                    originalOut.println();
                    break;
                //Load to stack and display
                case 9:
                    operation.getAllItemsFromFileToStack("data.txt",stack,originalOut);
                    break;
                //Load to queue and display.
                case 10:
                    operation.getAllItemsFromFileToQueue("data.txt",queue,originalOut);
                    break;
                default:
                    System.out.println("**Invalid choice.Try again");
                    originalOut.println("**Invalid choice.Try again");
            }
        }
            System.setOut(originalOut);
        }catch (IOException e){
            System.out.println("Error during reading/writing");
        }
    }
}