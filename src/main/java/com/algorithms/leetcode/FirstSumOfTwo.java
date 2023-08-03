package com.algorithms.leetcode;

import java.util.*;

public class FirstSumOfTwo {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numsWithIndexDict = new HashMap<>();

            for (int i=0; i< nums.length; i++){
                Integer pairValue = target-nums[i];
                Optional<Integer> pairIndex = Optional.ofNullable(numsWithIndexDict.get(pairValue));

                if (pairIndex.isPresent()){
                    return new int[] {pairIndex.get(), i};
                }
                numsWithIndexDict.put(nums[i], i);
            }

            return new int[]{};
        }
}
