package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {// Left , Right , Root

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Getting PostOrder traversal
        List<Integer> result = postOrder(root);
        // Displaying the PostOrder traversal result
        System.out.print("PostOrder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> postOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraverse(root, ans);
        postOrderTraverseByStack(root, ans);
        return ans;
    }

    private static void postOrderTraverse(Node node, List<Integer> ans) {
        if (node == null)
            return;
        postOrderTraverse(node.left, ans);
        postOrderTraverse(node.right, ans);
        ans.add(node.data);
    }

    private static void postOrderTraverseByStack(Node root, List<Integer> ans) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node curNode = root;
        Node prev = null;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                st.add(curNode);
                curNode = curNode.left;
            }
            curNode = st.peek();
            if (curNode.right == null || curNode.right == prev) {
                ans.add(curNode.data);
                st.pop();
                prev = curNode;
                curNode = null;
            } else {
                curNode = curNode.right;
            }
        }
    }
}
