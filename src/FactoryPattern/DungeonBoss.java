package FactoryPattern;

public abstract class DungeonBoss {
    private final String name;
    private final int level;
    private double damage;

    public DungeonBoss(String name, double damage) {
        this.name = name;
        this.level = 99;
        this.damage = damage;
    }

    public void doDamage() {
        System.out.printf("%s did %.2f damage%n", this, this.damage);
    }

    public void increaseDamage() {
        this.damage += 5.0;
        System.out.printf("%s has %.2f damage now%n", this, this.damage);
    }

    public void specialAttack() {
        System.out.printf("%s used the special attack, did %.2f damage%n", this, this.damage * 2.0);
    }

    @Override
    public String toString() {
        return "%s(%d)".formatted(this.name, this.level);
    }
}

class Dragon extends DungeonBoss {

    public Dragon() {
        super("Smaug", 30.0);
    }
}

class Maiar extends DungeonBoss {

    public Maiar() {
        super("Balrog", 25.0);
    }
}

class Orc extends DungeonBoss {

    public Orc() {
        super("Azog", 15.0);
    }
}
