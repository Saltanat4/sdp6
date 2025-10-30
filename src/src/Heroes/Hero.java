package Heroes;

public abstract class Hero {
    protected String name;
    protected Integer health;

    public Hero(String name) {
        this.name = name;
        this.health = 100;
    }

}