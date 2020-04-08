package com.algorithms.recruitment.zalando.prescreening;

import org.junit.Test;
import com.algorithms.recruitment.zalando.prescreening.DuplicatedItemsCalculator.StraignQuadraticApproach;
import com.algorithms.recruitment.zalando.prescreening.DuplicatedItemsCalculator.LinearCombinatoricApproach;

import static org.junit.Assert.assertEquals;

public class DuplicatedItemsCalculatorTest {

    @Test
    public void testQuadraticApproachOnNormalCase(){
        int result = new StraignQuadraticApproach(new int[]{3,5,6,3,3,5}).solution();
        assertEquals(4, result);
    }

    @Test
    public void testQuadraticApproachOnArrayWithoutPairs(){
        int result = new StraignQuadraticApproach(new int[]{1,2,3,4,5,6,7}).solution();
        assertEquals(0, result);
    }

    @Test
    public void testQuadraticApproachOnArrayOfSameDigits(){
        int result = new StraignQuadraticApproach(new int[]{1,1}).solution();
        assertEquals(1, result);
    }
    @Test
    public void testLinearCombinatoricApproachOnNormalCase(){
        int result = new LinearCombinatoricApproach(new int[]{3,5,6,3,3,5}).solution();
        assertEquals(4, result);
    }

    @Test
    public void testLinearCombinatoricApproachOnArrayWithoutPairs(){
        int result = new LinearCombinatoricApproach(new int[]{1,2,3,4,5,6,7}).solution();
        assertEquals(0, result);
    }

    @Test
    public void testLinearCombinatoricApproachOnArrayOfSameDigits(){
        int result = new LinearCombinatoricApproach(new int[]{1,1}).solution();
        assertEquals(1, result);
    }
}
