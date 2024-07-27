package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;

public class InsertInDLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToDLL(arr);
        printLL(head);
        Node head2 = insertInHead(10, head);
        printLL(head2);
        Node head3 = insertBeforeTail(20, head);
        printLL(head3);
        Node head4 = insertAtKthPosition(head, 222, 5);
        printLL(head4);
        insertBeforeValue(head4.next, 99);//head!=Value
        printLL(head4);
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insertInHead(int el, Node head) {
        Node newNode = new Node(el, head, null);
        head.back = newNode;
        return newNode;
    }

    private static Node insertBeforeTail(int el, Node head) {
        if (head == null) return new Node(el);
        if (head.next == null) return insertInHead(el, head);
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(el, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }

    private static Node insertAtKthPosition(Node head, int el, int k) {
        if (k == 1) {
            return insertInHead(el, head);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(el, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    private static void insertBeforeValue(Node node, int el) {
        Node prev=node.back;
        Node newNode=new Node(el,node,prev);
        prev.next=newNode;
        prev.back=newNode;
    }

}
