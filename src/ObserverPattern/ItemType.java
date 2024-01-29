package ObserverPattern;

enum ItemType {
    SWORD,
    POTION;

    @Override
    public String toString() {
        return switch (this) {
            case SWORD -> "Sword";
            case POTION -> "Potion";
        };
    }
}
