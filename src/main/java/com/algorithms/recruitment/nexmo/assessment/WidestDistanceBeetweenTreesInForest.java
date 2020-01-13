package com.algorithms.recruitment.nexmo.assessment;

import java.util.Arrays;

public class WidestDistanceBeetweenTreesInForest {
    public int solution(int[] X, int[] Y) {
        if (X.length <= 1) {
            return Integer.MAX_VALUE;
        }

        if (X.length == 2) {
            return Math.abs(X[1] - X[0]);
        }

        int[] sortedX = new int[X.length];
        System.arraycopy(X, 0, sortedX, 0, X.length);
        Arrays.sort(sortedX);
        int maxDistance = 0;
        for (int i=0; i<=X.length-2; i++){// "=" has been missed in '<=' condition
            maxDistance = Math.max(maxDistance, sortedX[i+1] - sortedX[i]);
        }

        return maxDistance;
    }
}
