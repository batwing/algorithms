package com.algorithms.recruitment.zalando;

import com.algorithms.recruitment.nexmo.assessment.BiggestPermutatedNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1Test {

    @Test
    public void solutionTest1(){
        int result = new Task1().solution(new int[]{2,1,3,5,4});
        assertEquals(3, result);
    }

    @Test
    public void solutionTest2(){
        int result = new Task1().solution(new int[]{2,3,4,1,5});
        assertEquals(2, result);
    }

    @Test
    public void solutionTest3(){
        int result = new Task1().solution(new int[]{1,3,4,2,5});
        assertEquals(3, result);
    }
}
