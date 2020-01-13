package com.algorithms.recruitment.yandex.training;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parens {
    public void generate1(String current, int open, int closed, int target){
        if (current.length() == 2 * target) {
            System.out.println(current);
            return;
        }

        generate1(current + "(", open +1, closed, target);
        if (closed < open) {
            generate1(current + ")", open, closed +1, target);
        }

        return;
    }

    public void generate2(int diff, int index, int parensCount, char[] array){
        if (diff <= parensCount - index - 2) {
            array[index] = '(';
            generate2(diff+1, index+1, parensCount, array);
        }
        if (diff > 0){
            array[index] = ')';
            generate2(diff-1, index+1, parensCount, array);
        }

        if (diff == 0 && index == parensCount) {
            System.out.println(String.valueOf(array));
        }
    }

    public static void main(String args[])  throws Exception{
        System.out.println("Input an amount of parens, please!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amountOfParens = Integer.valueOf(br.readLine());
        System.out.println("The string is been building!");
        char[] result = new char[amountOfParens];
        new Parens().generate2(0, 0, amountOfParens, result);
        //new Parens().generate1("", 0, 0, amountOfParens);
        //System.out.println("amountOfParens = " + new Parens().generate("", 0, 0, amountOfParens));
        System.out.println("Completed");
    }
}
