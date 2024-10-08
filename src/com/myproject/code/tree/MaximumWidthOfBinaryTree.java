package com.myproject.code.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        // Getting levelorder traversal
        int ans = findMaxWidth(root);
        // Displaying the levelorder traversal result
        System.out.print("Level Order Traversal: " + ans);
    }

    private static int findMaxWidth(Node root) {
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        if (root == null)
            return 0;
        int ans = 0;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            int first = 0;
            int last = 0;
            int min = queue.peek().getValue();
            for (int i = 0; i < len; i++) {
                int cur_id = queue.peek().getValue() - min;
                if (i == 0) {
                    first = cur_id;
                }
                if (i == len - 1) {
                    last = cur_id;
                }
                Node curNode = queue.peek().getKey();
                queue.poll();
                if (curNode.left != null)
                    queue.add(new Pair<>(curNode.left, cur_id * 2 + 1));
                if (curNode.right != null)
                    queue.add(new Pair<>(curNode.right, cur_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
