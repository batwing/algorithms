package com.algorithms.recruitment.ing;

public class LongestNeclace {
    public final static int NECKLACE_1 = 0b01100101;
    public final static int NECKLACE_2 = 0b00010010;
    public final static int NECKLACE_3 = 0b00001000;
    public final static int[] NECKLACE_ARRAY = new int[]{NECKLACE_1, NECKLACE_2, NECKLACE_3};

    public int solution(int[] A) {

        int beadsMask = 0;
        for (int i=0; i<A.length; i++){
            beadsMask = (beadsMask | (1 << A[i]));
        }

        int longestNecklace = 0;
        int currentNecklaceLength = 0;
        for (int necklace: NECKLACE_ARRAY) {
            if ((necklace & beadsMask) == necklace) {
                currentNecklaceLength = getSetBitsCount(necklace);
                longestNecklace = (currentNecklaceLength > longestNecklace)
                        ? currentNecklaceLength
                        : longestNecklace;
            }
        }

        return longestNecklace;
    }

    private int getSetBitsCount(int number){
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number = (number >> 1);
        }
        return count;
    }

}
