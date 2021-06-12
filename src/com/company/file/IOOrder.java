package com.company.file;

import com.company.model.Customer;
import com.company.model.Order;
import com.company.model.Product;
import com.company.service.CustomerService;
import com.company.service.OrderService;
import com.company.service.ProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOOrder implements IO<Order> {
    public static final String PATH = "orders.csv";
    ProductService productService;
    CustomerService customerService;
    OrderService orderService;

    @Override
    public void write(String path, List<Order> list) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String string = "id,tên khách hàng,danh sách sản phẩm,tổng tiền\n";
        for (Order order : list) {
            string += order.toString() + "\n";
        }
        bufferedWriter.write(string);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Override
    public List<Order> read(String path) throws IOException {
        productService = ProductService.getInstance();
        customerService = CustomerService.getInstance();
        orderService = OrderService.getInstance();
        List<Order> orders = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {

            String[] values = line.split(","); //cắt giá trị từ 1 dòng
            String[] products = values[2].split("_"); // lấy ra tên các sản phẩm

            Order order = new Order();
            order.setId(Integer.parseInt(values[0]));
            order.setTotal(Integer.parseInt(values[3]));

            Customer customer = customerService.findByName(values[1]);// tìm khách hàng theo tên vừa đọc được
            order.setCustomer(customer);

            List<Product> productList = new ArrayList<>();
            for (int i = 0; i < products.length; i++) {
                Product product = productService.findByName(products[i]); //tìm sản phẩm theo tên vừa đọc được
                productList.add(product);

            }
            order.setProducts(productList);
            orders.add(order);
        }
        orderService.setOrders(orders);
        return null;
    }
}
