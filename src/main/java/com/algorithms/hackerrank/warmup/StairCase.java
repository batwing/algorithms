package com.algorithms.hackerrank.warmup;

import java.io.*;

import static java.util.stream.Collectors.joining;

class StairCaseSolution {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void generate(int n) {
        for (int i=1; i<=n; i++){
            System.out.println(
                    new StringBuilder(" ".repeat(n-i)).append("#".repeat(i))
            );
        }
    }

}

public class StairCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        StairCaseSolution.generate(n);

        bufferedReader.close();
    }
}
