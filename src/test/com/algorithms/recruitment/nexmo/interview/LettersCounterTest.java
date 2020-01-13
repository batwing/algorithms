package com.algorithms.recruitment.nexmo.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LettersCounterTest {
    @Test
    public void solutionTest1(){
        String result = new LettersCounter().solution("abbbaaaccccddd");
        assertEquals("a3b3a4c3d", result);
    }

    @Test
    public void solutionTest2(){
        String result = new LettersCounter().solution("dabbbaaaccccddd");
        assertEquals("da3b3a4c3d", result);
    }

    @Test
    public void solutionTest3(){
        String result = new LettersCounter().solution("dabbbaaaccccdddc");
        assertEquals("da3b3a4c3dc", result);
    }
}
