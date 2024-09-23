package com.myproject.code.tree;

public class CheckBalancedBinaryTree {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // Getting levelorder traversal
        int ans;
        ans = maxDepth(root);
        if (ans == -1) {
            System.out.print("Not a balanced binary tree");
        } else {
            System.out.print("balanced binary tree");
        }
        System.out.println();
    }

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        if (l < 0) return -1;
        int r = maxDepth(root.right);
        if (r < 0) return -1;
        if (Math.abs(r - l) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
