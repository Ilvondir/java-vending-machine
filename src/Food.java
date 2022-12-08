public class Food implements Product {
    private String producer, name, number;
    private double price;
    private int remaining;

    public Food(String producer, String name, String number, double price, int remaining) {
        this.producer = producer;
        this.name = name;
        this.number = number;
        this.price = price;
        this.remaining = remaining;
    }

    public String getProducer() {
        return producer;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public int getRemaining() {
        return remaining;
    }

    public String toString() {
        return "Food{" +
                "producer='" + producer + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", remaining=" + remaining +
                '}';
    }

    public String buyOne() {
        if (this.remaining>0) {
            this.remaining--;
            return "Udalo sie zakupic produkt.";
        }

        return "Nie udalo sie zakupic produktu.";
    }
}
