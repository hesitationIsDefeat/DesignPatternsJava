package StrategyPattern;

public class MediumGoblin extends Goblin {

    public MediumGoblin(String name) {
        super(name, new CanBench());
    }
}
