package com.myproject.code.tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    static Node prevNode = null;

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //flattenToLL(root);
        flattenToLLStack(root);
        printorder(root);
        System.out.println();
    }

    private static void printorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printorder(root.right);
        }
    }

    private static void flattenToLL(Node node) {
        if (node == null) {
            return;
        }
        flattenToLL(node.right);
        flattenToLL(node.left);
        node.right = prevNode;
        node.left = null;
        prevNode = node;
    }

    private static void flattenToLLStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            if (cur.right != null) {
                st.add(cur.right);
            }
            if (cur.left != null) {
                st.add(cur.left);
            }
            if (!st.isEmpty()) {
                cur.right = st.peek();
            }
            cur.left = null;
        }
    }


}
