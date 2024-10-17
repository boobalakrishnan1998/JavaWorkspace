package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;
import javafx.util.Pair;

import java.util.Stack;

public class BSTIterator {
    Stack<Node> st = new Stack<>();

    public BSTIterator(Node root) {
        pushAll(root);
    }//Root , Left , Right

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
        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        Node node = st.pop();
        pushAll(node.right);
        return node.data;
    }

    public void pushAll(Node node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}
