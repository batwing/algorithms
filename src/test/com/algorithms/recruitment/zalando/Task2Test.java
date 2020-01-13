package com.algorithms.recruitment.zalando;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task2Test {

    @Test
    public void approach1TestOn28(){
        int result = Task2.approach1("011100");
        assertEquals(7, result);
    }

    @Test
    public void approach1TestOn1(){
        int result = Task2.approach1("1");
        assertEquals(1, result);
    }

    @Test
    public void approach1TestOn0(){
        int result = Task2.approach1("0000");
        assertEquals(0, result);
    }

    @Test
    public void approach2TestOn28(){
        int result = Task2.approach2("011100");
        assertEquals(7, result);
    }

    @Test
    public void approach2TestOn1(){
        int result = Task2.approach2("1");
        assertEquals(1, result);
    }

    @Test
    public void approach2TestOn0(){
        int result = Task2.approach2("0000");
        assertEquals(0, result);
    }
}
