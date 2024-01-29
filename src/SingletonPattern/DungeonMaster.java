package SingletonPattern;


public class DungeonMaster {
    private static DungeonMaster instance = null;

    private DungeonMaster() {
    }

    public DungeonMaster getInstance() {
        if (instance == null) {
            instance = new DungeonMaster();
        }
        return instance;
    }
}
