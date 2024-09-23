package com.myproject.code.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class IsTwoTreesAreIdentical {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // Creating a sample binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        // Getting levelorder traversal
        boolean ans;
        ans = isIdentical(root, root2);
        if (ans) {
            System.out.print("binary trees are identical");
        } else {
            System.out.print("binary trees are not identical");
        }
        System.out.println();
    }

    private static boolean isIdentical(Node node1, Node node2) {
        if (node1 == null || node1 == null) {
            return node1 == node2;
        }
        return Objects.equals(node1.data, node2.data) &&
                isIdentical(node1.left, node2.left) &&
                isIdentical(node1.right, node2.right);
    }


    private static int levelOrderTraverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return 0;
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            count++;
        }
        return count;
    }
}
