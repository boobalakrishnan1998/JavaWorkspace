package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class CorrectTwoSwapBST {//Root , Left , Right
    private static Node first = null;
    private static Node prev = null;
    private static Node middle = null;
    private static Node last = null;

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);
        // Getting preorder traversal
        System.out.print("Before recover Inorder Traversal: ");
        inorderPrint(root);
        recoverTree(root);
        System.out.println();
        // Displaying the inorder traversal result
        System.out.print("After recover Inorder Traversal: ");
        inorderPrint(root);
        System.out.println();
    }

    private static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }

    private static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        if (prev != null && node.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }
        prev = node;
        inOrderTraverse(node.right);
    }

    private static void recoverTree(Node root) {
        inOrderTraverse(root);
        if (first != null && last != null) {
            Node temp = first;
            first.data = last.data;
            last.data = temp.data;
        } else if (first != null && last != null) {
            Node temp = first;
            first.data = middle.data;
            middle.data = temp.data;
        }
    }
}
