package com.company.model;

public class Customer extends Person {
    private String phoneNumber;

    public Customer() {
    }

    public Customer(int id, String name, int age, String phoneNumber) {
        super(id, name, age);
        this.phoneNumber = phoneNumber;
    }

    public Customer(Person person, String phoneNumber) {
        super(person.getId(), person.getName(), person.getAge());
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString()+","+this.phoneNumber;
    }
}
