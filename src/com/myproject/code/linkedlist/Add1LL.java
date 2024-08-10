package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class Add1LL {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 5};
        Node head = convertToDLL(arr);
        Node ans = add1ll(head);
        printLL(ans);
        ans = add1llOptimal(head);
        printLL(ans);
    }

    private static Node add1llOptimal(Node head) {
        int carry = helper(head);
        if (carry == 1) {
            Node node = new Node(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    private static int helper(Node temp) {
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        temp.data += carry;
        if (temp.data < 10) {
            return 0;
        }
        temp.data = 0;
        return 1;
    }


    private static Node add1ll(Node head) {
        Node temp = head;
        int carry = 1;
        head = reverseLL(temp);
        temp = head;
        while (temp != null) {
            int sum = temp.data + carry;
            if (sum > 9) {
                temp.data = 0;
            } else {
                temp.data = sum;
                carry--;
                break;
            }
            temp = temp.next;
        }
        temp = reverseLL(head);
        if (carry == 1) {
            temp = new Node(carry, temp);
        }
        return temp;
    }

    private static Node reverseLL(Node head) {
        // 1,2,3
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
