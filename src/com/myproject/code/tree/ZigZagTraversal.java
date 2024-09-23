package com.myproject.code.tree;

import java.util.*;

public class ZigZagTraversal {

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
        List<List<Integer>> result = levelorder(root);
        // Displaying the levelorder traversal result
        System.out.print("Level Order Traversal: ");
        for (List<Integer> val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> levelorder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderTraverse(root, ans);
        return ans;
    }

    private static void levelOrderTraverse(Node root, List<List<Integer>> ans) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        boolean leftToRight = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Integer[] subArr=new Integer[len];
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                int index = leftToRight ? i : (len - i - 1);
                subArr[index]=curNode.data;
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            leftToRight = !leftToRight;
            ans.add(Arrays.asList(subArr));
        }
    }
}
