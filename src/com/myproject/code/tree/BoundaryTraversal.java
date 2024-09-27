package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        // Getting Boundary traversal
        List<Integer> result = boundaryTraversal(root);
        // Displaying the Boundary traversal result
        System.out.print("Boundary Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.add(root.data);
        } else {
            return ans;
        }
        addLeftBoundary(root, ans);
        addChildBoundary(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private static void addRightBoundary(Node root, List<Integer> ans) {
        Node cur = root.right;
        Stack<Integer> st = new Stack<>();
        while (!isLeapNode(cur)) {
            st.add(cur.data);
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        int len = st.size();
        for (int i = 0; i < len; i++) {
            ans.add(st.pop());
        }
    }

    private static void addChildBoundary(Node root, List<Integer> ans) {
        if (isLeapNode(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null)
            addChildBoundary(root.left, ans);
        if (root.right != null)
            addChildBoundary(root.right, ans);
    }

    private static void addLeftBoundary(Node root, List<Integer> ans) {
        Node cur = root.left;
        while (!isLeapNode(cur)) {
            ans.add(cur.data);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    private static boolean isLeapNode(Node cur) {
        return cur.left == null && cur.right == null;
    }
}
