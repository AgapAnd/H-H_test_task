package ru.agapov.logic;

import ru.agapov.entityes.Entity;

import java.util.Random;

public class GameLogic {
    public static void beat(Entity entityWhoBeats,Entity entity) {
        int attackModificator = calculateAttackModificator(entityWhoBeats,entity);
        if (isBeatSuccessfull(attackModificator)) {
            int tempDamage = new Random().nextInt(entityWhoBeats.getDamage()) + 1;
            entity.setHealth(entity.getHealth() - tempDamage);
            System.out.println(entityWhoBeats.getClass().getSimpleName() + " attacked " + entity.getClass().getSimpleName()
                    + " with damage " + tempDamage);
        }
        else
            System.out.println(entityWhoBeats.getClass().getSimpleName() + " attacked " + entity.getClass().getSimpleName()
                + " \u001B[34m unsuccessfully\u001B[0m");

    }

    public static int calculateAttackModificator(Entity entityWhoBeats,Entity entity) {
        int tempAttackMod = entityWhoBeats.getAttack() - entity.getProtection();
        return tempAttackMod < 0 ? 1 : entityWhoBeats.getAttack() - entity.getProtection() + 1;
    }

    public static boolean isBeatSuccessfull(int attackModificator) {
        for (int i = 0; i < attackModificator; i++) {
            int random = new Random().nextInt(6) + 1;
            if (random == 5 || random == 6) {
                return true;
            }
        }
        return false;

    }
}
