package com.algorithms.leetcode;

import com.algorithms.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> levels = new ArrayList<List<Integer>>();
        createLeveledLinkedListThroughDFS(root, levels, 0);
        return levels;
    }

    public void createLeveledLinkedListThroughDFS(TreeNode root, ArrayList<List<Integer>> levels, int level) {
        if (root == null)
            return;

        List<Integer> listFromLevel = levels.get(level).isEmpty() ? new LinkedList<>() : levels.get(level);
        listFromLevel.add(root.getVal());

        createLeveledLinkedListThroughDFS(root.getLeft(), levels, level+1);
        createLeveledLinkedListThroughDFS(root.getRight(), levels, level+1);
    }


/*    public createLeveledLinkedListThroughBFS(TreeNode root, List<List<Integer>> levels, int level) {
        Queue<TreeNode> queueOfNodes = new LinkedList<>();
        queueOfNodes.add(root);
        //int level = 0;

        createLeveledLinkedList(root, levels, level+1);

        while (!queueOfNodes.empty()) {
            TreeNode treeNode = queueOfNodes.poll();
            List<Integer> currentList = new LinkedList<>();
            currentList.add(treeNode);
            if (treeNode == null)
                continue;

            queueOfNodes.add(treeNode.left);
            queueOfNodes.add(treeNode.right);

        }
    }*/
}
