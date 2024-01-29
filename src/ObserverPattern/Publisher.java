package ObserverPattern;

import java.util.List;

public interface Publisher {
    void addObserver(Observer o, List<ItemType> items);

    void removeObserver(Observer o);

    void removeObserver(Observer o, ItemType i);

    void notifyObservers();
}
