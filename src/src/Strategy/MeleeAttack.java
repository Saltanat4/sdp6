package Strategy;

public class MeleeAttack implements AttackStrategy {
    public int attack() {
        System.out.println("Slashes the enemy with a sword!");
        return 20;
    }
    public String getName() { return "Melee"; }
}
