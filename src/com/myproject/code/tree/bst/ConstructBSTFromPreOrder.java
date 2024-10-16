package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

import java.util.Vector;

public class ConstructBSTFromPreOrder {
    static int preIndex = 0;

    public static void main(String[] args) {
        Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(8, 5, 1, 7, 10, 12));
        Node root = buildTree(preorder);
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

    private static Node buildTree(Vector<Integer> preorder) {
        return constructTree(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static Node constructTree(Vector<Integer> preorder, int bound,int[] i) {
        if (i[0]==preorder.size() || preorder.get(i[0])>bound) {
            return null;
        }
        Node root = new Node(preorder.get(i[0]));
        preorder.set(i[0],i[0]++);
        root.left = constructTree(preorder, root.data,i);
        root.right = constructTree(preorder, bound,i);
        return root;
    }
}
