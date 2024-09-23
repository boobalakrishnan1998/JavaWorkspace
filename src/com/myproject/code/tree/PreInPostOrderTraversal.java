package com.myproject.code.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderTraversal {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        // Getting preorder traversal
        List<List<Integer>> ans = new ArrayList<>();
        preInPostorder(root, ans);
        // Displaying the preInPost order traversal result
        System.out.print("PreInPost order Traversal: ");
        for (List val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void preInPostorder(Node root, List<List<Integer>> ans) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair<Node, Integer>> st = new Stack<>();
        st.add(new Pair<>(root, 1));
        while (!st.empty()) {
            Pair<Node, Integer> curSt = st.pop();
            Node curNode = curSt.getKey();
            int num = curSt.getValue();
            if (num == 1) {
                pre.add(curNode.data);
                st.add(new Pair<>(curNode, num + 1));
                if (curNode.left != null) {
                    st.add(new Pair<>(curNode.left, 1));
                }
            } else if (num == 2) {
                in.add(curNode.data);
                st.add(new Pair<>(curNode, num + 1));
                if (curNode.right != null) {
                    st.add(new Pair<>(curNode.right, 1));
                }
            } else {
                post.add(curNode.data);
            }
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
    }

}
