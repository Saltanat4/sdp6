package Heroes;

import Observer.*;
import Strategy.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero implements Subject {
    protected String name;
    protected int health = 100;
    protected AttackStrategy attackStrategy;
    private List<Observer> observers = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        notifyObservers(name + " switched to " + strategy.getClass().getSimpleName());
    }

    public void attack(Hero target) {
        int damage = attackStrategy.attack();
        target.takeDamage(damage);
        notifyObservers(name + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            notifyObservers(name + " has been defeated!");
        } else {
            notifyObservers(name + " has " + health + " HP remaining.");
        }
    }

    public String getName() {
        return name;
    }

    // === Реализация Observer Pattern ===
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer obs : observers) {
            obs.update(event);
        }
    }
}
