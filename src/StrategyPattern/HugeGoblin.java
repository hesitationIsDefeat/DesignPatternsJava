package StrategyPattern;

public class HugeGoblin extends Goblin {

    public HugeGoblin(String name) {
        super(name, new CanBench());
    }
}
