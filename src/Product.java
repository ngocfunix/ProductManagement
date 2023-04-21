import java.io.Serializable;

public class Product implements Serializable {
    String bcode;
    String title;
    int quantity;
    double price;

    private static final long SerialVersionUID = 2L;

    public Product() {
    }

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s%-8s%s%8s%s%5s", bcode +
                "  |  ",title,"  |  ",quantity, "  |  ",price);
    }
}
