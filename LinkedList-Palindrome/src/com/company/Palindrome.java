package com.company;

public class Palindrome {

    // represent the node
    class Node{
        int data;
        Node next;


        public Node (int data){
            this.data = data;
            this.next =null;
        }
    }

    //initialize the head and tail of the linked list
    public Node head;
    public Node tail;
    public int size;

    public void addNode(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            //new node will added after the tail node
            tail.next = newNode;

            //then new node become the newtail
            tail = newNode;
        }
        //count the no of nodes in the list
        size++;

    }

    //reverse the list and return the head and tail
    public Node reverselist(Node temp){
        Node current = temp;
        Node previous = null, nextNode = null;

        //swapping part

        while (current != null){
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;

        }
        return previous;
    }


    //method for check palindrome or not
    public void ispalindrome(){
        Node current = head;
        boolean flag = true;

        //store the middle position
        int mid = (size%2 == 0)? (size/2): ((size+1)/2);

        //find the middle node
        for (int x =1; x<mid; x++){
            current = current.next;
        }

        //Reverse the list
        Node revereseHead = reverselist(current.next);

        //compare first half and second half of the list
        while (head != null && revereseHead != null){
            if (head.data != revereseHead.data){
                flag = false;
                break;
            }

            head = head.next;
            revereseHead = revereseHead.next;

        }

        if (flag){
            System.out.println("This is a palindrome!");
        }
        else {
            System.out.println("This is not a palindrome!");
        }

    }

    public void print(){
        Node current = head;

        if (head == null){
            System.out.println("Empty list!");
            return;
        }
        System.out.println("Singly linked list nodes: ");

        while (current!=null){
            System.out.println(current.data+ "");
            current = current.next;
        }
        System.out.println();
    }


}
