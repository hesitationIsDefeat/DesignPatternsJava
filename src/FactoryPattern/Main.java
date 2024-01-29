package FactoryPattern;

public class Main {
    public static void main(String[] args) {
        var bossFactory = new DungeonBossFactory();
        var userInput = "M";
        var boss = bossFactory.createDungeonBoss(userInput);
        if (boss != null) {
            doBossStuff(boss);
        }
    }

    public static void doBossStuff(DungeonBoss boss) {
        boss.doDamage();
        boss.increaseDamage();
        boss.doDamage();
        boss.specialAttack();
    }
}
