package com.myproject.code.tree;

public class LCAInBinaryTree {
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        // Getting levelorder traversal
        Node lcaNode = findLCA(root, 4, 5);
        // Displaying the LCA result
        System.out.print("LCA node " + lcaNode.data);
    }

    private static Node findLCA(Node root, int first, int secound) {
        return checkLCA(root, first, secound);
    }

    private static Node checkLCA(Node node, int first, int secound) {
        if (node == null || node.data == first || node.data == secound) {
            return node;
        }
        Node left = checkLCA(node.left, first, secound);
        Node right = checkLCA(node.right, first, secound);

        if(left==null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return node;
        }
    }
}
