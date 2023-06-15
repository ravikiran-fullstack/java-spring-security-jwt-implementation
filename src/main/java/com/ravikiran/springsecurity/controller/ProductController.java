package com.ravikiran.springsecurity.controller;

import com.ravikiran.springsecurity.entity.Product;
import com.ravikiran.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this end point is not secure";
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        System.out.println("getAllProducts");
        return this.service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable  int id){
        return this.service.getProductById(id);
    }
}
