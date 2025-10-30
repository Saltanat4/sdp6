package Observer;

public class GameAnnouncer implements Observer {
    private String name;

    public GameAnnouncer(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println("[" + name + "] " + event);
    }
}

