package com.t2010a.applicationcustomer.model;
import com.t2010a.applicationcustomer.entity.Customer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel {
    private  static  List<Customer> customers;
    public InMemoryCustomerModel(){
        customers =  new ArrayList<>();
        customers.add(
                new Customer(
                        1,
                        "Ngo Dat",
                        "0187826328",
                        "dat.jpg",
                        LocalDateTime.of(2003,10,10,10,10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        2,
                        "Ngo Chi Thanh Dat",
                        "09888888",
                        "dat1.jpg",
                        LocalDateTime.of(2006,10,10,10,10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }
    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int Id) {
        Customer foundCustomer = null;
        for (Customer customer:
             customers) {
            if (customer.getId()==Id){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(int Id, Customer updateCustomer) {
        Customer existingCustomer =  findById(Id);
        if (existingCustomer==null){
            return  null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(updateCustomer.getUpdatedAt());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(int Id) {
        int foundIndex = -1;
        for (int i =0 ;i<customers.size();i++){
            if (customers.get(i).getId()==Id){
                foundIndex=i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
