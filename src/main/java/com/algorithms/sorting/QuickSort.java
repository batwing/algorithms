package com.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void doSort(int[] array, int startIndex, int endIndex){
        //check for empty or null array
        if (array == null || array.length == 0){
            return;
        }

        if (startIndex >= endIndex){
            return;
        }

        int i = startIndex;
        int j = endIndex;
        int pivotIndex = startIndex + (endIndex - startIndex)/2;
        int pivot = array[pivotIndex];

        while (i < j) {
            while (i < pivotIndex && array[i] <= pivot) {
                i++;
            }

            while (j > pivotIndex && array[j] >= pivot ) {
                j--;
            }
            swapElements(array, i, j);
        }

        doSort(array, startIndex, pivotIndex);
        doSort(array, pivotIndex, endIndex);
    }

    private static void swapElements(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args)
    {
        // This is unsorted array
        int[] array = new int[] { 12, 13, 24, 10, 3, 6, 90, 70 };

        // Let's sort using quick sort
        doSort( array, 0, array.length - 1 );

        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }
}
