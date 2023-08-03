package com.algorithms.leetcode;

/**
 * Definition for a binary tree node.
 */



public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreePreOrderDFS(p, q);
    }

    public boolean isSameTreePreOrderDFS(TreeNode p, TreeNode q) {
        if (p==null && q!=null
        || p!=null && q==null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else if (p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left))
            return false;

        if (!isSameTree(p.right, q.right))
            return false;

        return p.val == q.val;
    }

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
}
