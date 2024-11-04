package com.myproject.code.tree.bst;

import com.myproject.code.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSumInBST {
    Stack<Node> st = new Stack<>();
    boolean reverse;

    public TwoSumInBST(Node root, boolean isReverse) {
        reverse = isReverse;
        if (reverse) {
            pushAllRight(root.right);
        } else {
            pushAllLeft(root);
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);
        List<Integer> li = twoSumPair(root, 22);
        System.out.println(li);

    }

    private static  List<Integer> twoSumPair(Node root, int sum) {
        List<Integer> li = new ArrayList<>();
        TwoSumInBST left = new TwoSumInBST(root, false);
        TwoSumInBST right = new TwoSumInBST(root, true);
        int l = left.next();
        int r = right.before();
        while (true) {
            if ((l + r) == sum) {
                li.add(l);
                li.add(r);
                break;
            }
            if ((l + r) > sum) {
                r = right.before();
            } else {
                l = left.next();
            }
        }
      return li;
    }


    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        Node node = st.pop();
        pushAllLeft(node.right);
        return node.data;
    }

    public int before() {
        Node node = st.pop();
        pushAllRight(node.left);
        return node.data;
    }

    public void pushAllLeft(Node node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public void pushAllRight(Node node) {
        while (node != null) {
            st.push(node);
            node = node.right;
        }
    }
}
