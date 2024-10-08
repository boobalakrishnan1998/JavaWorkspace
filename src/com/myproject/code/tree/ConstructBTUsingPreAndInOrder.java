package com.myproject.code.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ConstructBTUsingPreAndInOrder {
    static int preIndex = 0;

    public static void main(String[] args) {
        Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(9, 3, 15, 20, 7));
        Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(3, 9, 20, 15, 7));
        Node root = buildTree(preorder, inorder);
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

    private static Node buildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (Integer in : inorder) {
            map.put(in, index++);
        }
        Node root = constructTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, map);
        return root;
    }

    private static Node constructTree(Vector<Integer> preorder, int preSi, int preEi, Vector<Integer> inorder, int inSi, int inEi, Map<Integer, Integer> map) {
        if (preSi > preEi || inSi > inEi) {
            return null;
        }
        Node root = new Node(preorder.get(preSi));
        int rootIndex = map.get(root.data);
        int numLeft = rootIndex - inSi;
        root.left = constructTree(preorder, preSi + 1, preSi + numLeft, inorder, inSi, rootIndex - 1, map);
        root.right = constructTree(preorder, preSi + numLeft + 1, preEi, inorder, rootIndex + 1, preEi, map);
        return root;
    }
}
