package com.company;

public class EmployeeDetails implements Prototype{

    private int id;
    private String name;
    private String designation;
    private double salary;

    public EmployeeDetails(){
        System.out.println("Employee Records");
        System.out.println("..............................");
        System.out.println("Id"+"\t"+"Name"+"\t"+"Designation"+"\t\t"+"Salary");
    }

    public EmployeeDetails(int id, String name, String designation, double salary){
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println(id+"\t"+name+"\t\t"+designation+"\t\t\t\t"+salary);
    }


    @Override
    public Prototype getClone() {
        return new EmployeeDetails(id,name,designation,salary);
    }
}
