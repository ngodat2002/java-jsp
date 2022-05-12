package com.t2010a.applicationcustomer.model;

import com.t2010a.applicationcustomer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {
    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model =  new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
            4,
            "Ngo Chi Dat",
            "01289348329",
            "dat.jpg",
            LocalDateTime.of(2003,10,10,10,10)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer student = model.findById(1);
        System.out.println(student.toString());
    }

    @Test
    void update() {
        Customer customer = model.findById(1);
        customer.setName("Nguyen Thanh Tam");
        model.update(1, customer);
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }

    @Test
    void delete() {
        model.delete(1);
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}