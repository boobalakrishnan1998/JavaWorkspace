package com.myproject.code.tree;

import javafx.util.Pair;

import java.util.*;

public class VerticalTraversal {//Root , Left , Right

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
        // Getting Boundary traversal
        List<List<Integer>> result = boundaryTraversal(root);
        // Displaying the Boundary traversal result
        System.out.print("Boundary Traversal: ");
        for (List<Integer> val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> boundaryTraversal(Node root) {
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        Pair<Node, Pair<Integer, Integer>> nodeVerLev = new Pair<>(root, pair);
        Queue<Pair<Node, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(nodeVerLev);
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Map<Integer, Map<Integer, TreeSet<Integer>>> mapp = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> cur = queue.poll();
            Node curNode = cur.getKey();
            Integer ver = cur.getValue().getKey();
            Integer lev = cur.getValue().getValue();
            mapp.computeIfAbsent(ver, k -> new TreeMap<>())
                    .computeIfAbsent(lev, k -> new TreeSet<>())
                    .add(curNode.data);
            if (curNode.left != null) {
                Pair<Integer, Integer> temPair = new Pair<>(ver - 1,
                        cur.getValue().getValue() + 1);
                queue.add(new Pair<>(curNode.left, temPair));
            }
            if (curNode.right != null) {
                Pair<Integer, Integer> temPair = new Pair<>(ver + 1,
                        lev + 1);
                queue.add(new Pair<>(curNode.right, temPair));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> entry : mapp.entrySet()) {
            List<Integer> li = new ArrayList<>();
            for (TreeSet<Integer> set : entry.getValue().values()) {
                li.addAll(set);
            }
            ans.add(li);
        }
        return ans;
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Tuple class to hold node, x-coordinate, and y-coordinate
class Tuple {
    TreeNode node;
    int x;
    int y;

    Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // TreeMap to store the nodes at each vertical distance
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

        // Queue for BFS traversal (stores node along with its x and y coordinates)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // (node, x, y)

        // Perform BFS
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Add the node's value to the map at the correct x and y
            nodesMap.putIfAbsent(x, new TreeMap<>());
            nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.data);

            // Add the left child with updated coordinates to the queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Add the right child with updated coordinates to the queue
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the result by sorting keys and compiling nodes
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : nodesMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        return result;
    }
}