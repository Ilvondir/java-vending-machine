public class Drink implements Product {
    private final String producer, name, number;
    private final double price, volume;
    private final int remaining;

    public Drink(String producer, String name, String number, double price, double volume, int remaining) {
        this.producer = producer;
        this.name = name;
        this.number = number;
        this.price = price;
        this.volume = volume;
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

    public double getVolume() {
        return volume;
    }

    public int getRemaining() {
        return remaining;
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
}
