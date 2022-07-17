package com.company;

import static com.company.ReverseLinkedList.head;

public class Main {

    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();

        list.head = new ReverseLinkedList.LinkedListNode(5);
        list.head.next = new ReverseLinkedList.LinkedListNode(8);
        list.head.next.next = new ReverseLinkedList.LinkedListNode(2);
        list.head.next.next.next = new ReverseLinkedList.LinkedListNode(3);
        list.head.next.next.next.next = new ReverseLinkedList.LinkedListNode(1);
        list.head.next.next.next.next.next = new ReverseLinkedList.LinkedListNode(4);
        list.head.next.next.next.next.next.next = new ReverseLinkedList.LinkedListNode(7);

        System.out.println("Entered Linked List : ");
        list.displayList(head);
        head = list.reverse(head);
        System.out.println("\n");
        System.out.println("After reversal : ");
        list.displayList(head);

    }
}
