package StrategyPattern;

public interface Benches {
    public String bench();
}

class CanBench implements Benches {

    @Override
    public String bench() {
        return "Benching 225 for reps";
    }
}

class CannotBench implements Benches {

    @Override
    public String bench() {
        return "Cannot bench, doing chest flies";
    }
}
