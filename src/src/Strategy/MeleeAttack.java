package Strategy;

public class MeleeAttack implements AttackStrategy {
    @Override
    public int attack(){
        System.out.println("Swinging a sword");
        return 18;
    }
}
