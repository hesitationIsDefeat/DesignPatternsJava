package ObserverPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShopKeeper shopkeeperGoblinZagzug = new ShopKeeper();
        Warrior joe = new Warrior(shopkeeperGoblinZagzug);
        Wizard jon = new Wizard(shopkeeperGoblinZagzug);
        shopkeeperGoblinZagzug.addObserver(joe, List.of(ItemType.SWORD));
        shopkeeperGoblinZagzug.addObserver(jon, List.of(ItemType.SWORD, ItemType.POTION));
        shopkeeperGoblinZagzug.addItem("Rusty Sword", ItemType.SWORD, 10.0);
        shopkeeperGoblinZagzug.addItem("Silver Sword", ItemType.SWORD, 30.0);
        shopkeeperGoblinZagzug.addItem("Health Potion", ItemType.POTION, 1.00);
        shopkeeperGoblinZagzug.changeItemPrice("Rusty Sword", 9.00);
        System.out.println(joe);
        System.out.println(jon);
    }
}
