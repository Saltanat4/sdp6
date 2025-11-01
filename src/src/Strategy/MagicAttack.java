package Strategy;

public class MagicAttack implements AttackStrategy {
    public int attack() {
        System.out.println("Casts a powerful fireball!");
        return 25;
    }
    public String getName() { return "Magic"; }
}

