package com.algorithms.recruitment.zalando;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DuplicatedItemsCalculator {
    @AllArgsConstructor
    public static class StraignQuadraticApproach {
        private int[] array;

        public int solution() {
            int countOfPairs = 0;
            if (array == null || array.length <= 1) {
                return countOfPairs;
            }

            for (int i = 0; i <= array.length - 1; i++) {
                for (int j = i + 1; j <= array.length - 1; j++) {
                    if (array[i] == array[j]) {
                        countOfPairs++;
                    }
                }
            }
            return countOfPairs;
        }
    }

    @AllArgsConstructor
    public static class LinearCombinatoricApproach {
        private int[] array;

        public int solution() {
            Map<Integer, Integer> itemsCounterMap = getDuplicationsCount(array);
            return getSumOfAllCombinations(itemsCounterMap).intValue();
        }

        private Map<Integer, Integer> getDuplicationsCount(int[] array) {
            Map<Integer, Integer> duplicationsMap = new HashMap<Integer, Integer>();
            for (int item : array) {
                Integer itemCounter = duplicationsMap.get(item);
                duplicationsMap.put(item, itemCounter == null ? 1 : ++itemCounter);
            }
            return duplicationsMap;
        }

        private Integer getSumOfAllCombinations(Map<Integer, Integer> itemsCounterMap) {
            return itemsCounterMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .mapToInt(entry -> new Long(getCombinationsCount(entry.getValue(), 2)).intValue())
                    .sum();
        }

        private long getCombinationsCount(int n, int m) {
            return factorial(n) / (factorial(n - m) * factorial(m));
        }

        private long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("n should be bigger than 0");
            }

            long result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }

            return result;
        }
    }
}
