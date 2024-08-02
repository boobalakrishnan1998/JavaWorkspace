package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node head1 = convertToDLL(arr1);
        Node temp = removeNthElementFromBack(head1, 7);
        printLL(temp);
    }

    private static Node removeNthElementFromBack(Node head, int n) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (n == 1) {
            if (length == 1) {
                return null;
            }
            if (length > 1) {
                head = head.next;
                return head;
            }

        }
        temp = head;
        if (n == length) {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        int count = 0;
        while (temp.next != null) {
            count++;
            if ((count + 1) == n) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

}
