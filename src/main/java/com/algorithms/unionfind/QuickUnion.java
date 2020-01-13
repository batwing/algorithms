package com.algorithms.unionfind;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickUnion implements UnionFind {
    @Getter @Setter
    private int[] array;

    @Override
    //Complexity = O(N) in worst case
    public int findRoot(int elemPos) {
        int[] array = getArray();
        int result = elemPos;
        while(result != array[result]){
            result = array[result];
        }
        return result;
    };

    @Override
    //Complexity = O(N) in worst case
    public void union(int elem1Pos, int elem2Pos){
        int root1 = findRoot(elem1Pos);
        int root2 = findRoot(elem2Pos);
        getArray()[root1] = root2;
    }

    @Override
    //Complexity = O(N) in worst case
    public boolean isConnected(int elem1Pos, int elem2Pos){
        return findRoot(elem1Pos) == findRoot(elem2Pos);
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String arg[]){
        QuickUnion quickUnion = new QuickUnion();
        quickUnion.setArray(IntStream.of(0,1,9,4,9,6,6,7,8,9).toArray());
        System.out.println("Data structure: " + quickUnion.toString());
        int elem1Pos = 3;
        int elem2Pos = 5;
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, quickUnion.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
        System.out.println(String.format("Components containing %d and %d will be merged",elem1Pos, elem2Pos));
        quickUnion.union(elem1Pos,elem2Pos);
        System.out.println("Data structure: " + quickUnion.toString());
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, quickUnion.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
    }
}
