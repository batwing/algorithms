package com.algorithms.leetcode;

import static java.lang.Math.max;

public class BinaryTreeMaxDepth {
    /**
     * Definition for a binary tree node
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int maxDepth(TreeNode root) {
        if (root==null)
            return -1;

        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
