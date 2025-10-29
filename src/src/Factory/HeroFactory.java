package Factory;
import Heroes.*;

public class HeroFactory {
    public static Hero createHero(String type, String name) {
        switch (type) {
            case "Archer":
                Archer archer=new Archer();
                archer.createArcher();

                break;
            case "Warrior":
                break;
            case "Mage":
                break;
            default:
                System.out.println("Invalid hero type");
        }
        return null;
    }
}
