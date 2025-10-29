package Strategy;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(){
        System.out.println("melee attack");
    }
}
