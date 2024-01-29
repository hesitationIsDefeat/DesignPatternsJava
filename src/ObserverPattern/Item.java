package ObserverPattern;

class Item {
    private final String name;
    private final ItemType type;
    private double price;

    public Item(String name, ItemType type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public boolean changePrice(double price) {
        if (price >= 0 && this.price != price) {
            this.price = price;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "%s, %s, %.2f".formatted(name, type, price);
    }
}
