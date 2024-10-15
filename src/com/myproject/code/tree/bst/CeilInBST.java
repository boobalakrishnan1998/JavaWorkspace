package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class CeilInBST {//Root , Left , Right

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

        int ceil = 1;
        int ans = findCeilInBST(root, ceil);
        System.out.println("ceil value " + ans + " found in the BST!");
        System.out.println();
    }

    public static int findCeilInBST(Node root, int target) {
        int ceil = -1;
        while (root != null) {
            if (root.data == target) {
                ceil = root.data;
                break;
            } else if (root.data > target) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }
}
