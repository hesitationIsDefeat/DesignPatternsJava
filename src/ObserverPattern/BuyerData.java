package ObserverPattern;

class BuyerData {
    private final ItemType type;
    private int itemAmount;
    private double valueToBuy;
    private final double valueToLower;

    BuyerData(ItemType type, double valueToBuy, double valueToLower) {
        this.type = type;
        this.itemAmount = 0;
        this.valueToBuy = valueToBuy;
        this.valueToLower = valueToLower;
    }

    public ItemType getType() {
        return type;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public double getValueToBuy() {
        return valueToBuy;
    }

    public double getValueToLower() {
        return valueToLower;
    }

    public void lowerGetValue() {
        this.valueToBuy = Math.max(0.0, this.valueToBuy - this.valueToLower);
    }

    public void incrementItemAmount() {
        this.itemAmount += 1;
    }
}
