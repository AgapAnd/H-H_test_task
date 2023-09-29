package ru.agapov;

import ru.agapov.battles.BattleType;
import ru.agapov.entityes.Monster;
import ru.agapov.entityes.Player;
import ru.agapov.validator.Validator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Validator validator = new Validator();

    private static Player player = new Player();
    private static Monster monster = new Monster();
    public static void main(String[] args ) {

        startGame();

        addEntity(player.getClass().getSimpleName());
        addEntity(monster.getClass().getSimpleName());

        chooseTypeOfBattle();

        finishGame();

    }

    public static void startGame() {
        System.out.println("\t\t\t\t\u001B[32mSTART GAME\u001B[0m");
        System.out.println("Two entityes take part in this game (player and monster)");

    }
    public static void addEntity(String entityType) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter features of entity: (protection attack damage, using 'space key')");

        System.out.println(entityType + ":");

        String[] arrayEntity;
        int[] arrayIntEntity;

        while (true) {
            try {
                arrayEntity = scan.nextLine().split(" ");
                arrayIntEntity = Arrays.stream(arrayEntity).mapToInt(Integer::parseInt).toArray();
            } catch (Exception e) {
                System.out.println("Invalid values, enter only numbers");
                continue;
            }
            if (validator.arrayIsValid(arrayIntEntity))
                break;
        }

        if (entityType.equals("Player")) {
            player.setProtection(arrayIntEntity[0]);
            player.setAttack(arrayIntEntity[1]);
            player.setDamage(arrayIntEntity[2]);
        }
        else {
            monster.setProtection(arrayIntEntity[0]);
            monster.setAttack(arrayIntEntity[1]);
            monster.setDamage(arrayIntEntity[2]);
        }

        System.out.println("You have made new " + entityType);

    }

    private static void chooseTypeOfBattle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nFor auto battle enter 'y', else enter 'n'");
        while (true) {
            String answer = scan.nextLine();
            if (answer.equals("y")) {
                BattleType.autoBattle(player, monster);
                break;
            }
            else if (answer.equals("n")) {
                BattleType.manualBattle(player, monster);
                break;
            } else
                System.out.println("Wrong answer, please choose 'y' or 'n'");
        }

    }

    private static void finishGame() {
        System.out.println("\t\t\t\t\u001B[32mGAME OVER\u001B[0m");
    }
}
