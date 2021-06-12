package com.company.service;

import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements GeneralService<Product> {
    List<Product> products;


    private static final ProductService productService = new ProductService();

    private ProductService() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "IPX", 1200));
        products.add(new Product(2, "IP11", 1500));
        products.add(new Product(3, "IP12", 1800));
    }

    public static ProductService getInstance() {
        return productService;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void edit(int id, Product newProduct) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
            }
        }
    }

    @Override
    public void delete(int id) {
        products.remove(findById(id));
    }
}
