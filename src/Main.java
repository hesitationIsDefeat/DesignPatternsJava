import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

interface Publisher {
    void addObserver(Observer o, List<ItemType> items);

    void removeObserver(Observer o);

    void removeObserver(Observer o, ItemType i);

    void notifyObservers(List<ItemType> items);
}

enum ItemType {
    SWORD,
    HEALTH_POTION
}

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

    public double getPrice() {
        return price;
    }
}

interface Observer {
    void getNotified();
}

class ShopKeeper implements Publisher {
    private final Map<ItemType, List<Observer>> observers;

    public ShopKeeper() {
        this.observers = new HashMap<>();
    }

    @Override
    public void addObserver(Observer o, List<ItemType> items) {
        items.forEach(i -> {
            this.observers.computeIfAbsent(i, k -> {
                List<Observer> newList = new ArrayList<>();
                newList.add(o);
                return newList;
            });
            this.observers.computeIfPresent(i, (k, v) -> {
                v.add(o);
                return v;
            });
        });
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.forEach((k, v) -> {
            v.remove(o);
        });
    }

    @Override
    public void removeObserver(Observer o, ItemType i) {
        this.observers.get(i).remove(o);
    }

    @Override
    public void notifyObservers(List<ItemType> items) {
        this.observers.forEach((k, v) -> {
            if (items.contains(k)) v.forEach(Observer::getNotified);
        });
    }
}

class Warrior implements Observer {

    @Override
    public void getNotified() {

    }
}