package com.myproject.code.tree;

import javafx.util.Pair;

import java.util.*;

public class TopViewTraversal {//Root , Left , Right

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        // Getting topView traversal
        List<Integer> result = topViewTraversal(root);
        // Displaying the topView  traversal result
        System.out.print("topView Traversal: ");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> topViewTraversal(Node root) {
        Pair<Node, Integer> pair = new Pair<>(root, 0);
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        Map<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair<Node, Integer> cur = queue.poll();
            Node curNode = cur.getKey();
            int ver = cur.getValue();
            if (!map.containsKey(cur.getValue())) {
                map.put(cur.getValue(), curNode.data);
            }
            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, ver - 1));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, ver + 1));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}

