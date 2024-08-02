package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class SegregateEvenAndOdd {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node head1 = convertToDLL(arr1);
        Node temp = segregateEvenAndOdd(head1);
        printLL(temp);
    }

    private static Node segregateEvenAndOdd(Node head) {
        Node evenNode = new Node(-1);
        Node oddNode = new Node(-1);
        Node evenTail = evenNode;
        Node oddTail = oddNode;
        Node curr = head;
        Node temp;
        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            if ((temp.data % 2) == 0) {
                evenTail.next = temp;
                evenTail = temp;
            } else {
                oddTail.next = temp;
                oddTail = temp;
            }
        }
        evenTail.next = oddNode.next;
        return evenNode.next;
    }

}
