public class Drink implements Product {
    private String producer, name, number;
    private double price, volume;
    private int remaining;

    public Drink(String producer, String name, String number, double price, double volume, int remaining) {
        this.producer = producer;
        this.name = name;
        this.number = number;
        this.price = price;
        this.volume = volume;
        this.remaining = remaining;
    }

    public String toString() {
        return "Drink{" +
                "producer='" + producer + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", volume=" + volume +
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
