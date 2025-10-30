package Factory;
import Heroes.*;

public class HeroFactory {
    public static Hero createHero(String type, String name) {
        switch (type.toLowerCase()) {
            case "archer":
                return new Archer(name);
            case "warrior":
                return new Warrior(name);
            case "mage":
                return new Mage(name);
            default:
                System.out.println("Invalid hero type! Choose: Archer, Warrior, or Mage.");
                return null;
        }
    }
}
