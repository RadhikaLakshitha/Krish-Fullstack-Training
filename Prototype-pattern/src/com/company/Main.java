package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)  throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id: ");
        int eid = Integer.parseInt(bufferedReader.readLine());
        System.out.println("\n");

        System.out.println("Enter name: ");
        String name = bufferedReader.readLine();
        System.out.println("\n");

        System.out.println("Enter designation: ");
        String designation = bufferedReader.readLine();
        System.out.println("\n");

        System.out.println("Enter salary1: ");
        double salary = Double.parseDouble(bufferedReader.readLine());
        System.out.println("\n");

        EmployeeDetails employeeDetails = new EmployeeDetails(eid,name,designation,salary);

        employeeDetails.displayDetails();
        System.out.println("\n");

        EmployeeDetails employeeDetails1 = (EmployeeDetails) employeeDetails.getClone();
        employeeDetails1.displayDetails();

    }
}
