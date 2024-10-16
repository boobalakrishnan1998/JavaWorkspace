package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class IsValidBST {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        int node = 5;
        boolean ans = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println();
    }

    public static boolean isValidBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max) {
            return false;
        }
        boolean isLeft = isValidBST(root.left, min, root.data);
        boolean isRight = isValidBST(root.right, root.data, max);
        return isLeft && isRight;
    }
}
