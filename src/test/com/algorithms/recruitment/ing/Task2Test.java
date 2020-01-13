package com.algorithms.recruitment.ing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task2Test {

    @Test
    public void test1(){
        int result = new Task2().solution(6,20);
        assertEquals(3, result);
    }

    @Test
    public void test2(){
        int result = new Task2().solution(21, 29);
        assertEquals(0, result);
    }

    @Test
    public void test3(){
        int result = new Task2().solution(20, 20);
        assertEquals(1, result);
    }


    @Test
    public void test4(){
        int result = new Task2().solution(1, 2);
        assertEquals(1, result);
    }


    @Test
    public void test5(){
        int result = new Task2().solution(1, 1);
        assertEquals(0, result);
    }
}
