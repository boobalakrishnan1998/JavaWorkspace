package com.myproject.code.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSerializeBinaryTree {//Root , Left , Right

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        // root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print("Orignal Tree: ");
        inorder(root);
        System.out.println();
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        Node deSerialized = deSerialize(serialized);
        System.out.print("Tree after deserialization: ");
        inorder(deSerialized);
        System.out.println();
    }

    private static String serialize(Node root) {
        if (root == null)
            return null;
        StringBuilder str = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                str.append("n ");
                continue;
            } else {
                str.append(node.data);
            }
            str.append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return str.toString();
    }

    private static Node deSerialize(String str) {
        if (str == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        String[] values = str.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            Node parentNode=queue.poll();
            if(!values[i].equals("n")){
                parentNode.left=new Node(Integer.parseInt(values[i]));
                queue.add(parentNode.left);
            }
            i++;
            if(!values[i].equals("n")){
                parentNode.right=new Node(Integer.parseInt(values[i]));
                queue.add(parentNode.right);
            }
        }
    return root;
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
