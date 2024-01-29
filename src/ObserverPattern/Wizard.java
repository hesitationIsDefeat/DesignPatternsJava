package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

class Wizard extends Buyer {
    public Wizard(ShopKeeper shopKeeper) {
        super(100.00, shopKeeper, new ArrayList<>(List.of(
                new BuyerData(ItemType.SWORD, 10.00, 4.00),
                new BuyerData(ItemType.POTION, 1.00, 0.10))));
    }
}
