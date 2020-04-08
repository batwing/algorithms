package com.algorithms.factorial;

import java.util.stream.LongStream;

public class Factorial {
    public static long getFactorialUsingLoop(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be at least 1");
        }

        long result = 1;
        for (int i=1; i<n; i++){
            result = result * i;
        }

        return result;
    }

    public static long getFactorialUsingStreams(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be at least 1");
        }

        return LongStream.rangeClosed(1, n).reduce(1, ( x,  y) -> x * y);
    }

    public static long getFactorialUsingRecursion(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be at least 1");
        }

        if (n == 1)
            return n;

        return n * getFactorialUsingRecursion(n - 1);
    }
}
