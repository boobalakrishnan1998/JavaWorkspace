package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;
import javafx.util.Pair;

public class SuccessorPredecessorInBST {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        Pair ans = findSuccessorAndPredecessor(root, 10);
        System.out.println("Predecessor " + ans.getKey());
        System.out.println("Successor " + ans.getValue());
    }

    public static Pair findSuccessorAndPredecessor(Node root, int key) {
        int successor = Integer.MAX_VALUE;
        int predecessor = -1;
        Pair ans = traverse(root, key, successor, predecessor);
        int ansSuc = (int) ans.getValue();
        successor = ansSuc == Integer.MAX_VALUE ? -1 : ansSuc;
        return new Pair<>(ans.getKey(), successor);
    }

    static Pair traverse(Node root, int key, int successor, int predecessor) {
        if (root == null)
            return null;
        if (root.data < key) {
            predecessor = Math.max(predecessor, root.data);
            traverse(root.right, key, successor, predecessor);
        } else if (root.data > key) {
            successor = Math.min(successor, root.data);
            traverse(root.left, key, successor, predecessor);
        } else {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp.data;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp.data;
            }
        }
        return new Pair(predecessor, successor);
    }
}
