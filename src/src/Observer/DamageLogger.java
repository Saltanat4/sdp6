package Observer;

public class DamageLogger implements GameObserver {
    @Override
    public void update(String message) {
        System.out.println("[LOG] " + message);
    }
}

