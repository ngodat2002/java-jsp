package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.model.MYSQLProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditProductServletTest {
private MYSQLProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MYSQLProductModel();
    }

    @Test
    void doGet() {
    }

    @Test
    void doPost() {
        System.out.println(productModel.findAll());
    }
}