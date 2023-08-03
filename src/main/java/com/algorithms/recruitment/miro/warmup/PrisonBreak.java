package com.algorithms.recruitment.miro.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrisonBreak {
    public int getTheBiggestSquareUsingMinHeap(int initRows, int initColumns, int rowsToRemove[], int columnsToRemove[]){
        SolutionBasedOnMinHeap solution = new SolutionBasedOnMinHeap();
        int longestRowGap = solution.getTheLongestSequence(initRows, rowsToRemove) + 1;
        int longestColumnGap = solution.getTheLongestSequence(initColumns, columnsToRemove) + 1;

        return longestRowGap * longestColumnGap;
    }

    public int getTheBiggestSquareUsingHashSet(int initRows, int initColumns, int rowsToRemove[], int columnsToRemove[]){
        SolutionBasedOnHashset solution = new SolutionBasedOnHashset();
        int longestRowGap = solution.getTheLongestSequence(initRows, rowsToRemove) + 1;
        int longestColumnGap = solution.getTheLongestSequence(initColumns, columnsToRemove) + 1;

        return longestRowGap * longestColumnGap;
    }

    public int getTheBiggestSquareBasedOnSorting(int initRows, int initColumns, int rowsToRemove[], int columnsToRemove[]){
        SolutionBasedOnSorting solution = new SolutionBasedOnSorting();
        int longestRowGap = solution.getTheLongestSequence(initRows, rowsToRemove) + 1;
        int longestColumnGap = solution.getTheLongestSequence(initColumns, columnsToRemove) + 1;

        return longestRowGap * longestColumnGap;
    }

    public class SolutionBasedOnMinHeap {
        public int getTheLongestSequence(int maxValue, int array[]){
            if (array.length == 0)
                return 0;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int el: array){
                if (el > maxValue)
                    throw new IllegalArgumentException("One of elements in array is bigger then allowed maximum: el=" + el);

                minHeap.add(el);
            }

            int prev = minHeap.poll();
            int currentSequence = 1;
            int longestSequence = currentSequence;
            while (!minHeap.isEmpty()) {
                int top = minHeap.poll();
                if (top - prev == 1 ) {
                    longestSequence++;
                }
                else {
                    longestSequence = 1;
                }

                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
                prev = top;
            }

            return longestSequence;
        }
    }

    public class SolutionBasedOnHashset {
        public int getTheLongestSequence(int maxValue, int array[]){
            if (array.length == 0)
                return 0;


            HashSet<Integer> setOfStartValues = new HashSet<>();
            for (int el: array){
                if (el > maxValue)
                    throw new IllegalArgumentException("One of elements in array is bigger then allowed maximum: el=" + el);

                setOfStartValues.add(el);
            }

            int longestSequence = 0;
            for (int el: array) {
                int nextElInTheSequence = el;
                int nextSequenceLength = 1;
                if (isItTheStartOfNewSequence(nextElInTheSequence, setOfStartValues)){
                    while (setOfStartValues.contains(++nextElInTheSequence)) {
                        nextSequenceLength++;
                        setOfStartValues.remove(nextElInTheSequence);
                    }
                }

                if (longestSequence < nextSequenceLength) {
                    longestSequence = nextSequenceLength;
                }
            }

            return longestSequence;
        }

        private boolean isItTheStartOfNewSequence(int value, Set<Integer> setOfValues){
            return !setOfValues.contains(value-1);
        }
    }

    public class SolutionBasedOnSorting {
        public int getTheLongestSequence(int maxValue, int array[]){
            if (array.length == 0)
                return 0;

            int[] sortedArray = new int[array.length];
            System.arraycopy(array, 0, sortedArray, 0, array.length);
            Arrays.sort(sortedArray);
            int longestSequence = 1;
            int nextSequenceLength = 1;
            int prev = sortedArray[0];
            for (int i=1; i<sortedArray.length; i++){
                int current = sortedArray[i];
                if (current == prev)
                    continue;

                if (current > maxValue)
                    throw new IllegalArgumentException("One of elements in array is bigger then allowed maximum: el=" + current);

                nextSequenceLength = (current == prev + 1) ? nextSequenceLength+1 : 0;

                if (longestSequence < nextSequenceLength)
                    longestSequence = nextSequenceLength;

                prev = current;
            }

            return longestSequence;
        }
    }

    public class SolutionBasedOnDynamicPrograming {
        public int getTheLongestSequence(int maxValue, int array[]){
            if (array.length == 0)
                return 0;

            int[] sortedArray = new int[array.length];
            System.arraycopy(array, 0, sortedArray, 0, array.length);
            Arrays.sort(sortedArray);
            int longestSequence = 1;
            int nextSequenceLength = 1;
            int prev = sortedArray[0];
            for (int i=1; i<sortedArray.length; i++){
                int current = sortedArray[i];
                if (current == prev)
                    continue;

                if (current > maxValue)
                    throw new IllegalArgumentException("One of elements in array is bigger then allowed maximum: el=" + current);

                nextSequenceLength = (current == prev + 1) ? nextSequenceLength+1 : 0;

                if (longestSequence < nextSequenceLength)
                    longestSequence = nextSequenceLength;

                prev = current;
            }

            return longestSequence;
        }
    }
}
