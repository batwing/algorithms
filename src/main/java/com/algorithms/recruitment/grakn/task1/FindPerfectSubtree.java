package com.algorithms.recruitment.grakn.task1;

/*
*
*
B: A->B( totalDistance = 10)
C: A->C( totalDistance = 15)
D: A->B->D( totalDistance = 22)
E: A->B->D->E( totalDistance = 24)
F: A->B->D->F( totalDistance = 23)


Your task is to calculate the size of the biggest perfect subtree that can be obtained by removing any number of nodes.
* */

public class FindPerfectSubtree {

    public static class Tree {
        private int x;
        private Tree leftTree;
        private Tree rightTree;

        public Tree(int x) {
            this.x = x;
            this.leftTree = null;
            this.rightTree = null;
        }

        public Tree(int x, Tree leftTree, Tree rightTree) {
            this.x = x;
            this.leftTree = leftTree;
            this.rightTree = rightTree;
        }

        public Tree getLeftTree() {
            return leftTree;
        }

        public Tree getRightTree() {
            return rightTree;
        }

        public void setLeftTree(Tree leftTree) {
            this.leftTree = leftTree;
        }

        public void setRightTree(Tree rightTree) {
            this.rightTree = rightTree;
        }

        public int getX() {
            return x;
        }
    }

    public static class PerfectSubTreeInfo {
        private boolean isPerfect;
        private int height;
        private Tree perfectSubTree;

        public PerfectSubTreeInfo(boolean isPerfect, int height, Tree perfectSubTree) {
            this.isPerfect = isPerfect;
            this.height = height;
            this.perfectSubTree = perfectSubTree;
        }

        public boolean isPerfect() {
            return isPerfect;
        }

        public int getHeight() {
            return height;
        }

        public Tree getPerfectSubTree() {
            return perfectSubTree;
        }
    }

    private PerfectSubTreeInfo findPerfectBinaryTree(Tree root)
    {
        PerfectSubTreeInfo result;

        if (root == null)
        {
            return new PerfectSubTreeInfo(true, 0, null);
        }

        PerfectSubTreeInfo leftSubTree = findPerfectBinaryTree(root.getLeftTree());
        PerfectSubTreeInfo rightSubTree = findPerfectBinaryTree(root.getRightTree());

        if (leftSubTree.isPerfect() && rightSubTree.isPerfect() &&
                leftSubTree.getHeight() == rightSubTree.getHeight())
        {
            return new PerfectSubTreeInfo(true, leftSubTree.getHeight() + 1, root);
        }

        return new PerfectSubTreeInfo(false,
                Math.max(leftSubTree.getHeight(), rightSubTree.getHeight()),
                (leftSubTree.getHeight() > rightSubTree.getHeight() ? leftSubTree.getPerfectSubTree() : rightSubTree.getPerfectSubTree()));
    }

    public PerfectSubTreeInfo solution(Tree t) {
        return findPerfectBinaryTree(t);
    }

    public static void inorderPrint(Tree root)
    {
        if (root != null)
        {
            inorderPrint(root.getLeftTree());
            System.out.print(root.getX() + " ");
            inorderPrint(root.getRightTree());
        }
    }

    public static void main(String[] args)
    {
        /*
        (1, (2, None, (4, None, None)), (3, (5, (7, None, None), (8, None, None)), (6, (9, None, None), (10, (11, None, None), None))))
         */

        // Create tree
        Tree root = new Tree(1,
                new Tree(2,
                        null,
                        new Tree(4, null, null)
                ),
                new Tree(3,
                        new Tree(5,
                                new Tree(7, null, null),
                                new Tree(8, null, null)),
                        new Tree(6,
                                new Tree(9, null, null),
                                new Tree(10,
                                        new Tree(11, null, null),
                                        null)
                        )
                )
                );



        /*
        root.setLeftTree(new Tree(2));
        root.setRightTree(new Tree(3));
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        */

        PerfectSubTreeInfo perfectSubtree = new FindPerfectSubtree().solution(root);

        System.out.println("Size : " +
                (Math.pow(2, perfectSubtree.getHeight()) - 1));

        // Print the inorder traversal of the found sub-tree
        System.out.print("Inorder Traversal : ");
        inorderPrint(perfectSubtree.getPerfectSubTree());
    }
}
