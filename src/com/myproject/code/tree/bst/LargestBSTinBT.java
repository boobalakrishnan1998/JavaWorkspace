package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

public class LargestBSTinBT {//Root , Left , Right
    public static void main(String[] args) {
        // Creating a sample binary tree

        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println(largestBST(root));  // Output: 3

        // Additional test case
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(15);
        root2.left.left = new Node(1);
        root2.left.right = new Node(8);
        root2.right.right = new Node(7);

        System.out.println(largestBST(root2));
        System.out.println();
    }
    public static int largestBST(Node root) {
        // Initialize the recursive process and return the size of the largest BST subtree.
        return largestBSTSubtreeHelper(root).maxSize;
    }
    private static NodeValue largestBSTSubtreeHelper(Node node) {
        // Base case: if the node is null, return a default NodeValue.
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Recursively get values from the left and right subtrees.
        NodeValue left = largestBSTSubtreeHelper(node.left);
        NodeValue right = largestBSTSubtreeHelper(node.right);

        // Check if the current node is a valid BST node.
        if (left.maxNode < node.data && node.data < right.minNode) {
            // Current subtree is a valid BST.
            return new NodeValue(
                    Math.min(node.data, left.minNode),
                    Math.max(node.data, right.maxNode),
                    left.maxSize + right.maxSize + 1
            );
        }

        // Current subtree is not a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}
class NodeValue {
    int minNode, maxNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}