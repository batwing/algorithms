package com.algorithms.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i=0; i< names.length; i++) {
            people.put(names[i], heights[i]);
        }

        Map<String, Integer> sortedPeople = people.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        return new String[]{};
    }
}
