package com.company;

public class Main {

    public static void main(String[] args) {

        Palindrome list = new Palindrome();

        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addNode(6);
        list.addNode(5);
        list.addNode(4);

        list.print();

        list.ispalindrome();
    }
}
