package com.algorithms.recruitment.google.warmup;

public class IncNumberAsArray {
    public int[] incNumberAsArray(int[] array){
        if (array== null || array.length == 0)
            return array;

        int carry = 1;
        int[] result = new int[array.length];
        int temp = 0;

        for (int i=array.length-1; i>=0; i--){
            temp = array[i]+carry;
            if (temp % 10 == 0) {
                result[i] = 0;
                carry = 1;
            }
            else {
                result[i] = temp;
                carry = 0;
            }
        }

        if (carry == 1) {
            result = new int[array.length+1];
            result[0] = 1;
        }
        return result;
    }


}
