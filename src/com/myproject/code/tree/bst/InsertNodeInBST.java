package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class InsertNodeInBST {//Root , Left , Right

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

        int node = 1;
        insertNodeInBST(root, node);
        System.out.println("ceil value " + node + " found in the BST!");
        System.out.println();
    }

    public static void insertNodeInBST(Node root, int target) {
        Node cur = root;
        while (true) {

            if (cur.data > target) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new Node(target);
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new Node(target);
                    break;
                }
            }
        }
    }
}
