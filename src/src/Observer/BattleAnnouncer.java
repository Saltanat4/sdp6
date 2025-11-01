package Observer;

public class BattleAnnouncer implements GameObserver {
    @Override
    public void update(String message) {
        System.out.println("[ANNOUNCER] " + message);
    }
}
