package com.myproject.code.linkedlist;


import static com.myproject.code.linkedlist.ConvertArrayToDLL.convertToDLL;

public class DeleteInDLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9, 10, 12, 15};
        Node head = convertToDLL(arr);
        printLL(head);
        Node head2 = removeHead(head);
        printLL(head2);
        Node head3 = removeTail(head2);
        printLL(head3);
        Node head4 = removeKthNode(head3, 4);
        printLL(head4);
        removeElement(head4.next);//(temp!=head)
        printLL(head4);
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node removeHead(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null) return head;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.next = null;
        return head;
    }

    private static Node removeKthNode(Node head, int k) {
        if (head == null) return head;
        int count = 0;
        Node kNode = head;
        while (kNode != null) {
            count++;
            if (count == k) {
                break;
            }
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;
        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return removeHead(head);
        } else if (front == null) {
            return removeTail(head);
        }
        prev.next = front;
        front.back = prev;
        kNode.next = null;
        kNode.back = null;
        return head;
    }

    private static void removeElement(Node temp) {
        Node prev = temp.back;
        Node front = temp.next;
        if (front == null) {
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        temp.back = null;
        temp.next = null;
    }

}
