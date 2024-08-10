package com.myproject.code.linkedlist;

import java.util.Stack;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;

public class PalindromeLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 2, 1,0};
        Node head = convertToDLL(arr);
        boolean ans = isPalindrome(head);
        System.out.println(ans);
        ans = isPalindromeOptimal(head);
        System.out.println(ans);
    }

    private static boolean isPalindrome(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (stack.pop() != temp.data) {
                return false;
            }
            temp = temp.next;
        }
        return true;
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
