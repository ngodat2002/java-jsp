package com.t2010a.applicationcustomer.model;

import com.t2010a.applicationcustomer.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(int Id);

    Customer update(int Id, Customer updateCustomer);

    boolean delete(int Id);
}
