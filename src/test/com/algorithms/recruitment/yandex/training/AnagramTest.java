package com.algorithms.recruitment.yandex.training;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramTest {
    @Test
    public void isAnagramTestWithCorrectData() throws Exception{
        Anagram anagram = new Anagram("test","tste");
        assertTrue(anagram.isAnagramUsingArrayOlinear());
    }

    @Test
    public void isAnagramTestWithInCorrectData1() throws Exception{
        Anagram anagram = new Anagram("teest","testa");
        assertFalse(anagram.isAnagramUsingArrayOlinear());
    }

    @Test
    public void isAnagramTestWithInCorrectData2() throws Exception{
        Anagram anagram = new Anagram("test","testt");
        assertFalse(anagram.isAnagramUsingArrayOlinear());
    }
}
