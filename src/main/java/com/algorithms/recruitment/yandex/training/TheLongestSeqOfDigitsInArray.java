package com.algorithms.recruitment.yandex.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TheLongestSeqOfDigitsInArray {
    private static int getLongestSequence(List<Integer> array, Integer elem) throws Exception{
        int currentCounter = 0;
        int maxCounter = 0;

        if (array == null)
            throw new Exception("Array is empty");

        if (elem == null)
            throw new Exception("elem is empty");

        for (Integer x: array){

            if (x.equals(elem)){
                currentCounter++;
                maxCounter = chooseMax(currentCounter, maxCounter);
            }
            else if (currentCounter > 0){
                currentCounter = 0;
            }
        }

        return maxCounter;
    }

    private static int chooseMax(int elem1, int elem2){
        return elem1 >= elem2 ? elem1 : elem2;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> theSequence = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(r.readLine());
        for (int i=0; i<n; i++){
            theSequence.add(Integer.valueOf(r.readLine()));
        }

        System.out.println(getLongestSequence(theSequence, 1));

    }
}
