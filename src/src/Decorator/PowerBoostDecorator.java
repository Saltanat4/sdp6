package Decorator;

import Heroes.Hero;
import Strategy.*;

public class PowerBoostDecorator extends HeroDecorator {
    public PowerBoostDecorator(Hero hero) {
        super(hero);
    }

    @Override
    public void attack(Hero target) {
        System.out.println(getName() + " uses Power Boost!");
        decoratedHero.attack(target);
        target.takeDamage(10);
        System.out.println("Extra 10 damage applied!");
    }
}
