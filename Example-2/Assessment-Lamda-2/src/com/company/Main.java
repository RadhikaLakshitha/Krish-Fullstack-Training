package com.company;

public class Main {

    public static void main(String[] args) {
        Calculate square = ((x, y) -> x * y);
        System.out.println(square.multiplication(10,30));
    }
}
