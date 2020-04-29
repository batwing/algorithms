package com.algorithms.fibonachi;

public class Fibonacci {
    public static int getFibonacci(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException("n should be at least 0");

        if (n == 0 || n == 1)
            return n;

        System.out.println("b=1");

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; ++i) {
            int next = a + b;
            a = b;
            b = next;
            System.out.println("b="+b);
        }
        return b;
    }

    public static  void main(String[] args){
        getFibonacci(10);
    }
}
