package com.myproject.code.linkedlist;

import java.util.HashMap;

public class DetectLoopLL {
    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Create an instance of the Solution class
       // Solution solution = new Solution();

        // Check if there is a loop
        // in the linked list
        if (hasCycle(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static boolean hasCycleBruteforce(Node head) {
        // Initialize a pointer 'temp'
        // At the head of the linked list
        Node temp = head;

        // Create a map to keep track of
        // Encountered nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        // Traverse the linked list
        while (temp != null) {
            // If the node is already in the
            // Map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node
            // In the map
            nodeMap.put(temp, 1);

            // Move to the next node
            temp = temp.next;
        }

        // If the list is successfully traversed 
        // Without a loop, return false
        return false;
    }
}
