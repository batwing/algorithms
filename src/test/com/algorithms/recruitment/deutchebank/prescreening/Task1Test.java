package com.algorithms.recruitment.deutchebank.prescreening;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1Test {
    @Test
    public void testIndexOutOfBound1(){
        int[] array = new int[] {0,1,2,3,4,5,6,7};
        int valueToSearch = 0;
        int index = new Task1().binarySearch(array, valueToSearch, 0, 7);
        assertEquals(0, index);
    }

    @Test
    public void testIndexOutOfBound2(){
        int[] array = new int[] {0,1,2,3,4,5,6,7};
        int valueToSearch = 7;
        int index = new Task1().binarySearch(array, valueToSearch, 0, 7);
        assertEquals(7, index);
    }

    @Test
    public void testNonexistentValue1(){//Stackoverflow
        int[] array = new int[] {0,1,2,3,4,5,6,7};
        int valueToSearch = -1;
        int index = new Task1().binarySearch(array, valueToSearch, 0, 7);
        assertEquals(7, index);
    }


    @Test
    public void testNonexistentValue2(){//Stackoverflow
        int[] array = new int[] {0,1,2,3,4,5,6,7};
        int valueToSearch = 20;
        int index = new Task1().binarySearch(array, valueToSearch, 0, 7);
        assertEquals(7, index);
    }
}
