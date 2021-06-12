package com.company.service;

import com.company.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements GeneralService<Customer> {

    List<Customer> customers;
    private static final CustomerService customerService = new CustomerService();

    private CustomerService() {
        this.customers = new ArrayList<>();
    }

    public static CustomerService getInstance() {
        return customerService;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    public Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void edit(int id, Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}
