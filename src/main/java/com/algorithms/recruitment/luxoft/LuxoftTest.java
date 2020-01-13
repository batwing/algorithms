package com.algorithms.recruitment.luxoft;

import java.util.*;

public class LuxoftTest {

    //Too huge complexity O(n*n)
    private static List<Integer> getPairs(List<Integer> array){

        List<Integer> result = new ArrayList<>();

        if (array == null || array.size() ==0)
            return result;

        for (int x=0; x<array.size()-1; x++){
            for(int y=x+1; y<array.size()-1; y++) {
                if (array.get(x) + array.get(y) == 0) {
                    result.add(array.get(x), array.get(y));
                }
            }
        }

        return result;

    }



    public static void printSumPairs(int []input, int k){
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i=0;i<input.length;i++){

            if(pairs.containsKey(input[i]))
                System.out.println(input[i] +", "+ pairs.get(input[i]));
            else
                pairs.put(k-input[i], input[i]);
        }

    }

    public static void main(String[] args){
        List<Integer> testArray = new ArrayList<>( Arrays.asList(9,8,2,-2));
        System.out.println(getPairs(testArray));
    }
}
