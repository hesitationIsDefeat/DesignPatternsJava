package ObserverPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShopKeeper implements Publisher {
    private double gold;
    private final Map<ItemType, List<Observer>> observers;
    private final List<Item> items;
    private Item nextNotification;

    public ShopKeeper() {
        this.gold = 200.00;
        this.observers = new HashMap<>();
        this.items = new ArrayList<>();
        this.nextNotification = null;
    }

    @Override
    public void addObserver(Observer o, List<ItemType> items) {
        items.forEach(i -> {
            this.observers.computeIfPresent(i, (k, v) -> {
                v.add(o);
                return v;
            });
            this.observers.computeIfAbsent(i, k -> {
                List<Observer> newList = new ArrayList<>();
                newList.add(o);
                return newList;
            });
        });
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.forEach((k, v) -> v.remove(o));
    }

    @Override
    public void removeObserver(Observer o, ItemType i) {
        this.observers.get(i).remove(o);
    }

    @Override
    public void notifyObservers() {
        Item notification;
        if ((notification = this.nextNotification) != null) {
            this.observers.get(notification.getType()).forEach(o -> o.getNotified(notification));
            this.nextNotification = null;
        } else {
            System.out.println("No notification to announce");
        }
    }

    public void addItem(String name, ItemType type, double price) {
        if (price >= 0) {
            Item newItem = new Item(name, type, price);
            this.items.add(newItem);
            System.out.printf("Item added: %s%n", newItem);
        } else {
            System.out.println("Price can't be less than 0");
        }
    }

    public void changeItemPrice(String name, double p) {
        this.items.stream()
                .filter(i -> i.getName().equals(name))
                .forEach(i -> {
                    if (i.changePrice(p)) {
                        this.nextNotification = i;
                        notifyObservers();
                    }
                });
    }

    public void sellItem(Item i) {
        System.out.printf("Sold the item: %s%n", i);
        this.gold += i.getPrice();
    }

    public boolean hasItemAvailable(Item item) {
        return this.items.contains(item);
    }
}
