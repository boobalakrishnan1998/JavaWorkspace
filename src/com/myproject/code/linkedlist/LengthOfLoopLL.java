package com.myproject.code.linkedlist;

import java.util.HashMap;

public class LengthOfLoopLL {
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
        int loopLen = findLoopLengthOptimal(head);
        System.out.println("Loop length in the linked list." + loopLen);
    }

    public static int findLoopLengthOptimal(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                return findLength(slow, fast);

            }
        }
        return 0;
    }

    static int findLength(Node slow, Node fast) {
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            count++;
            fast = fast.next;
        }
        return count;
    }

    public static int findLoopLengthBruteforce(Node head) {
        // Initialize a pointer 'temp'
        // At the head of the linked list
        Node temp = head;

        // Create a map to keep track of
        // Encountered nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        // Traverse the linked list
        int timer = 0;
        while (temp != null) {
            // If the node is already in the
            // Map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return timer - nodeMap.get(temp);
            }
            // Store the current node
            // In the map
            nodeMap.put(temp, timer);

            // Move to the next node
            temp = temp.next;
            timer++;
        }
        // If the list is successfully traversed 
        // Without a loop, return false
        return 0;
    }
}
