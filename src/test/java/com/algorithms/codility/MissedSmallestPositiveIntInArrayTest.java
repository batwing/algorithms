package com.algorithms.codility;


import com.algorithms.codility.demo.MissedSmallestPositiveIntInArray;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissedSmallestPositiveIntInArrayTest {

    @Test
    void testSolutionShouldReturn5() {
        int result = new MissedSmallestPositiveIntInArray().solution(new int[]{1, 3, 6, 4, 1, 2});
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testSolutionShouldReturn4() {
        int result = new MissedSmallestPositiveIntInArray().solution(new int[]{1, 2, 3});
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testSolutionShouldReturn1() {
        int result = new MissedSmallestPositiveIntInArray().solution(new int[]{-1,-3});
        assertThat(result).isEqualTo(1);
    }
}