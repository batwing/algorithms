package com.algorithms.unionfind;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.IntStream;

public class QuickFind implements  UnionFind{
    @Getter @Setter
    private int[] array;

    @Override
    //Complexity = O(1)
    public boolean isConnected(int elem1Pos, int elem2Pos){
        return findRoot(elem1Pos) == findRoot(elem2Pos);
    }

    @Override
    //Complexity = O(1)
    public int findRoot(int elem) {
        return getArray()[elem];
    };

    @Override
    //Complexity = O(N)
    public void union(int elem1Pos, int elem2Pos){
        int elem1Id = array[elem1Pos];
        int elem2Id = array[elem2Pos];

        for (int i=0; i<array.length -1; i++){
            if (array[i] == elem1Id)
                array[i] = elem2Id;
        }
    }

    public static void main(String arg[]){
        QuickFind quickFind = new QuickFind();
        quickFind.setArray(IntStream.of(0,1,1,8,8,0,0,1,8,8).toArray());
        System.out.println("Data structure: " + quickFind.toString());
        int elem1Pos = 3;
        int elem2Pos = 5;
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, quickFind.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
        System.out.println(String.format("Components containing %d and %d will be merged",elem1Pos, elem2Pos));
        quickFind.union(elem1Pos,elem2Pos);
        System.out.println("Data structure: " + quickFind.toString());
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, quickFind.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
    }
}
