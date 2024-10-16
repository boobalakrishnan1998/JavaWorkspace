package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class LowestCommonAncestorBST {//Root , Left , Right

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
        Node ans = lowestCommonAncestor(root, 2, 9);
        System.out.println(ans.data);
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null)
            return null;
        int cur = root.data;
        if (cur > p && cur > q) {
           return lowestCommonAncestor(root.left, p, q);
        }
        if (cur < p && cur < q) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
