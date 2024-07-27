package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class Add2Numbers {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9,9,9,9,9,9,9};
        int[] arr2 = new int[]{9,9,9,9};
        Node head1 = convertToDLL(arr1);
        Node head2 = convertToDLL(arr2);
        Node temp = sum2LL(head1, head2);
        printLL(temp);
    }

    private static Node sum2LL(Node ll1, Node ll2) {
        Node dummy = new Node();
        Node temp = dummy;
        int carry = 0;
        while (ll1 != null || ll2 != null || carry!=0) {
            int sum = 0;
            if (ll1 != null) {
                sum += ll1.data;
                ll1 = ll1.next;
            }
            if (ll2 != null) {
                sum += ll2.data;
                ll2 = ll2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

}
