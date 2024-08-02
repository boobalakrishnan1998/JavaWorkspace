package com.myproject.code.linkedlist;

import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;
import static com.myproject.code.linkedlist.InsertInDLL.printLL;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 0, 0, 1, 2, 1, 2, 0, 0, 0, 1, 2,};
        Node head1 = convertToDLL(arr1);
       // Node temp = sort(head1);
        Node temp = sortOptimal(head1);
        printLL(temp);
    }
    private static Node sortOptimal(Node head) {// Optimal approach
        Node zeroNode = new Node(-1);
        Node oneNode = new Node(-1);
        Node twoNode = new Node(-1);
        Node zeroTail = zeroNode;
        Node oneTail = oneNode;
        Node twoTail = twoNode;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }
        zeroTail.next = oneNode.next != null ? oneNode.next : twoNode.next;
        oneTail.next=twoNode.next;
        return zeroNode.next;
    }

    private static Node sort(Node head) {// bruteforce approach
        Node zeroNode = new Node(-1);
        Node oneNode = new Node(-1);
        Node twoNode = new Node(-1);
        Node zeroTail = zeroNode;
        Node oneTail = oneNode;
        Node twoTail = twoNode;
        int zeroCnt = 0;
        int oneCnt = 0;
        int twoCnt = 0;
        Node curr = head;
        Node temp;
        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            if (temp.data == 0) {
                zeroCnt++;
            } else if (temp.data == 1) {
                oneCnt++;
            } else {
                twoCnt++;
            }
        }
        while (zeroCnt != 0 || oneCnt != 0 || twoCnt != 0) {
            if (zeroCnt != 0) {
                zeroTail.next = new Node(0);
                zeroTail = zeroTail.next;
                zeroCnt--;
            } else if (oneCnt != 0) {
                oneTail.next = new Node(1);
                oneTail = oneTail.next;
                oneCnt--;
            } else {
                twoTail.next = new Node(2);
                twoTail = twoTail.next;
                twoCnt--;
            }
        }
        oneTail.next = twoNode.next;
        zeroTail.next = oneNode.next;
        return zeroNode.next;
    }


}
