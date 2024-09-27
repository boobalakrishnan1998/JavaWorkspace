package com.myproject.code.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // Getting levelorder traversal
        int ans;
        ans = maxDepth(root);
        System.out.print("Recursive Max Depth :"+ ans);
        ans = levelOrderTraverse(root);
        System.out.print("level order  Max Depth :"+ ans);
        System.out.println();
    }

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }


    private static int levelOrderTraverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return 0;
        int count=0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
           count++;
        }
        return count;
    }
}
