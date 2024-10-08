package com.myproject.code.tree;

public class SymmetricalBinaryTree {
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(3);
        root.right.left = new Node(4);
        // Getting levelorder traversal
        boolean isSymmetrical = isSymmetrical(root);
        // Displaying the levelorder traversal result
        System.out.print("is Symmetrical " + isSymmetrical);
    }

    private static boolean isSymmetrical(Node root) {
        return root == null || checkSymmetrical(root.left, root.right);
    }

    private static boolean checkSymmetrical(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.data == right.data &&
                checkSymmetrical(left.left, right.right) &&
                checkSymmetrical(left.right, right.left);
    }
}
