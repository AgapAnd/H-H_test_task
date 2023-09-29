package ru.agapov.entityes;

import ru.agapov.logic.GameLogic;

public abstract class Entity {
    private int protection;
    private int attack;
    protected int health = 100;
    private int damage;

    public Entity() {}

    public Entity(int protection, int attack, int damage) {
        this.protection = protection;
        this.attack = attack;
        this.damage = damage;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0)
            this.health = 0;
        else
            this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDead() {
        if (this.health <= 0) {
            System.out.println("\n\u001B[31m" + this.getClass().getSimpleName() + " is dead\u001B[0m");
            return true;
        }
        else
            return false;
    }

    public void beat(Entity entity) {
        GameLogic.beat(this,entity);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "protection=" + protection +
                ", attack=" + attack +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
