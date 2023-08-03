package com.algorithms.recruitment.dnb;

import java.util.HashMap;
import java.util.Map;

public class SUmOfUniqueValues {
    public static int solution(int[] arrayWithDuplicates){
        Map<Integer, Integer> valueCounters = new HashMap<>();
        for(int i=0; i<arrayWithDuplicates.length; i++)   {
            int current = arrayWithDuplicates[i];
            if (valueCounters.containsKey(current)) {
                valueCounters.put(current, valueCounters.get(current)+1);
            }
            else {
                valueCounters.put(current, 1);
            }
        }

        return valueCounters.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .reduce(0, (x,y)-> x +y);
    }

    public static void main(String[] args) {
        int result = solution(new int[]{1,2,3,2});
        System.out.println(result);
    }
}
