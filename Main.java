package com.company.view;

import com.company.controller.UserController;
import com.company.model.Customer;
import com.company.model.Order;
import com.company.model.Product;
import com.company.service.ProductService;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        UserController userController = new UserController();
        printProducts(userController.getAllProduct());
        userController.createACustomer(new Customer(1, "Như Anh", 20, "123"));
        printCustomers(userController.getAllCustomer());
        userController.buyAnProduct(userController.getAllCustomer().get(0), userController.getAllProduct().get(0));
        userController.buyAnProduct(userController.getAllCustomer().get(0), userController.getAllProduct().get(1));

        UserController userController1 = new UserController();
        userController1.createACustomer(new Customer(2, "Tiến Bịp", 20, "123"));
        userController1.buyAnProduct(userController1.getAllCustomer().get(1), userController1.getAllProduct().get(0));
        userController1.buyAnProduct(userController1.getAllCustomer().get(1), userController1.getAllProduct().get(2));
        printOrders(userController1.getAllOrder());

        userController.readFromFile();
    }

    public static void printProducts(List<Product> objects) {
        for (Product object : objects) {
            System.out.println(object);
        }
    }

    public static void printCustomers(List<Customer> objects) {
        for (Customer object : objects) {
            System.out.println(object);
        }
    }

    public static void printOrders(List<Order> objects) {
        for (Order object : objects) {
            System.out.println(object);
        }
    }
}
