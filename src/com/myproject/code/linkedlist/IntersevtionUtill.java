package com.myproject.code.linkedlist;

public class IntersevtionUtill {
    //utility function to insert node at the end of the linked list

    public static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
}