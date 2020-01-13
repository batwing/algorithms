package com.algorithms.unionfind.wqu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Node {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int weight;

    public void incWeight(int weightToBeAdded){
        weight += weightToBeAdded;
    }
}
