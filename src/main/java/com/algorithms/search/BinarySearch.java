package com.algorithms.search;

public class BinarySearch {
    public static int doRecursiveSearch(int[] sortedArray, int startPos, int endPos, int key){
        if (startPos > endPos)
            return -1;

        int middle = startPos + (endPos - startPos) / 2;
        int result = -1;

        if (sortedArray[middle] == key) {
            result = middle;
        }
        else if (key > sortedArray[middle]) {
            result = doRecursiveSearch(sortedArray, middle + 1, endPos, key);
        }
        else if (key < sortedArray[middle]){
            result = doRecursiveSearch(sortedArray, startPos, middle - 1, key);
        }
        return result;
    }

    public static int doIterativeSearch(int[] sortedArray, int startPos, int endPos, int key){
        if (startPos > endPos)
            return -1;

        int middle = 0;
        int result = -1;

        while (startPos <= endPos) {
            middle = startPos + (endPos - startPos) / 2;
            if (sortedArray[middle] == key) {
                result = middle;
                break;
            } else if (key > sortedArray[middle]) {
                startPos = middle + 1;
            } else if (key < sortedArray[middle]) {
                endPos = middle - 1;
            }
        }
        return result;

    }

    public static void main(String args[]){
        int[] testArray = new int[]{1,3,4,6,7,9,11,13,15,17,19};
        System.out.println(String.format("doRecursiveSearch(): the index of %d in array is %d", 13, doRecursiveSearch(testArray, 0, testArray.length -1, 13)));
        System.out.println(String.format("doIterativeSearch(): the index of %d in array is %d", 13, doIterativeSearch(testArray, 0, testArray.length -1, 13)));
    }
}
