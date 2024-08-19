package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class DeleteAllOccurrencesLL {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 5, 1, 8, 1, 9};
        Node head = convertToDLL(arr);
        Node temp1 = deleteAllOccurrences(head, 1);//Iterative approach
        printLL(temp1);
    }

    public static Node deleteAllOccurrences(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                if (temp == head) {
                    head = temp.next;
                }
                Node prevNode = temp.back;
                Node nextNode = temp.next;
                // Update previous node's next
                if (nextNode != null) {
                    nextNode.back = prevNode;
                }

                // Update next node's previous
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Delete the current node
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
