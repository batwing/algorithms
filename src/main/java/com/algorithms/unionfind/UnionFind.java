package com.algorithms.unionfind;

public interface UnionFind {

    int findRoot(int elem);
    boolean isConnected(int elem1Pos, int elem2Pos);
    void union(int elem1Pos, int elem2Pos);
}
