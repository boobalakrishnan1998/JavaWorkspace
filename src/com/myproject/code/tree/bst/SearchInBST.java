package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class SearchInBST {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        int target=4;
        Node ans = findInBST(root, 4);
        if (ans != null) {
            System.out.println("Value " + target + " found in the BST!");
        } else {
            System.out.println("Value " + target + " not found in the BST.");
        }
        System.out.println();
    }

    public static Node findInBST(Node root, int target) {
        while (root != null) {
            if (root.data == target) {
                break;
            } else if (root.data < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
