package com.algorithms.recruitment.nexmo.assessment;

import com.algorithms.recruitment.nexmo.assessment.BiggestPermutatedNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiggestPermutatedNumberTest {
    @Test
    public void solutionTest1(){
        int hugestPositiveFromSiblingGroup = new BiggestPermutatedNumber().solution(213);
        assertEquals(321, hugestPositiveFromSiblingGroup);
    }

    @Test
    public void solutionTest2(){
        int hugestPositiveFromSiblingGroup = new BiggestPermutatedNumber().solution(355);
        assertEquals(553, hugestPositiveFromSiblingGroup);
    }

    @Test
    public void solutionTest3(){
        int hugestPositiveFromSiblingGroup = new BiggestPermutatedNumber().solution(1789);
        assertEquals(9871, hugestPositiveFromSiblingGroup);
    }
}
