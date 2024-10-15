package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class FloorInBST {

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

        int floor = 14;
        int ans = findCeilInBST(root, floor);
        System.out.println("floor value " + ans + " found in the BST!");
        System.out.println();
    }

    public static int findCeilInBST(Node root, int target) {
        int floor = -1;
        while (root != null) {
            if (root.data == target) {
                floor = root.data;
                break;
            } else if (root.data > target) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
