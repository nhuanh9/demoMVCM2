package com.company.model;

public class Staff extends Person {
    private int salary;

    public Staff() {
    }

    public Staff(int id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public Staff(Person person, int salary) {
        super(person.getId(), person.getName(), person.getAge());
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.salary;
    }
}
