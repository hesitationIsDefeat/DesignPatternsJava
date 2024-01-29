package BuilderPattern;

public class Main {
    public static void main(String[] args) {
        var jonathan = new Npc.Builder()
                .addName("Jonathan")
                .addLevel(19)
                .addRace(Race.NORD)
                .addType(Type.WARRIOR)
                .addLocation(Location.WHITERUN)
                .buildNpc();
    }
}
