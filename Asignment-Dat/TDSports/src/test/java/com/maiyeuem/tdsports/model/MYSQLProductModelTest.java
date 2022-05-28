package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MYSQLProductModelTest {
private ProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MYSQLProductModel();
    }

    @Test
    void save() {
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("Bag Gucci");
        product.setPrice(100000);
        product.setDescription("Lorem ipsum");
        product.setDetail("Lorem ipsum");
        product.setImage("Lorem ipsum");
        productModel.save(product);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
        Product product = productModel.findById(1);
        assertNotEquals(null,product);
    }

    @Test
    void delete() {
    }

    @Test
    void findProductById(){
        List<Product> product = productModel.findProductById(1);
        System.out.println(product.toString());
    }
}