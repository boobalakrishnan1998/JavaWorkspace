package com.myproject.code.tree;

import java.util.*;

public class PrintAllNodesDistanceofK {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Queue<Node> result = printNodesDisOfK(root, root.left, 1);
        // Displaying the printNodesDisOfK result
        System.out.print("Level Order Traversal: ");
        for (Node val : result) {
            System.out.print(val.data + " ");
        }
        System.out.println();
    }

    public static Queue<Node> printNodesDisOfK(Node root, Node target, int k) {
        HashMap<Node, Node> parentTracker = new HashMap<>();
        parentTracker(root, parentTracker);
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.add(target);
        visited.put(target, true);
        int cur = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            if (cur == k) {
                break;
            }
            cur++;
            for (int i = 0; i < queueSize; i++) {
                Node curNode = queue.poll();
                visited.put(curNode, true);
                if (curNode.left != null && visited.get(curNode.left) == null) {
                    queue.add(curNode.left);
                    visited.put(curNode, true);
                }
                if (curNode.right != null && visited.get(curNode.right) == null) {
                    queue.add(curNode.right);
                    visited.put(curNode, true);
                }
                if (parentTracker.get(curNode) != null && visited.get(parentTracker.get(curNode)) == null) {
                    queue.add(parentTracker.get(curNode));
                    visited.put(parentTracker.get(curNode), true);
                }
            }
        }
        return queue;
    }

    private static void parentTracker(Node root, HashMap<Node, Node> parentTracker) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
                parentTracker.put(current.left, current);
            }
            if (current.right != null) {
                queue.add(current.right);
                parentTracker.put(current.right, current);
            }
        }
    }
}
