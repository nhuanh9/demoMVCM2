package com.company.service;

import com.company.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements GeneralService<Order> {
    List<Order> orders;
    private static final OrderService orderService = new OrderService();

    public static OrderService getInstance() {
        return orderService;
    }

    public OrderService() {
        this.orders = new ArrayList<>();
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }


    @Override
    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void edit(int id, Order order) {
        for (Order order1 : orders) {
            if (order1.getId() == id) {
                order1.setCustomer(order.getCustomer());
                order1.setProducts(order.getProducts());
                order1.setTotal(order.getTotal());
                order1.setStatus(order.getStatus());
            }
        }
    }

    @Override
    public void delete(int id) {
        orders.remove(findById(id));
    }
}
