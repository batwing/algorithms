package com.algorithms.recruitment.nexmo.assessment.warmup;

import java.util.*;
import java.util.stream.Collectors;

/*
This is a demo task.
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class SmallestPositiveInteger {
    public int solution(int[] A) {
        Set<Integer> setOfValues = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toSet());
        int max = Collections.max(setOfValues);

        if (max <= 0) {
            return 1;
        }

        for (int i = 1; i <= Math.max(1,max+1); i++) {
            if (!setOfValues.contains(i)) {
                return i;
            }
        }
        return 0;
    }



}
