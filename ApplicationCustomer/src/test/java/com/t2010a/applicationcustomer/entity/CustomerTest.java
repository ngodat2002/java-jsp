package com.t2010a.applicationcustomer.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest  {
    @Test
    public  void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Ngo Chi Thanh Dat");
        customer.setPhone("03987323");
        customer.setImage("dat.jpg");
        customer.setDob(LocalDateTime.of(2002, 10, 22, 10, 10));
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setStatus(1);
        System.out.println(customer.toString());
    }

}