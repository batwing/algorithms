package com.algorithms.recruitment.nexmo.assessment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BiggestPermutatedNumber
{
    public int solution(int N) {
        List<Integer> siblingsSortedDesc = Arrays.stream(Integer.toString(N).split("\\B"))
                .map(s->Integer.valueOf(s))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return Integer.valueOf(siblingsSortedDesc
                        .stream()
                        .map(s -> String.valueOf(s))
                        .collect(Collectors.joining("")));
    }

}
