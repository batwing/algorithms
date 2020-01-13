package com.algorithms.recruitment.ing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task3Test {

    @Test
    public void test1(){
        int result = new Task3().linearSolution(new int[]{4,6,2,2,6,6,1});
        assertEquals(4, result);
    }

    @Test
    public void test2(){
        int result = new Task3().linearSolution(new int[]{1,1,3});
        assertEquals(1, result);
    }

    @Test
    public void test3(){
        int result = new Task3().linearSolution(new int[]{1,2,3});
        assertEquals(0, result);
    }
}
