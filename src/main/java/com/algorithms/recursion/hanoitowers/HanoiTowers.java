package com.algorithms.recursion.hanoitowers;

import java.util.Scanner;

public class HanoiTowers {
    private static final Scanner scanner = new Scanner(System.in);
    private static int actionsCounter = 0;

    private static void moveRings(String startRod, String targetRod, String serviceRod, int countOfRingsToMove){
        System.out.println(String.format(">>> moveRings(%s,%s,%s,%d) started...",startRod, targetRod, serviceRod, countOfRingsToMove));

        if (countOfRingsToMove < 0) {
            System.out.println("There are no more rings to move");
            return;
        }

        if (countOfRingsToMove == 1) {
            System.out.println(String.format("One ring was moved from %s rode to %s rode", startRod, targetRod));
            actionsCounter++;
            return;
        }

        moveRings(startRod, serviceRod, targetRod, countOfRingsToMove - 1);
        System.out.println(String.format("The biggest ring in the set was moved from %s rode to %s rode", startRod, targetRod));
        actionsCounter++;
        moveRings(serviceRod, targetRod, startRod, countOfRingsToMove - 1);

        System.out.println(String.format(">>> moveRings(%s,%s,%s,%d) finished...",startRod, targetRod, serviceRod, countOfRingsToMove));
    }

    public static void main(String args[]){
        System.out.println("Please specify the count of rings you'd like to move from the rod A to the rod B");
        int ringsCount = scanner.nextInt();
        moveRings("A","B","C",ringsCount);
        scanner.close();
        System.out.println(String.format("Action count = %d", actionsCounter));
    }
}
