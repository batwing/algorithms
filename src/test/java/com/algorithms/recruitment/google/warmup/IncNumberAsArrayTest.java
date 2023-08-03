package com.algorithms.recruitment.google.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncNumberAsArrayTest {

    @Test
    public void shouldReturnBiggerArray(){
        int[] result = new IncNumberAsArray().incNumberAsArray(new int[]{9,9,9});
        assertEquals(4, result.length);
        assertEquals(1, result[0]);
    }
}
