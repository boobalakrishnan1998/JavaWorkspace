package com.myproject.code.linkedlist;

import java.util.Stack;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.ConvertArrayToLL_LengthOfLL_SearchLL.convertToLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToDLL(arr);
        Node temp = reverseLL(head);
        printLL(temp);
        Node head1 = convertToLL(arr);
        reverseLL2(head);//brute-force approach
       Node temp1= reverseLLIterative(head1);//Iterative approach
        printLL(temp1);
    }

    private static Node reverseLLIterative(Node head) { //Iterative approach
     Node temp=head;
     Node prev=null;
     while(temp!=null){
         Node front=temp.next;
         temp.next=prev;
         prev=temp;
         temp=front;
     }
     return prev;
    }

    private static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
    }

    private static void reverseLL2(Node head) { //brute-force approach
        Node temp = head;
        Stack<Integer> stackLl = new Stack<>();
        while (temp != null) {
            stackLl.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stackLl.pop();
            temp = temp.next;
        }
    }
}
