package com.algorithms.recruitment.zalando;

public class Task2 {
    public static int approach1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int positionOfHighestBit = getPositionOfHighestBit(s);
        if (positionOfHighestBit == -1) {
            return 0;
        }

        return calcOperationsCount(s, positionOfHighestBit);

    }

    private static int getPositionOfHighestBit(String s){
        for (int i=0 ; i<=s.length()-1; i++){
            if (s.charAt(i)=='1') {
                return i;
            }
        }

        return -1;
    }

    private static int calcOperationsCount(String s, int highestBitPos){
        int result = 0;
        for (int i=s.length()-1; i>=highestBitPos; i--){
            result += s.charAt(i) == '0' ? 1 : 2;
        }
        return result - 1;
    }

    public static int approach2(String numberAsString){
        if (numberAsString == null || "".equals(numberAsString)) {
            return 0;
        }
        int highestBitPosition = getPositionOfHighestBit(numberAsString);
        if (highestBitPosition == -1) {
            return 0;
        }

        int operationsCounter = 0;
        int pointer = numberAsString.length()-1;
        char firstBit;

        while(pointer >= highestBitPosition){
            firstBit = numberAsString.charAt(pointer);
            if (isOdd(firstBit)) {
                firstBit = '0';//subtract 1
                operationsCounter++;
                if (pointer == highestBitPosition) {
                    break;
                }
            }
            pointer--;//devide by 2 or move the pointer to right on one position: value >> 1
            operationsCounter++;

        }
        return operationsCounter;
    }

    private static boolean isOdd(char number){
        return number=='1';
    }
}
