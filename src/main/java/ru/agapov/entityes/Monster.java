package ru.agapov.entityes;

import ru.agapov.entityes.Entity;

public class Monster extends Entity {
    public Monster() {
        super();
    }
    public Monster(int protection, int attack, int damage) {
        super(protection, attack, damage);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "protection=" + getProtection() +
                ", attack=" + getAttack() +
                ", health=" + health +
                ", damage=" + getDamage() +
                '}';
    }
}
