package com.algorithms.recruitment.ing;

import java.util.List;

public class Task2 {
    public int solution(int A, int B) {
        return getConsecPairSum(A, B);
    }

    private int getConsecPairSum(int lowestSum, int biggestSum){

        if (biggestSum <= 1) {
            return 0;
        }

        int currentPairSum = 0;
        int previousItem = 1;
        int currentItem  = 2;
        int pairsCounter = 0;

        while(currentPairSum < biggestSum && currentItem <= biggestSum) {
            currentPairSum = previousItem * currentItem;
            if (currentPairSum >= lowestSum && currentPairSum <= biggestSum) {
                pairsCounter++;
            }
            previousItem = currentItem;
            currentItem++;
        }
        return pairsCounter;

    }
}
