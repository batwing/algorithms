package com.algorithms.optimization.knapsack;

public class KnapsackRecursive {

    public int getOptimalValue(int[] weights, int[] values, int currentPos, int capacity){
        int result = 0;
        int currentWeight = weights[currentPos];
        if (capacity == 0 || currentPos == 0)
            result = 0;
        else if (capacity < currentWeight){
            result = getOptimalValue(weights, values, currentPos-1, capacity);
        }
        else {
            int valueWithoutItem = getOptimalValue(weights, values, currentPos-1, capacity);
            int valueWithItem = values[currentPos] + getOptimalValue(weights, values, currentPos-1, capacity - currentWeight);
            result = Math.max(valueWithoutItem, valueWithItem);
        }
        return result;
    }

}
