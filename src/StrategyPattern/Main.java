package StrategyPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var mike = new SmallGoblin("Mike");
        var brad = new MediumGoblin("Brad");
        var sam = new HugeGoblin("Sam");
        List.of(mike, brad, sam).forEach(g -> System.out.printf("Bench status of %s: %s%n", g.getName(), g.getBenchStatus()));
    }
}
