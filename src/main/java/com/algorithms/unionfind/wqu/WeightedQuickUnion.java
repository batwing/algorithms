package com.algorithms.unionfind.wqu;

import com.algorithms.unionfind.QuickUnion;
import com.algorithms.unionfind.UnionFind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.IntStream;

@AllArgsConstructor
@NoArgsConstructor
public class WeightedQuickUnion implements UnionFind {
    @Getter @Setter
    private Node[] array;
    @Getter @Setter
    private int count;//The number of components

    private void init(){
    }

    @Override
    //Complexity = O(lgN) in worst case
    public int findRoot(int elemPos) {
        int result = elemPos;
        while(result != array[result].getId()){
            result = array[result].getId();
        }
        return result;
    };

    @Override
    //Complexity = O(lgN) in worst case
    public void union(int elem1Pos, int elem2Pos){
        int root1 = findRoot(elem1Pos);
        int root2 = findRoot(elem2Pos);
        if (root1 == root2) return;
        if (array[root1].getWeight() > array[root2].getWeight()) {
            array[root2].setId(root1);
            array[root1].incWeight(array[root2].getWeight());
        }
        else {
            array[root1].setId(root2);
            array[root2].incWeight(array[root1].getWeight());
        }
        count--;
    }

    @Override
    //Complexity = O(lgN) in worst case
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
        WeightedQuickUnion unionFind = new WeightedQuickUnion();
        //TODO: uncomment next line
        //unionFind.setArray(IntStream.of(0,1,9,4,9,6,6,7,8,9).mapToObj(x -> new Node(x,1)).toArray());
        System.out.println("Data structure: " + unionFind.toString());
        int elem1Pos = 3;
        int elem2Pos = 5;
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, unionFind.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
        System.out.println(String.format("Components containing %d and %d will be merged",elem1Pos, elem2Pos));
        unionFind.union(elem1Pos,elem2Pos);
        System.out.println("Data structure: " + unionFind.toString());
        System.out.println(String.format("Are %d and %d connected components? %s",elem1Pos, elem2Pos, unionFind.isConnected(elem1Pos,elem2Pos) ? "Yes" : "No"));
    }
}
