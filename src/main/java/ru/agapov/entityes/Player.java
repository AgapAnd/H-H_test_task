package ru.agapov.entityes;

import ru.agapov.entityes.Entity;

public class Player extends Entity {


    private final int HEALINGVOLUME = 33;
    private int countOfHealing = 4;

    public Player()  {
        super();
    }

    public Player(int protection, int attack, int damage) {
        super(protection, attack, damage);
    }
    public void heal() {
        System.out.println("\n\u001B[33m" + "player is healing himself ..." + "\u001B[0m");
        if (this.countOfHealing > 0) {
            this.health += HEALINGVOLUME;
            if (this.health > 100)
                this.health = 100;
            System.out.println("player's health: " + health);
            countOfHealing--;
            System.out.println("it left " + countOfHealing + " times to heal yourself\n");

        }
        else
            System.out.println("You have no more possibilities to heal yourself ");
    }

    public int getCountOfHealing() {
        return countOfHealing;
    }

    public void setCountOfHealing(int countOfHealing) {
        this.countOfHealing = countOfHealing;
    }

    @Override
    public String toString() {
        return "Player{" +
                "protection=" + getProtection() +
                ", attack=" + getAttack() +
                ", health=" + health +
                ", damage=" + getDamage() +
                ", countOfHealing=" + getCountOfHealing() +

                '}';
    }
}
