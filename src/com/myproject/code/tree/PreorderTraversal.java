package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

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
        //preOrderTraverse(root, ans);
        preOrderTraverseByStack(root, ans);
        return ans;
    }

    private static void preOrderTraverse(Node node, List<Integer> ans) {
        if (node == null)
            return;
        ans.add(node.data);
        preOrderTraverse(node.left, ans);
        preOrderTraverse(node.right, ans);
    }

    private static void preOrderTraverseByStack(Node root, List<Integer> ans) {
        Stack<Node> st = new Stack<>();
        if (root != null) {
            st.add(root);
        }
        while (!st.empty()) {
            Node curNode = st.pop();
            ans.add(curNode.data);
            if (curNode.right != null) {
                st.add(curNode.right);
            }
            if (curNode.left != null) {
                st.add(curNode.left);
            }
        }
    }
}
