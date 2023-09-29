package ru.agapov.battles;

import ru.agapov.entityes.Monster;
import ru.agapov.entityes.Player;

import java.util.Scanner;

public class BattleType {

    public static void manualBattle(Player player, Monster monster) {
        System.out.println("\n\u001B[34mManual mode, let's go!\u001B[0m");
        while (true) {
            System.out.println();
            monster.beat(player);
            System.out.println(player);

            if (player.isDead()) {
                break;
            }

            System.out.println("\nChoose your action: 1 - beat monster, 2 - heal youself");
            Scanner scan = new Scanner(System.in);
            String answer;
            while (true) {
                answer = scan.nextLine();

                if (answer.equals("1")) {
                    player.beat(monster);
                    break;
                }
                else if (answer.equals("2")) {
                    player.heal();
                    break;
                }
                else
                    System.out.println("Wrong answer, try again");
            }

            System.out.println(monster);

            if (monster.isDead()) {
                break;
            }
        }

    }

    public static void autoBattle(Player player, Monster monster) {

        System.out.println("\n\u001B[34mAuto battle has begun!\u001B[0m");

        while (true) {

            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            monster.beat(player);
            System.out.println(player);

            if (player.isDead()) {
                break;
            }


            if (player.getHealth() <10) {
                if (player.getCountOfHealing() > 0)
                    player.heal();
                else {
                    player.beat(monster);
                }
            }
            else
                player.beat(monster);

            System.out.println(monster);

            if (monster.isDead()) {
                break;
            }

        }
    }
}
