package com.company;

public class Main {

    public static void main(String[] args) {
	    Calculate triangle = ((x, y, z) -> x + y + z);
        System.out.println("Sum of the Triangle: "+ triangle.sum(10,20,30));
    }
}
