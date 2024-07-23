package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToLL_LengthOfLL_SearchLL.convertToLL;

public class InsertInLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToLL(arr);
        printLL(head);
        Node head2 = insertInHead(100, head);
        printLL(head2);
        Node head3 = insertInTail(100, head);
        printLL(head3);
        Node head4 = insertAtKthPosition(head, 222, 5);
        printLL(head4);
        Node head5 = insertBeforeValue(head, 99, 5);
        printLL(head5);
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insertInHead(int el, Node head) {
        return new Node(el, head);
    }

    private static Node insertInTail(int el, Node head) {
        if (head == null) return new Node(el);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(el);
        return head;
    }

    private static Node insertAtKthPosition(Node head, int el, int k) {
        if (head == null) {
            if (k == 1) {
                return new Node(el);
            }
            return head;
        }
        Node temp = head;
        if (k == 1) {
            return new Node(el, head);
        }
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == k - 1) {
                Node newEl = new Node(el, temp.next);
                temp.next = newEl;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head, int el, int val) {

        if (head == null) {
            return head;
        }
        Node temp = head;
        if (head.data == val) {
            return new Node(el, head);
        }
        while (temp.next != null) {
            if (temp.next.data == val) {
                Node newEl = new Node(el, temp.next);
                temp.next = newEl;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

}
