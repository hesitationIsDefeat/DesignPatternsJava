package FactoryPattern;

public class DungeonBossFactory {
    public DungeonBoss createDungeonBoss(String input) {
        return switch (input.toLowerCase()) {
            case "d" -> new Dragon();
            case "m" -> new Maiar();
            case "o" -> new Orc();
            default -> null;
        };
    }
}
