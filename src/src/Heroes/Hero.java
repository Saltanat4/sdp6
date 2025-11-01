package Heroes;

import Strategy.AttackStrategy;
import Observer.GameObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected int health = 100;
    protected AttackStrategy strategy;
    private List<GameObserver> observers = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
    }


    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public AttackStrategy getStrategy() {
        return strategy;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
        notifyObservers(name + " took " + amount + " damage. HP left: " + health);
    }

    public void attack(Hero target) {
        if (strategy == null) {
            System.out.println(name + " has no strategy!");
            return;
        }
        int dmg = strategy.attack();
        System.out.println(name + " attacks " + target.getName() + " for " + dmg + " damage!");
        target.takeDamage(dmg);
    }

    public void registerObserver(GameObserver obs) {
        observers.add(obs);
    }

    public void unregisterObserver(GameObserver obs) {
        observers.remove(obs);
    }

    public void notifyObservers(String msg) {
        for (GameObserver o : observers) {
            o.update(msg);
        }
    }
}


