package com.ravikiran.springsecurity.service;

import com.ravikiran.springsecurity.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<Product>();

    @PostConstruct
    public void loadProductsFromDB(){
        productList.add(new Product(1, "product1", 4, 89.5));
        productList.add(new Product(2, "product2", 21, 9.4));
        productList.add(new Product(3, "product3", 87, 2.7));
        productList.add(new Product(4, "product4", 9, 112.9));
        productList.add(new Product(5, "product5", 34, 20.6));
    }

    public List<Product> getAllProducts() {
        System.out.println("In Service getAllProducts");
        return productList;
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("product "+id+" not found"));
    }
}
