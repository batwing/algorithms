package com.algorithms.recruitment.nexmo.assessment;

import com.algorithms.recruitment.nexmo.assessment.WidestDistanceBeetweenTreesInForest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WidestDistanceBeetweenTreesInForestTest {
    @Test
    public void solutionTest1(){
        int hugestPositiveFromSiblingGroup = new WidestDistanceBeetweenTreesInForest().solution(new int[]{1,8,7,3,4,1,8}, new int[]{6,4,1,8,5,1,7});
        assertEquals(3, hugestPositiveFromSiblingGroup);
    }

    @Test
    public void solutionTest2(){
        int hugestPositiveFromSiblingGroup = new WidestDistanceBeetweenTreesInForest().solution(new int[]{5,5,5,7,7,7}, new int[]{3,4,5,1,3,7});
        assertEquals(2, hugestPositiveFromSiblingGroup);
    }

    @Test
    public void solutionTest3(){
        int hugestPositiveFromSiblingGroup = new WidestDistanceBeetweenTreesInForest().solution(new int[]{6, 10, 1, 4, 3}, new int[]{2, 5, 3, 1, 6});
        assertEquals(4, hugestPositiveFromSiblingGroup);
    }

    @Test
    public void solutionTest4(){
        int hugestPositiveFromSiblingGroup = new WidestDistanceBeetweenTreesInForest().solution(new int[]{4,1,5,4}, new int[]{4,5,1,3});
        assertEquals(3, hugestPositiveFromSiblingGroup);
    }
}
