package com.myproject.code.tree;

public class CountNodeOnCompelteBinaryTree {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        double count = countNode(root);//Optimal Solution 0(log n * log n)
        System.out.print("Complete Binary Tree count: " + count);
        System.out.println();
    }


    public static double countNode(Node root) {//OptimalSolutions
       if(root==null){
           return 0;
       }
        int left = 0, right = 0;
        Node cur = root;
        while (cur != null) {
            left++;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            right++;
            cur = cur.right;
        }
        if (left == right)
            return (Math.pow(2,left)- 1);

        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static int countNodeNative(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodeNative(root.left) + countNodeNative(root.right);
    }
}
