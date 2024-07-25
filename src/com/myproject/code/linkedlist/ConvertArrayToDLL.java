package com.myproject.code.linkedlist;

public class ConvertArrayToDLL {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9};
        Node head = convertToDLL(arr);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node convertToDLL(int[] arr) {
        Node head = new Node(arr[0],null,null);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i],null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
