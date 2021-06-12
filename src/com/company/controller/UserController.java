package com.company.controller;

import com.company.file.IOOrder;
import com.company.model.Customer;
import com.company.model.Order;
import com.company.model.Product;
import com.company.service.CustomerService;
import com.company.service.OrderService;
import com.company.service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    public Scanner SCANNER = new Scanner(System.in);
    private CustomerService customerService;
    private ProductService productService;
    private OrderService orderService;
    private Order order;
    private IOOrder ioOrder = new IOOrder();
    //    private Customer customer;
    public UserController(){
        customerService = CustomerService.getInstance();
        productService = ProductService.getInstance();
        orderService = OrderService.getInstance();
    }

    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    public void createACustomer(Customer customer) {
        customerService.add(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerService.findAll();
    }

    public void buyAnProduct(Customer customer, Product product) throws IOException {
        if (order == null) {
            order = new Order();
            order.setCustomer(customer);
            order.addProduct(product);
            orderService.add(order);
        } else {
            for (Order order : orderService.findAll()) {
                if (order.getCustomer().getName().equals(this.order.getCustomer().getName())) {
                    order.addProduct(product);
                }
            }

        }
        ioOrder.write(IOOrder.PATH, orderService.findAll());
    }

    public List<Order> getAllOrder() {
        return orderService.findAll();
    }

    public void readFromFile() throws IOException {

        ioOrder.read(IOOrder.PATH);
    }
}
