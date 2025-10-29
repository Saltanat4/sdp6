package Heroes;

public class Mage {
    private final Mage mage;
    public Mage(Mage mage) {
        this.mage = mage;
    }
    public void createMage(){
        System.out.println("You choose a "+mage);
    }
}
