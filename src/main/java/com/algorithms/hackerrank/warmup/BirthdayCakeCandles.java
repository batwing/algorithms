package com.algorithms.hackerrank.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BirthdayCakeCandles {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        if (candles == null || candles.size() == 0) {
            return 0;
        }

        int theTallest = 0;
        int theAmountOfTallestCandels = 0;
        int current;

        for (int i = 0; i < candles.size(); i++) {
            current = candles.get(i);
            if (current > theTallest) {
                theTallest = current;
                theAmountOfTallestCandels = 1;
            } else if (current == theTallest) {
                theAmountOfTallestCandels++;
            }
        }

        return theAmountOfTallestCandels;

    }

}
