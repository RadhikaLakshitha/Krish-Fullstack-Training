package com.company;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String mobile;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString(){
        return "Customer: " +this.firstName+","+this.lastName+","+this.address+","+this.mobile;
    }


    private Customer(UserBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.mobile = builder.mobile;



    }

    public  static class UserBuilder{
        private final String firstName;
        private final String lastName;
        private  String address;
        private String mobile;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder address(String address){
            this.address = address;
            return this;

        }

        public UserBuilder mobile(String mobile){
            this.mobile = mobile;
            return this;

        }

        public  Customer build(){
            Customer customer = new Customer(this);
            validateCustomer(customer);
            return customer;
        }

        private void validateCustomer(Customer customer) {
            // any validations
        }
    }



}
