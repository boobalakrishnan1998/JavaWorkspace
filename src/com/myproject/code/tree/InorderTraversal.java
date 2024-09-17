package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Getting preorder traversal
        List<Integer> result = inorder(root);
        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> inorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        //inOrderTraverse(root, ans);
        inOrderTraverseByStack(root, ans);
        return ans;
    }

    private static void inOrderTraverse(Node node, List<Integer> ans) {
        if (node == null)
            return;
        inOrderTraverse(node.left, ans);
        ans.add(node.data);
        inOrderTraverse(node.right, ans);
    }

    private static void inOrderTraverseByStack(Node root, List<Integer> ans) {
        Stack<Node> st = new Stack<>();
        Node curNode = root;
        while (true) {
            if (curNode == null) {
                if(st.isEmpty()){
                    break;
                }
                Node curentNode = st.pop();
                ans.add(curentNode.data);
                curNode = curentNode.right;

            } else {
                st.add(curNode);
                curNode = curNode.left;
            }
        }
    }
}
