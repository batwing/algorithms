package com.algorithms.sorting;

public class MergeSort {
    public int[] mergeSort(int[] array){

        if (array.length <= 1) {
            return array;
        }

        int lowIdx = 0;
        //int highIdx = array.length -1;
        int middleIdx = (array.length - lowIdx)/2;
        int subArray1Size = middleIdx - lowIdx;
        int subArray2Size = array.length - middleIdx;

        int[] subArray1 = new int[subArray1Size];
        int[] subArray2 = new int[subArray2Size];

        for (int i=0; i<subArray1Size; i++){
            subArray1[i] = array[lowIdx + i];
        }

        for (int i=0; i<subArray2Size; i++){
            subArray2[i] = array[middleIdx + i];
        }

        int[] result = new int[array.length];

        int[] sortedSubArray1 = mergeSort(subArray1);
        int[] sortedSubArray2 = mergeSort(subArray2);

        merge(result, sortedSubArray1, sortedSubArray2, lowIdx, middleIdx, array.length - 1);

        return result;
    }

    private void merge(int[] result, int[] subArray1, int[] subArray2, int leftStart, int middle, int rightEnd) {
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < subArray1.length && rightPointer < subArray2.length) {
            int leftElem = subArray1[leftPointer];
            int rightElem = subArray2[rightPointer];
            if (leftElem < rightElem) {
                result[resultPointer] = leftElem;
                leftPointer++;
            } else {
                result[resultPointer] = rightElem;
                rightPointer++;
            }
            resultPointer++;
        }

        for (int i=leftPointer; i<subArray1.length; i++){
            result[resultPointer++] = subArray1[i];
        }

        for (int i=rightPointer; i<subArray2.length; i++){
            result[resultPointer++] = subArray2[i];
        }
    }
}
