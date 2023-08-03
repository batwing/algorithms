package com.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    @Test
    void testSortShouldReturnSortedArrayWhenInputIsUnsorted() {
        int[] input = new int[]{70,50,30,10,20,40,60};
        int[] expectedResult = new int[]{10,20,30,40,50,60,70};
        int[] result = new MergeSort().mergeSort(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSortShouldReturnSortedArrayWhenInputIsOfSize2() {
        int[] input = new int[]{70,50};
        int[] expectedResult = new int[]{50,70};
        int[] result = new MergeSort().mergeSort(input);
        assertThat(result).isEqualTo(expectedResult);
    }
}