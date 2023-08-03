package com.algorithms.codility.demo;

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


// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Comparator;
import java.util.stream.IntStream;

public class MissedSmallestPositiveIntInArray {
    public int solution(int[] array) {
       int[] sortedFilteredArray = IntStream.of(array).boxed()
               .filter(x -> x > 0)
               .sorted(Comparator.naturalOrder())
               .mapToInt(i -> i)
               .toArray();

       if (sortedFilteredArray.length == 0)
           return 1;

       int result = -1;

       for (int i = (sortedFilteredArray.length-1); i>=1; i--){
            int current = sortedFilteredArray[i];
            int nextSmallerOrEqual = sortedFilteredArray[i-1];
            if ((current - nextSmallerOrEqual)  > 1 && current !=1)
                result = nextSmallerOrEqual + 1;
       }

       if (result != -1)
           return result;
       else
           return sortedFilteredArray[sortedFilteredArray.length - 1] + 1;
    }
}

/*
Example test:   [1, 3, 6, 4, 1, 2]
OK

Example test:   [1, 2, 3]
OK

Example test:   [-1, -3]
WRONG ANSWER (got -2 expected 1)
 */