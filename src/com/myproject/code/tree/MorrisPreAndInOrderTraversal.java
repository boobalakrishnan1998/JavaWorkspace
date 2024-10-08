package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreAndInOrderTraversal {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        // Getting preorder traversal
        List<Integer> result = preorder(root);
        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    ans.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
    public static List<Integer> inorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    ans.add(cur.data);//###### MAIN DIFFERENCE######
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
