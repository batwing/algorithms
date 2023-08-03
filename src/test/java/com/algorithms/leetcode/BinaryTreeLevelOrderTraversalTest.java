package com.algorithms.leetcode;

import com.algorithms.leetcode.trees.TreeNode;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLevelOrderTraversalTest {

    private TreeNode createTestSet(Stack<Integer> stackOfNodes){
        TreeNode root = new TreeNode(stackOfNodes.pop());

        while (!stackOfNodes.empty() && stackOfNodes.size() >= 2) {
            root.setLeft(new TreeNode(stackOfNodes.pop()));
            root.setRight(new TreeNode(stackOfNodes.pop()));
        }

        return root;
    }



}