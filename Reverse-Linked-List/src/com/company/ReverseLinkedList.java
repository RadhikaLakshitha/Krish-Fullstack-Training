package com.company;

public class ReverseLinkedList {

    static LinkedListNode head; //first node

    static class LinkedListNode {
        int value;
        LinkedListNode next;

        LinkedListNode(int x) {
            value = x;
            next = null;
        }
    }
        // reverse method
        LinkedListNode reverse(LinkedListNode element){

            LinkedListNode previous = null;
            LinkedListNode current = element;
            LinkedListNode next = null;

            while (current != null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            element = previous;
            return element;

        }


    void displayList(LinkedListNode node){
        while (node != null){
            System.out.println(node.value + "");
            node = node.next;
        }
    }
}
