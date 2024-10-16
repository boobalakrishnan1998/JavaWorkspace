package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class DeleteNodeInBST {//Root , Left , Right

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
        Node ans = deleteNodeInBST(root, node);
        System.out.println();
    }

    public static Node deleteNodeInBST(Node root, int target) {
        if (root == null)
            return null;
        if (root.data == target)
            return connecter(root);
        while (true) {
            if (root.data > target) {
                if (root.left != null && root.left.data == target) {
                    root.left = connecter(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == target) {
                    root.right = connecter(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return root;
    }

    private static Node connecter(Node root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        Node leftChild = root.left;
        Node leftMostChildInRightTree = root.right;
        while (leftMostChildInRightTree.left != null) {
            leftMostChildInRightTree = leftMostChildInRightTree.left;
        }
        leftMostChildInRightTree.left = leftChild;
        return root.right;
    }
}
