package com.myproject.code.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ConstructBTUsingPostAndInOrder {
    static int postIndex = 0;

    public static void main(String[] args) {
        Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(40, 20, 50, 10, 60, 30));
        Vector<Integer> postorder = new Vector<>(java.util.Arrays.asList(40, 50, 20, 60, 30, 10));
        Node root = buildTree(postorder, inorder);
        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
        System.out.println();
    }

    private static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static Node buildTree(Vector<Integer> postorder, Vector<Integer> inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (Integer in : inorder) {
            map.put(in, index++);
        }
        Node root = constructTree(postorder, 0, postorder.size() - 1, inorder, 0, inorder.size() - 1, map);
        return root;
    }

    private static Node constructTree(Vector<Integer> postorder, int ps, int pe, Vector<Integer> inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        Node root = new Node(postorder.get(pe));
        int rootIndex = map.get(root.data);
        int numLeft = rootIndex - is;
        root.left =
                constructTree(postorder, ps, ps + numLeft - 1, inorder, is, rootIndex - 1, map);
        root.right =
                constructTree(postorder, ps + numLeft, pe - 1, inorder, rootIndex + 1, ie, map);
        return root;
    }
}
