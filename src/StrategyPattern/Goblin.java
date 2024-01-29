package StrategyPattern;

public abstract class Goblin {
    private final String name;
    private int level;
    private Benches benches;

    public Goblin(String name, Benches benches) {
        this.name = name;
        this.level = 0;
        this.benches = benches;
    }

    public String getName() {
        return name;
    }

    public String getBenchStatus() {
        return this.benches.bench();
    }
}
