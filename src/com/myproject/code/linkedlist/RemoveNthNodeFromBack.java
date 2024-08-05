package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = convertToDLL(arr);
        //Node temp = removeNthElementFromBack(head1, 7);
        Node temp = removeNthElementFromBackOptimal(head, 5);//Optimal approach
        // Node temp = removeNthElementFromBackOptimal2(head, 5);//Optimal approach
        printLL(temp);
    }

    private static Node removeNthElementFromBackOptimal(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }

    private static Node removeNthElementFromBackOptimal2(Node head, int n) {
        Node temp = head;
        int right = 0, left = 0;
        Node leftNode = temp;
        while (temp != null) {
            right++;
            if (right > n + 1) {
                left++;
                leftNode = leftNode.next;
            }
            temp = temp.next;
        }
        if (leftNode == null)
            return null;
        if (leftNode == head) {
            head = head.next;
        }
        leftNode.next = leftNode.next.next;
        return head;
    }

    private static Node removeNthElementFromBack(Node head, int n) {//brute force method
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
