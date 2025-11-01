package Factory;

import Heroes.*;

public class HeroFactory {
    public static Hero createHero(String type, String name) {
        switch (type.toLowerCase()) {
            case "warrior": return new Warrior(name);
            case "mage": return new Mage(name);
            case "archer": return new Archer(name);
            default:
                System.out.println("Invalid hero type.");
                return null;
        }
    }
}
