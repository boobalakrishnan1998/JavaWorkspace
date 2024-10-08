package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;

public class FindRootToNodePath {//Root , Left , Right

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

        // Getting preorder traversal
        List<Integer> result = inorder(root, 7);
        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> inorder(Node root, int key) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        getPath(root, ans, key);
        return ans;
    }

    private static boolean getPath(Node node, List<Integer> ans, int key) {
        if (node == null) {
            return false;
        }
        ans.add(node.data);
        if (node.data == key) {
            return true;
        }
        if (getPath(node.left, ans, key)
                || getPath(node.right, ans, key)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }
}
