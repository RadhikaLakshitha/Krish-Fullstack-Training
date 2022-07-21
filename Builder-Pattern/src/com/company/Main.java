package com.company;

public class Main {

    public static void main(String[] args) {

        Customer customer =new Customer.UserBuilder("Radhika", "Dharmarathne").address("kurunegala").mobile("0778091971").build();
        System.out.println(customer);

        Customer customer1 =new Customer.UserBuilder("Jagath", "Bandara").mobile("0775869456").build();
        System.out.println(customer1);

        Customer customer2 =new Customer.UserBuilder("Suranga", "perera").build();
        System.out.println(customer2);

    }
}
