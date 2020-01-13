package com.algorithms.recruitment.yandex.training;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RemoveDupsTest {
    @Test
    public void testRemoveDupsWithArrayOfUnrepeatableValues(){
        int[] expected = new int[]{1,2,3,4,5,6};
        int[] result = new RemoveDups(expected).removeDups();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDupsWithArrayOfDups(){
        int[] initial = new int[]{1,1,2,2,3,3,4,4,5,5,6,6};
        int[] expected = new int[]{1,2,3,4,5,6};
        int[] result = new RemoveDups(initial).removeDups();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDupsWithEmptyArray(){
        int[] initial = new int[]{};
        int[] expected = new int[]{};
        int[] result = new RemoveDups(initial).removeDups();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDupsWithArrayOfSize1(){
        int[] initial = new int[]{1};
        int[] expected = new int[]{1};
        int[] result = new RemoveDups(initial).removeDups();
        assertArrayEquals(expected, result);
    }
}
