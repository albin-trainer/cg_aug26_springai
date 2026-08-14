package com.example.service;

import com.example.product.Product;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    private Environment env;
    public List<Product> getAllProducts() {
        String port = env.getProperty("server.port");
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProdId(1);
        product1.setProductName("Pen");
        product1.setPrice(9.99f);
        product1.setPortNo(port);
        products.add(product1);

        Product product2 = new Product();
        product2.setProdId(2);
        product2.setProductName("Eraser");
        product2.setPrice(19.99f);
        product2.setPortNo(port);
        products.add(product2);

        return products;
    }

    public Product getProductById(int pid) {
        return getAllProducts().stream()
                .filter(product -> product.getProdId() == pid)
                .findFirst()
                .orElse(null);
    }
}
