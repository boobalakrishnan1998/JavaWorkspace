package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToLL_LengthOfLL_SearchLL.convertToLL;

public class DeleteInLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToLL(arr);
        printLL(head);
        Node head2 = removeHead(head);
        printLL(head2);
        Node head3 = removeTail(head);
        printLL(head3);
        Node head4 = removeKthNode(head, 3);
        printLL(head4);
        Node head5= removeElement(head, 3);
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

    private static Node removeHead(Node head) {
        if (head == null) return null;
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeKthNode(Node head, int k) {
        if (head == null) return head;
        Node temp = head;
        if (k == 1) {
            head = head.next;
        }
        int count = 0;
        Node previous = null;
        while (temp.next != null) {
            count++;
            if (count == k) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;

        }
        return head;
    }

    private static Node removeElement(Node head, int el) {
        if (head == null) return head;
        Node temp = head;
        if (el == head.data) {
            head = head.next;
        }
        Node previous = null;
        while (temp.next != null) {
            if (temp.data == el) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;

        }
        return head;
    }

}
