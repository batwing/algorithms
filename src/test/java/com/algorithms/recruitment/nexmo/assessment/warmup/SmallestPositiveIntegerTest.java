package com.algorithms.recruitment.nexmo.assessment.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestPositiveIntegerTest {
    @Test
    public void solutionTest1(){
        int smallestPositiveInt = new SmallestPositiveInteger().solution(new int[]{2, 3, 4, 5});
        assertEquals(1, smallestPositiveInt);
    }

    @Test
    public void solutionTest2(){
        int smallestPositiveInt = new SmallestPositiveInteger().solution(new int[]{1, 3, 6, 4, 1, 2});
        assertEquals(5, smallestPositiveInt);
    }

    @Test
    public void solutionTest3(){
        int smallestPositiveInt = new SmallestPositiveInteger().solution(new int[]{1, 2, 3});
        assertEquals(4, smallestPositiveInt);
    }

    @Test
    public void solutionTest4(){
        int smallestPositiveInt = new SmallestPositiveInteger().solution(new int[]{-1, -3});
        assertEquals(1, smallestPositiveInt);
    }
}
