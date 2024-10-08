package com.myproject.code.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenToBURN {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.right = new Node(7);
        int minBurnTime = minTimeToBurn(root, root.left, 1);
        // Displaying the printNodesDisOfK result
        System.out.print("Minimum time to burn: " + minBurnTime);
        System.out.println();
    }

    public static int minTimeToBurn(Node root, Node target, int k) {
        HashMap<Node, Node> parentTracker = new HashMap<>();
        parentTracker(root, parentTracker);
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return 0;
        queue.add(target);
        visited.put(target, true);
        int cur = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean isBurn = false;
            for (int i = 0; i < queueSize; i++) {
                Node curNode = queue.poll();
                visited.put(curNode, true);
                if (curNode.left != null && visited.get(curNode.left) == null) {
                    queue.add(curNode.left);
                    visited.put(curNode, true);
                    isBurn = true;
                }
                if (curNode.right != null && visited.get(curNode.right) == null) {
                    queue.add(curNode.right);
                    visited.put(curNode, true);
                    isBurn = true;
                }
                if (parentTracker.get(curNode) != null && visited.get(parentTracker.get(curNode)) == null) {
                    queue.add(parentTracker.get(curNode));
                    visited.put(parentTracker.get(curNode), true);
                    isBurn = true;
                }
            }
            if (isBurn) {
                cur++;
            }
        }
        return cur;
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
