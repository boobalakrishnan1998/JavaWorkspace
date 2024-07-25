package com.myproject.code.linkedlist;

public class ConvertArrayToLL_LengthOfLL_SearchLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToLL(arr);
        int lengthOfLL = lengthOfLL(head);
        System.out.println("Length of LL " + lengthOfLL);
        System.out.println(searchElement(head, 5));
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node convertToLL(int[] arr) {
        Node head = new Node(arr[0], null, null);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static int lengthOfLL(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static boolean searchElement(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
}