package com.myproject.code.tree;

public class ChildrenSumProperty {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        System.out.print("Binary Tree before modification: ");
        inorderTraversal(root);
        System.out.println();
        // Call the changeTree function
        // to modify the binary tree
        childrenSumProperty(root);
        // Print the inorder traversal
        // after modification
        System.out.print("Binary Tree after Children Sum Property: ");
        inorderTraversal(root);
        System.out.println();
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void childrenSumProperty(Node root) {
        if (root == null) {
            return;
        }
        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.data;
        }
        if (root.right != null) {
            childSum += root.right.data;
        }

        if (childSum >= root.data) {
            root.data = childSum;
        } else {
            if (root.left != null) {
                root.left.data = childSum;
            }
            if (root.right != null) {
                root.right.data = childSum;
            }
        }
        childrenSumProperty(root.left);
        childrenSumProperty(root.right);
        int total = 0;
        if (root.left != null) {
            total += root.left.data;
        }
        if (root.right != null) {
            total += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }
}
