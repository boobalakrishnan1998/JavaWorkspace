package com.myproject.code.linkedlist;

import java.util.HashSet;

import static com.myproject.code.linkedlist.InsertInDLL.printLL;
import static com.myproject.code.linkedlist.IntersevtionUtill.insertNode;

public class IntersectionPoint {
    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec = insertNode(headSec, 3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: ");
        printLL(head1);
        System.out.print("List2: ");
        printLL(head2);
        Node answerNode = intersectionPresentOptimal(head1, head2);//Optimal method
        printLL(answerNode);
        Node answerNode1 = intersectionPresent(head1, head2);//Bruteforce method
        printLL(answerNode1);
    }

    private static Node intersectionPresentOptimal(Node head1, Node head2) { //Optimal method
        Node temp1 = head1;
        Node temp2 = head2;
        if (temp1 == null || temp2 == null) {
            return null;
        }
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) return temp1;
            if (temp1 == null) temp1 = head2;
            if (temp2 == null) temp2 = head1;
        }
        return temp1;
    }
    static Node intersectionPresentTUF(Node head1,Node head2) {
        Node d1 = head1;
        Node d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }

        return d1;
    }
    private static Node intersectionPresent(Node head1, Node head2) { //bruteforce method
        Node temp1 = head1;
        Node temp2 = head2;
        HashSet<Node> set = new HashSet<>();
        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

}
