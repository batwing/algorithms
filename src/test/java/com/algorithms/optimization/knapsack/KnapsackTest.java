package com.algorithms.optimization.knapsack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KnapsackTest {
    @Test
    public void testGetOptimalValueFromNaiveSolution(){
        int[] weights = new int[]{1,2,4,2,5};
        int[] values = new int[]{5,3,5,3,2};

        int result = new Knapsack.NaiveSolution().getOptimalValue(weights, values, weights.length -1, 10);
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void testGetOptimalValueFromMemorizingSolution(){
        int[] weights = new int[]{1,2,4,2,5};
        int[] values = new int[]{5,3,5,3,2};
        int capacity = 10;

        int result = new Knapsack
                .NaiveSolutionWithMemorizingResult(weights.length, capacity+1)
                .getOptimalValue(weights, values, weights.length -1, capacity);
        assertThat(result).isEqualTo(11);
    }
}
