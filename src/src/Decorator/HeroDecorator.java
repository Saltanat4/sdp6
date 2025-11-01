package Decorator;

import Heroes.Hero;

public abstract class HeroDecorator extends Hero {
    protected Hero decoratedHero;

    public HeroDecorator(Hero hero) {
        super(hero.getName());
        this.decoratedHero = hero;
    }

    @Override
    public void attack(Hero target) {
        decoratedHero.attack(target);
    }

    @Override
    public void takeDamage(int amount) {
        decoratedHero.takeDamage(amount);
    }

    @Override
    public int getHealth() {
        return decoratedHero.getHealth();
    }
}
