package com.algorithms.recruitment.ing;

import com.algorithms.recruitment.ing.Task2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestNeclaceTest {

    @Test
    public void test1(){
        int result = new LongestNeclace().solution(new int[]{5,4,0,3,1,6,2});
        assertEquals(4, result);
    }

    @Test
    public void test2(){
        int result = new LongestNeclace().solution(new int[]{1,4,3});
        assertEquals(2, result);
    }

    @Test
    public void test3(){
        int result = new LongestNeclace().solution(new int[]{1,5,6});
        assertEquals(0, result);
    }
}
