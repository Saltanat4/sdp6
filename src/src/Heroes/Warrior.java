package Heroes;
public class Warrior {
    private final Warrior warrior;
    public Warrior(Warrior warrior) {
        this.warrior = warrior;
    }
    public void createWarrior() {
        System.out.println("You choose a "+warrior);
    }
}
