package ObserverPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Buyer implements Observer {
    private static int idTracker = 0;
    final int id;
    double gold;
    final ShopKeeper shopKeeper;
    final List<Item> items;
    final List<ItemType> interestedItemTypes;
    final Map<ItemType, BuyerData> itemManagementData;

    public Buyer(double gold, ShopKeeper shopKeeper, List<BuyerData> buyerDataList) {
        this.id = idTracker++;
        this.gold = gold;
        this.shopKeeper = shopKeeper;
        this.items = new ArrayList<>();
        this.interestedItemTypes = new ArrayList<>();
        this.itemManagementData = new HashMap<>();
        for (BuyerData buyerData : buyerDataList) {
            var type = buyerData.getType();
            this.interestedItemTypes.add(type);
            this.itemManagementData.put(type, buyerData);
        }
    }

    @Override
    public void getNotified(Item i) {
        if (interestedItemTypes.contains(i.getType())) buyOrWait(i);
    }

    private void buyOrWait(Item i) {
        var itemName = i.getName();
        var itemPrice = i.getPrice();
        var itemType = i.getType();
        System.out.printf("Buyer %d got notified about %s that costs %.2f%n", this.id, itemName, itemPrice);
        var currentData = this.itemManagementData.get(itemType);
        while (itemPrice <= currentData.getValueToBuy()) {
            if (shopKeeper.hasItemAvailable(i)) {
                if (this.gold >= itemPrice) {
                    shopKeeper.sellItem(i);
                    this.items.add(i);
                    this.gold -= itemPrice;
                    System.out.printf("Buyer no %d bought a %s for %.2f%n", this.id, itemName, itemPrice);
                } else {
                    System.out.printf("Buyer no %d doesn't have enough money for purchase%n", this.id);
                }
            } else {
                System.out.printf("The shopkeeper doesn't have the item: %s%n", i);
            }
            currentData.lowerGetValue();
        }
    }

    @Override
    public String toString() {
        return "Buyer %d:%n\tGold: %.2f%n\tItems: %s%n\tManagementData: %s".formatted(
                this.id, this.gold, this.items, this.itemManagementData);
    }
}
