package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;

public class MiddleLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        Node head = convertToDLL(arr);
        Node ans = findMiddleEle(head);
        System.out.println(ans.data);
    }

    private static Node findMiddleEle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static boolean isPalindromeOptimal(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverseLL(slow.next);
        slow = head;
        while (newHead != null) {
            if (slow.data != newHead.data) {
                return false;
            }
            slow = slow.next;
            newHead = newHead.next;
        }
        return true;
    }


    // null, 3, 2, 1
    private static Node reverseLL(Node slow) {
        Node temp = slow;
        Node prev = null;
        Node front = null;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }


}
