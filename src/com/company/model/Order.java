package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<Product> products;
    private int total;
    private int status;

    public Order() {
        this.products = new ArrayList<>();
        this.customer = new Customer();
        calculateTotal();
        status = 1;
    }

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
        calculateTotal();
        status = 1;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.total += product.getPrice();
    }

    private void calculateTotal() {
        for (Product product : this.products) {
            this.total += product.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String str = id + "," + customer.getName() + ",";
        for (int i = 0; i < this.products.size() - 1; i++) {
            str += this.products.get(i).getName() + "_";
        }
        str += this.products.get(this.products.size() - 1).getName() + "," + total;
        return str;
    }
}
