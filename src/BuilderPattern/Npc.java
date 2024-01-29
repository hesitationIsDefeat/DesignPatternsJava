package BuilderPattern;

public class Npc {
    private final String name;
    private int level;
    private final Race race;
    private Type type;
    private Location location;

    private Npc(Builder builder) {
        this.name = builder.name;
        this.level = builder.level;
        this.race = builder.race;
        this.type = builder.type;
        this.location = builder.location;
    }

    public static class Builder {
        private String name;
        private int level;
        private Race race;
        private Type type;
        private Location location;

        public Builder() {
        }

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder addLevel(int level) {
            this.level = level;
            return this;
        }

        public Builder addRace(Race race) {
            this.race = race;
            return this;
        }

        public Builder addType(Type type) {
            this.type = type;
            return this;
        }

        public Builder addLocation(Location location) {
            this.location = location;
            return this;
        }

        public Npc buildNpc() {
            return new Npc(this);
        }
    }
}

enum Race {
    ARGONIAN,
    BRETON,
    DARK_ELF,
    HIGH_ELF,
    IMPERIAL,
    KHAJILT,
    NORD,
    ORC,
    REDGUARD,
    WOOD_ELF
}

enum Type {
    WARRIOR,
    MAGE,
    ARCHER
}

enum Location {
    DAWNSTAR,
    FALKREATH,
    MARKARTH,
    MORTHAL,
    RIFTEN,
    SOLITUDE,
    WHITERUN,
    WINDHELM,
    WINTERHOLD
}
