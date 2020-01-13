package com.algorithms.recruitment.deutchebank.prescreening;

public class Task1 {
    public int binarySearch(int[] array, int value, int startIndex, int endIndex){
        int mid = (startIndex + endIndex)/2;
        if (array[mid] == value) {
            return mid;
        }

        if (array[mid] > value) {
            endIndex = mid -1;
        }

        if (array[mid] < value) {
            startIndex = mid +1;
        }

        return binarySearch(array, value, startIndex, endIndex);
    }
}
