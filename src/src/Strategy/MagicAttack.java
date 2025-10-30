package Strategy;

public class MagicAttack implements AttackStrategy{
    @Override
    public int attack(){
        System.out.println("Casting a magic spell");
        return 25;
    }
}
