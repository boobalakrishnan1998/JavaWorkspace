package com.myproject.code.linkedlist;

import java.util.HashMap;

public class StartingPointLL {
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
        Node startPoint = findStartingPoint(head);
        if (startPoint != null) {
            System.out.println("start point the linked list " + startPoint.data);
        } else {
            System.out.println("No start point detected in the linked list.");
        }
    }

    public static Node findStartingPoint(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public Node findStartingPointBruteForce(Node head) {
        // Use temp to traverse the linked list
        Node temp = head;
        // HashMap to store all visited nodes
        HashMap<Node, Integer> map = new HashMap<>();
        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (map.containsKey(temp)) {
                // A loop is detected hence return temp
                return temp;
            }
            // Store temp as visited
            map.put(temp, 1);
            // Move to the next node
            temp = temp.next;
        }

        // If no loop is detected, return null
        return null;
    }
}
