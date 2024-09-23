package com.myproject.code.tree;

public class DiameterOfBinaryTree {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // Getting levelorder traversal

        int[] ans = new int[]{0};
        maxDepth(root, ans);
        System.out.print("Diameter of binary tree :" + ans[0]);
        System.out.println();
    }

    private static int maxDepth(Node root, int[] max) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left, max);
        int r = maxDepth(root.right, max);
        max[0] = Math.max(max[0], (l + r));
        return 1 + Math.max(l, r);
    }
}
