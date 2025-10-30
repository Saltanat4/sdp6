import Factory.HeroFactory;
import Heroes.*;
import Observer.*;
import Strategy.*;

public class Main {
    public static void main(String[] args) {
        Hero archer = HeroFactory.createHero("archer", "Legolas");
        Hero mage = HeroFactory.createHero("mage", "Gandalf");

        GameAnnouncer announcer = new GameAnnouncer("Arena Announcer");

        archer.registerObserver(announcer);
        mage.registerObserver(announcer);

        archer.setAttackStrategy(new RangedAttack());
        mage.setAttackStrategy(new MagicAttack());

        archer.attack(mage);
        mage.attack(archer);

        archer.setAttackStrategy(new MeleeAttack());
        archer.attack(mage);
    }
}
