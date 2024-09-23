package com.myproject.code.tree;

public class MaximumPathSum {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int[] ans = new int[]{0};
        maxPathSum(root, ans);
        System.out.print("Diameter of binary tree :" + ans[0]);
        System.out.println();
    }

    private static int maxPathSum(Node node, int[] max) {
        if (node == null) {
            return 0;
        }
        int l = Math.max(0, maxPathSum(node.left, max));
        int r = Math.max(0, maxPathSum(node.right, max));
        max[0] = Math.max(max[0], (l + r + node.data));
        return node.data + Math.max(l, r);
    }
}
