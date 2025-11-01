package Strategy;

public class RangedAttack implements AttackStrategy {
    public int attack() {
        System.out.println("Fires a precise arrow!");
        return 15;
    }
    public String getName() { return "Ranged"; }
}

