package com.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstSumOfTwoTest {

    @Test
    void twoSumShouldReturnFirst2IndexesWhenTheyGive9InSum() {
        assertThat(new FirstSumOfTwo().twoSum(new int[]{2,7,11,15}, 9)).isEqualTo(new int[]{0,1});
    }

    @Test
    void twoSumShouldReturnLast2IndexesWhenTheyGive6InSum() {
        assertThat(new FirstSumOfTwo().twoSum(new int[]{3,2,4}, 6)).isEqualTo(new int[]{1,2});
    }

    @Test
    void twoSumShouldReturnBoth2IndexesWhenTheyEqualAndGive6InSum() {
        assertThat(new FirstSumOfTwo().twoSum(new int[]{3,3}, 6)).isEqualTo(new int[]{0,1});
    }

    @Test
    void twoSumShouldReturnEmptyArrayWhenNoElementsGiveTargetInSum() {
        assertThat(new FirstSumOfTwo().twoSum(new int[]{3,5,7,9}, 100)).isEqualTo(new int[]{});
    }

    @Test
    void twoSumShouldReturn2IndexesWhenOneInSumIsEvenNegative() {
        assertThat(new FirstSumOfTwo().twoSum(new int[]{3,5,7,9,150,-50}, 100)).isEqualTo(new int[]{4,5});
    }
}
