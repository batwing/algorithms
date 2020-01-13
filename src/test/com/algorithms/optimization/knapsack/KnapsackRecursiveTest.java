package com.algorithms.optimization.knapsack;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KnapsackRecursiveTest {
    @Test
    public void getOptimalValueTest(){
        int[] weights = new int[]{1,2,4,2,5};
        int[] values = new int[]{5,3,5,3,2};

        int result = new KnapsackRecursive().getOptimalValue(weights, values, 0, 10);
        assertTrue(result > 0);
    }
}
