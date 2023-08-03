package com.algorithms.optimization.knapsack;

public class Knapsack {


    public static class NaiveSolution {
        public int getOptimalValue(int weights[], int values[], int position, int capacity) {
            if (capacity == 0 || position == 0)
                return 0;

            if (weights[position] > capacity) {
                return getOptimalValue(weights, values, position - 1, capacity);
            } else {
                int valueWithoutItem = getOptimalValue(weights, values, position - 1, capacity);
                int valueWithItem = values[position] + getOptimalValue(weights, values, position - 1, capacity - weights[position]);
                return Math.max(valueWithoutItem, valueWithItem);
            }

        }
    }


    public static class NaiveSolutionWithMemorizingResult {

        private Integer[][] intermediateResults;
        private int memoryColumnCount;
        private int memoryRowsCount;

        public NaiveSolutionWithMemorizingResult(int memoryRowsCount, int memoryColumnCount) {
            this.memoryColumnCount = memoryColumnCount;
            this.memoryRowsCount = memoryRowsCount;
            intermediateResults = new Integer[memoryRowsCount][memoryColumnCount];
        }

        public int getOptimalValue(int weights[], int values[], int position, int capacity) {
            if (position>=0 && position < memoryRowsCount
                && capacity>=0 && capacity < memoryColumnCount
                && intermediateResults[position][capacity] != null)
                return intermediateResults[position][capacity];

            if (capacity == 0 || position == 0)
                return 0;

            int result = 0;
            if (weights[position] > capacity) {
                result = getOptimalValue(weights, values, position-1, capacity);
            }
            else {
                int valueWithoutItem = getOptimalValue(weights, values, position-1, capacity);
                int valueWithItem = values[position] + getOptimalValue(weights, values, position-1, capacity-weights[position]);
                result = Math.max(valueWithoutItem, valueWithItem);
            }

            intermediateResults[position][capacity] = result;
            return result;

        }
    }
}
