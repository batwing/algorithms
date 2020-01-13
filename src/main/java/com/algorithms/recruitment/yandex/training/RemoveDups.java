package com.algorithms.recruitment.yandex.training;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class RemoveDups {
    private int[] nonDecreasingArray;

    public int[] removeDups(){
        if (nonDecreasingArray.length <= 1)
            return nonDecreasingArray;

        int[] result = new int[nonDecreasingArray.length];
        int j = 0;
        result[j] = nonDecreasingArray[0];
        for (int i=0; i< nonDecreasingArray.length-1; i++){
            if (nonDecreasingArray[i] == result[j]) {
                continue;
            }
            else {
                result[++j] = nonDecreasingArray[i];
            }
        }

        return result;
    }
}
