package com.myproject.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftRightViewTraversal {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Getting left view traversal
        List<Integer> result = leftViewTraversal(root);
        // Displaying the left view traversal result
        System.out.print("leftView Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        // Getting left view traversal
        List<Integer> rightViewResult = rightViewTraversal(root);
        // Displaying the right view traversal result
        System.out.print("right View Traversal: ");
        for (int val : rightViewResult) {
            System.out.print(val + " ");
        }
    }

    public static List<Integer> leftViewTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        leftViewTraversal(root, ans, 0);
        leftViewTraverseByLevel(root, ans);
        return ans;
    }

    private static void leftViewTraversal(Node node, List<Integer> ans, int level) {
        if (node == null)
            return;
        if (ans.size() == level) {
            ans.add(node.data);
        }
        leftViewTraversal(node.left, ans, level + 1);
        leftViewTraversal(node.right, ans, level + 1);
    }

    public static List<Integer> rightViewTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightViewTraversal(root, ans, 0);
        rightViewTraverseByLevel(root, ans);
        return ans;
    }

    private static void rightViewTraversal(Node node, List<Integer> ans, int level) {
        if (node == null)
            return;
        if (ans.size() == level) {
            ans.add(node.data);
        }
        leftViewTraversal(node.right, ans, level + 1);
        leftViewTraversal(node.left, ans, level + 1);
    }

    private static void leftViewTraverseByLevel(Node root, List<Integer> ans) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                subList.add(curNode.data);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            ans.add(subList.get(0));
        }
    }
    private static void rightViewTraverseByLevel(Node root, List<Integer> ans) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                subList.add(curNode.data);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            ans.add(subList.get(subList.size()-1));
        }
    }

}
