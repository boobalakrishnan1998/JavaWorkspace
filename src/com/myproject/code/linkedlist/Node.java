package com.myproject.code.linkedlist;

public class Node {
    public int data;
    public Node next;
    public Node back;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }


    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
