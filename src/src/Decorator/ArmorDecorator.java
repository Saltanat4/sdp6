package Decorator;

import Heroes.Hero;

public class ArmorDecorator extends HeroDecorator {
    public ArmorDecorator(Hero hero) {
        super(hero);
    }

    @Override
    public void takeDamage(int damage) {
        int reduced = (int)(damage * 0.7);
        System.out.println("🛡️  Armor absorbs some damage!");
        decoratedHero.takeDamage(reduced);
    }
}

