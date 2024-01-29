package StrategyPattern;

public class SmallGoblin extends Goblin {
    public SmallGoblin(String name) {
        super(name, new CannotBench());
    }
}
