package Strategy;

public class RangedAttack implements AttackStrategy {
    @Override
    public int attack(){
        System.out.println("Shooting an arrow");
        return 20;
    }
}
