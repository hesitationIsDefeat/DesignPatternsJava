package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

class Warrior extends Buyer {
    public Warrior(ShopKeeper shopKeeper) {
        super(50.00, shopKeeper, new ArrayList<>(List.of(
                new BuyerData(ItemType.SWORD, 15.00, 3.00))));
    }
}
