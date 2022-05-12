package com.t2010a.applicationcustomer.model;

import com.t2010a.applicationcustomer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySQLCustomerModelTest {
    CustomerModel model;
    @BeforeEach
    void setUp() {
        model = new MySQLCustomerModel();
    }

    @Test
    void save() {
        model.save(new Customer("Nguyen Thanh Tam","0938329","dat9.jpg", LocalDateTime.of(2001,10,10,10,10)));

    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer cs:
        list){
            System.out.println(cs.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = model.findById(1);
        assertEquals("Ngo chi thanh dat",customer.getName());
    }

    @Test
    void update() {
        Customer customer = model.findById(1);
        customer.setName("Ngo Dat Thanh");
        model.update(1,customer);
        Customer newUpdateCustomer = model.findById(1);
        assertEquals("Ngo Dat Thanh",newUpdateCustomer.getName());
    }

    @Test
    void delete() {
        model.delete(2);
        Customer customer = model.findById(1);
        assertEquals(null, customer);
    }
}